import { randomUUID } from 'node:crypto';
import { Replace } from 'src/utils/replace';

export interface ProduitProps {
  designation: string;
  vignette: string;
  prixAchatHT: number;
  prixVenteTC: number;
  prixEmporteTC: number;
  refArticleFournisseur: boolean;
  qteStock: boolean;
  qteMin: boolean;
  cuisson: boolean;
  accompagnement: boolean;
  gererStock: boolean;
  accompagnements: boolean;
  createdAt: Date;
  updatedAt?: Date | null;
}

export class Produit {
  private props: ProduitProps;
  private _id: string;

  constructor(props: Replace<ProduitProps, { createdAt?: Date }>, id?: string) {
    this._id = !id ? randomUUID() : id;

    this.props = {
      ...props,
      createdAt: props.createdAt || new Date(),
    };
  }

  public get id(): string {
    return this._id;
  }

  public set designation(designation: string) {
    this.props.designation = designation;
  }

  public get designation(): string {
    return this.props.designation;
  }

  public set vignette(vignette: string) {
    this.props.vignette = vignette;
  }

  public get vignette(): string {
    return this.props.vignette;
  }

  public set prixAchatHT(prixAchatHT: number) {
    this.props.prixAchatHT = prixAchatHT;
  }

  public get prixAchatHT(): number {
    return this.props.prixAchatHT;
  }

  public set prixVenteTC(prixVenteTC: number) {
    this.props.prixVenteTC = prixVenteTC;
  }

  public get prixVenteTC(): number {
    return this.props.prixVenteTC;
  }

  public set prixEmporteTC(prixEmporteTC: number) {
    this.props.prixEmporteTC = prixEmporteTC;
  }

  public get prixEmporteTC(): number {
    return this.props.prixEmporteTC;
  }

  public set refArticleFournisseur(refArticleFournisseur: boolean) {
    this.props.refArticleFournisseur = refArticleFournisseur;
  }

  public get refArticleFournisseur(): boolean {
    return this.props.refArticleFournisseur;
  }

  public set qteStock(qteStock: boolean) {
    this.props.qteStock = qteStock;
  }

  public get qteStock(): boolean {
    return this.props.qteStock;
  }

  public set qteMin(qteMin: boolean) {
    this.props.qteMin = qteMin;
  }

  public get qteMin(): boolean {
    return this.props.qteMin;
  }

  public set cuisson(cuisson: boolean) {
    this.props.cuisson = cuisson;
  }

  public get cuisson(): boolean {
    return this.props.cuisson;
  }

  public set accompagnement(accompagnement: boolean) {
    this.props.accompagnement = accompagnement;
  }

  public get accompagnement(): boolean {
    return this.props.accompagnement;
  }

  public set gererStock(gererStock: boolean) {
    this.props.gererStock = gererStock;
  }

  public get gererStock(): boolean {
    return this.props.gererStock;
  }

  public set accompagnements(accompagnements: boolean) {
    this.props.accompagnements = accompagnements;
  }

  public get accompagnements(): boolean {
    return this.props.accompagnements;
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
