import { User } from '@/application/entities/user';
import { User as PrismaUser, Role } from '@prisma/client';
export class PrismaUserMapper {
  private constructor() {
    throw new Error(
      'PrismaUserMapper is a static class and should not be instantiated',
    );
  }

  public static toPrisma(user: User): PrismaUser {
    return {
      id: user.id,
      username: user.username,
      password: user.password,
      createdAt: user.createdAt,
      roles: user.roles.map((el) => Role[el]),
      updatedAt: user.updatedAt ?? null,
    };
  }

  public static toDomain(userPrismaData: PrismaUser) {
    return new User(
      {
        username: userPrismaData.username,
        password: userPrismaData.password,
        roles: userPrismaData.roles,
        createdAt: userPrismaData.createdAt,
        updatedAt: userPrismaData.updatedAt ?? null,
      },
      userPrismaData.id,
    );
  }
}
