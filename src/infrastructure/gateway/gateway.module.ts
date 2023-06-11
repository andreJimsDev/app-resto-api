import { Module } from '@nestjs/common';

import { JWtGatewayInterface } from '../../application/gateways/jwt-gateway.interface';
import { JwtGateway } from './JwtGateway';
import { JwtModule } from '@nestjs/jwt';

const jwtConstants = {
  secret:
    'DO NOT USE THIS VALUE. INSTEAD, CREATE A COMPLEX SECRET AND KEEP IT SAFE OUTSIDE OF THE SOURCE CODE.',
};

@Module({
  imports: [
    JwtModule.register({
      global: true,
      secret: jwtConstants.secret,
      signOptions: { expiresIn: '1d' },
    }),
  ],
  providers: [
    {
      provide: JWtGatewayInterface,
      useClass: JwtGateway,
    },
  ],
  exports: [
    {
      provide: JWtGatewayInterface,
      useClass: JwtGateway,
    },
  ],
})
export class GatewayModule {}
