import { Injectable } from '@nestjs/common';
import { UseCase } from '../use-case';
import { UserRepository } from '@/application/repositories/user-repository';
import { User } from '@/application/entities/user';
import * as bcrypt from 'bcrypt';

export interface CreateUserCommand {
  username: string;
  password: string;
}

export interface CreateUserResponse {
  id: string;
  username: string;
  createdAt: Date;
}

@Injectable()
export class CreateUserUseCase
  implements UseCase<CreateUserCommand, CreateUserResponse>
{
  constructor(private readonly repository: UserRepository) {}

  async execute(command: CreateUserCommand): Promise<CreateUserResponse> {
    const saltOrRounds = 10;
    const passwordHashed = await bcrypt.hash(command.password, saltOrRounds);
    const user = new User({
      ...command,
      password: passwordHashed,
      roles: ['SERVEUR'],
    });

    await this.repository.create(user);

    return {
      id: user.id,
      username: user.username,
      createdAt: user.createdAt,
    };
  }
}
