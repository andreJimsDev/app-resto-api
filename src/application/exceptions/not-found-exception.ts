import { HttpException, HttpStatus } from '@nestjs/common';

export class NotFoundException extends HttpException {
  details?: Record<string, unknown>;

  private constructor(
    message: string,
    status = HttpStatus.NOT_FOUND,
    details?: Record<string, unknown>,
  ) {
    super(message, status);
    this.details = details;

    HttpException.captureStackTrace(this, NotFoundException);
  }

  public static execute(
    message: string,
    details?: Record<string, unknown>,
  ): NotFoundException {
    return new NotFoundException(message, HttpStatus.NOT_FOUND, details);
  }
}
