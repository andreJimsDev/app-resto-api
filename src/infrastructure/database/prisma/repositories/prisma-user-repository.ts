import { Injectable } from '@nestjs/common';
import { User } from '@/application/entities/user';
import { UserRepository } from '@/application/repositories/user-repository';
import { PrismaService } from '../prisma.service';
import { PrismaUserMapper } from '../mappers/prisma-users-mapper';

@Injectable()
export class PrismaUserRepository implements UserRepository {
  constructor(private readonly prismaService: PrismaService) {}

  async create(user: User): Promise<void> {
    const userPrismaData = PrismaUserMapper.toPrisma(user);

    await this.prismaService.user.create({
      data: userPrismaData,
    });
  }

  async findById(id: string): Promise<User | null> {
    const userPrismaData = await this.prismaService.user.findUnique({
      where: { id },
    });

    if (!userPrismaData) {
      return null;
    }

    const user = PrismaUserMapper.toDomain(userPrismaData);

    return user;
  }

  async save(user: User): Promise<void> {
    const userPrismaData = PrismaUserMapper.toPrisma(user);

    await this.prismaService.user.update({
      where: { id: user.id },
      data: userPrismaData,
    });
  }

  async findByUserName(username: string): Promise<User | null> {
    const userPrismaData = await this.prismaService.user.findUnique({
      where: { username },
    });

    if (!userPrismaData) {
      return null;
    }

    return PrismaUserMapper.toDomain(userPrismaData);
  }
}
