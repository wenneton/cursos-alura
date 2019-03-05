class Negociacao {

    constructor(data, quantidade, valor){
        
        this._data = new Date(data.getTime()); //impede alguém de alterar a data
        this._quantidade = quantidade;
        this._valor= valor;

        Object.freeze(this);
    }

    get data(){
        return new Date(this._data.getTime()); //impede alguém de alterar a data sem permissão
    }
    
    get quantidade(){
        return this._quantidade;
    }

    get valor(){
        return this._valor;
    }

    get volume(){
        return this._quantidade * this._valor;
    }
}