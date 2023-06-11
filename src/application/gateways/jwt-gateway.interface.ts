import { Payload } from './types';

export abstract class JWtGatewayInterface {
  abstract signAsync(payload: Payload): Promise<string>;
}
