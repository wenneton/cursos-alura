export abstract class View<T> {

    private _elemento: JQuery;

    constructor(seletor: string) {

        this._elemento = $(seletor);
    }

    update(modelo: T) {
        this._elemento.html(this.template(modelo));
    }

    protected abstract template(modelo:T): string;

}