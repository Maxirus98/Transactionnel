import { Citoyen } from "./citoyen";

export class Permis {
    typePermis:string;
    isPermisAdulte: boolean = true;
    citoyen: Citoyen;
    
    constructor(citoyen: Citoyen) {
        this.citoyen = citoyen;
        if (citoyen.age < 18) {
            this.isPermisAdulte = false;
        }
    }
}
