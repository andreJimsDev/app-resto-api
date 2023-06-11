import { Body, Controller, Post } from '@nestjs/common';
import { ApiResponse, ApiTags } from '@nestjs/swagger';
import { UserDto } from '../dtos/user-dto';
import { SignInUseCase } from '@/application/use-cases/auth/sign-in.usecase';
import { Public } from '../decorator/public.decorator';

@Controller('auth')
@ApiTags('auth')
export class AuthController {
  constructor(private readonly signInUseCase: SignInUseCase) {}

  @Public()
  @Post('/signIn')
  @ApiResponse({
    status: 201,
    description: 'The user has been successfully connected.',
  })
  @ApiResponse({
    status: 500,
    description: 'Internal server error.',
  })
  async signIn(@Body() body: UserDto) {
    return this.signInUseCase.execute({ ...body });
  }
}
