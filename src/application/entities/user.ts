import { randomUUID } from 'node:crypto';
import { Replace } from 'src/utils/replace';

export interface UserProps {
  username: string;
  password: string;
  roles: string[];
  createdAt: Date;
  updatedAt?: Date | null;
}

export class User {
  private props: UserProps;
  private _id: string;

  constructor(props: Replace<UserProps, { createdAt?: Date }>, id?: string) {
    this._id = !id ? randomUUID() : id;

    this.props = {
      ...props,
      createdAt: props.createdAt || new Date(),
    };
  }

  public get id(): string {
    return this._id;
  }

  public set username(username: string) {
    this.props.username = username;
  }

  public get username(): string {
    return this.props.username;
  }

  public set password(password: string) {
    this.props.password = password;
  }

  public get password(): string {
    return this.props.password;
  }

  public set roles(roles: string[]) {
    this.props.roles = roles;
  }

  public get roles(): string[] {
    return this.props.roles;
  }

  public set updatedAt(updatedAt: Date | null | undefined) {
    this.props.updatedAt = updatedAt;
  }

  public get updatedAt(): Date | null | undefined {
    return this.props.updatedAt;
  }

  public get createdAt(): Date {
    return this.props.createdAt;
  }
}
