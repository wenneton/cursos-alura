class Negociacao {

    private _volume: number;

    constructor(private _data: Date, private _quantidade: number, private _valor: number){
        this._volume = _quantidade * _valor;
    }

    get data(){
        return this._data;
    }
    
    get quantidade(){
        return this._quantidade;
    }

    get valor(){
        return this._valor;
    }

    get volume(){
        return this._volume;
    }
}