import { JWtGatewayInterface } from '@/application/gateways/jwt-gateway.interface';
import { Payload } from '@/application/gateways/types';
import { Injectable } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';

@Injectable()
export class JwtGateway implements JWtGatewayInterface {
  constructor(private readonly jwtService: JwtService) {}

  signAsync(payload: Payload): Promise<string> {
    return this.jwtService.signAsync(payload);
  }
}
