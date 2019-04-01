export class Negociacao {

    readonly volume: number;

    constructor(readonly data: Date, readonly quantidade: number, readonly valor: number){
        this.volume = quantidade * valor;
    }
}