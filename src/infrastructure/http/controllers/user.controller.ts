import { Body, Controller, Post } from '@nestjs/common';
import { ApiResponse, ApiTags } from '@nestjs/swagger';
import { UserDto } from '../dtos/user-dto';
import { CreateUserUseCase } from '@/application/use-cases/user/create-user.usecase';
import { Roles } from '../decorator/roles.decorator';
import { Role } from '@prisma/client';

@Controller('user')
@ApiTags('user')
export class UserController {
  constructor(private readonly createUserUseCase: CreateUserUseCase) {}

  @Roles(Role.ADMIN)
  @Post('/create')
  @ApiResponse({
    status: 201,
    description: 'The user has been successfully created.',
  })
  @ApiResponse({
    status: 500,
    description: 'Internal server error.',
  })
  async createUser(@Body() body: UserDto) {
    return this.createUserUseCase.execute({ ...body });
  }
}
