import { Igualavel } from "./Igualavel";

export class Negociacao implements Igualavel<Negociacao> {

    readonly volume: number;

    constructor(readonly data: Date, readonly quantidade: number, readonly valor: number){
        this.volume = quantidade * valor;
    }

    ehIgual(negociacao: Negociacao): boolean {
        return this.data.getDate() == negociacao.data.getDate() &&
            this.data.getMonth() == negociacao.data.getMonth() &&
            this.data.getFullYear() == negociacao.data.getFullYear();
    }
}