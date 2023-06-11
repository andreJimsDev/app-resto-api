import { Injectable, UnauthorizedException } from '@nestjs/common';
import * as bcrypt from 'bcrypt';
import { UseCase } from '../use-case';
import { UserRepository } from '../../repositories/user-repository';
import { JWtGatewayInterface } from '../../gateways/jwt-gateway.interface';
import { NotFoundException } from '../../exceptions/not-found-exception';

export interface SignInUseCaseRequest {
  username: string;
  password: string;
}

export interface SignInUseCaseResponse {
  access_token: string;
}

@Injectable()
export class SignInUseCase
  implements UseCase<SignInUseCaseRequest, SignInUseCaseResponse>
{
  constructor(
    private readonly repository: UserRepository,
    private readonly jwtGateway: JWtGatewayInterface,
  ) {}

  async execute(request: SignInUseCaseRequest): Promise<SignInUseCaseResponse> {
    const { username, password } = request;

    const user = await this.repository.findByUserName(username);
    if (!user) {
      throw NotFoundException.execute('User is not found');
    }
    const isMatch = await bcrypt.compare(password, user.password);
    if (!isMatch) {
      throw new UnauthorizedException();
    }
    const payload = {
      sub: user.id,
      username: user.username,
      roles: user.roles,
    };
    return {
      access_token: await this.jwtGateway.signAsync(payload),
    };
  }
}
