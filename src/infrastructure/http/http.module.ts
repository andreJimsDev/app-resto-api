import { Module } from '@nestjs/common';
import { DatabaseModule } from '../database/database.module';
import { AuthController } from './controllers/auth.controller';
import { SignInUseCase } from '@/application/use-cases/auth/sign-in.usecase';
import { GatewayModule } from '../gateway/gateway.module';
import { UserController } from './controllers/user.controller';
import { CreateUserUseCase } from '@/application/use-cases/user/create-user.usecase';
import { APP_GUARD } from '@nestjs/core';
import { RolesGuard } from './guard/roles.guard';

@Module({
  imports: [DatabaseModule, GatewayModule],
  controllers: [AuthController, UserController],
  providers: [
    SignInUseCase,
    CreateUserUseCase,
    {
      provide: APP_GUARD,
      useClass: RolesGuard,
    },
  ],
})
export class HttpModule {}
