import { Citoyen } from './citoyen';

export class Permis {
  idPermis: number;
  dateDebut: Date;
  typePermis: string;
  dateFin: Date;
  expired: boolean;

  citoyen: Citoyen;

  constructor(citoyen: Citoyen) {
    this.citoyen = citoyen;
    this.expired = false;
  }
}
