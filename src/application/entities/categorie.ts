import { randomUUID } from 'node:crypto';
import { Replace } from 'src/utils/replace';

export interface CategorieProps {
  nom: string;
  tvaSurPlace: number;
  tvaEmporte: number;
  imprimanteTicket: boolean;
  imprimanteCuisine1: boolean;
  imprimanteCuisine2: boolean;
  imprimanteCuisine3: boolean;
  imprimanteCuisine4: boolean;
  visibleCarte1: boolean;
  visibleCarte2: boolean;
  createdAt: Date;
  updatedAt?: Date | null;
}

export class Categorie {
  private props: CategorieProps;
  private _id: string;

  constructor(
    props: Replace<CategorieProps, { createdAt?: Date }>,
    id?: string,
  ) {
    this._id = !id ? randomUUID() : id;

    this.props = {
      ...props,
      createdAt: props.createdAt || new Date(),
    };
  }

  public get id(): string {
    return this._id;
  }

  public set nom(nom: string) {
    this.props.nom = nom;
  }

  public get nom(): string {
    return this.props.nom;
  }

  public set tvaSurPlace(tvaSurPlace: number) {
    this.props.tvaSurPlace = tvaSurPlace;
  }

  public get tvaSurPlace(): number {
    return this.props.tvaSurPlace;
  }

  public set tvaEmporte(tvaEmporte: number) {
    this.props.tvaEmporte = tvaEmporte;
  }

  public get tvaEmporte(): number {
    return this.props.tvaEmporte;
  }

  public set imprimanteTicket(imprimanteTicket: boolean) {
    this.props.imprimanteTicket = imprimanteTicket;
  }

  public get imprimanteTicket(): boolean {
    return this.props.imprimanteTicket;
  }

  public set imprimanteCuisine1(imprimanteCuisine1: boolean) {
    this.props.imprimanteCuisine1 = imprimanteCuisine1;
  }

  public get imprimanteCuisine1(): boolean {
    return this.props.imprimanteCuisine1;
  }

  public set imprimanteCuisine2(imprimanteCuisine2: boolean) {
    this.props.imprimanteCuisine2 = imprimanteCuisine2;
  }

  public get imprimanteCuisine2(): boolean {
    return this.props.imprimanteCuisine2;
  }

  public set imprimanteCuisine3(imprimanteCuisine3: boolean) {
    this.props.imprimanteCuisine3 = imprimanteCuisine3;
  }

  public get imprimanteCuisine3(): boolean {
    return this.props.imprimanteCuisine3;
  }

  public set imprimanteCuisine4(imprimanteCuisine4: boolean) {
    this.props.imprimanteCuisine4 = imprimanteCuisine4;
  }

  public get imprimanteCuisine4(): boolean {
    return this.props.imprimanteCuisine4;
  }

  public set visibleCarte1(visibleCarte1: boolean) {
    this.props.visibleCarte1 = visibleCarte1;
  }

  public get visibleCarte1(): boolean {
    return this.props.visibleCarte1;
  }

  public set visibleCarte2(visibleCarte2: boolean) {
    this.props.visibleCarte2 = visibleCarte2;
  }

  public get visibleCarte2(): boolean {
    return this.props.visibleCarte2;
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
