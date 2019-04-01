import { Negociacao } from './Negociacao';
import {LogarTempoDeExecucao} from '../helpers/decorators/index';
import {Igualavel} from './Igualavel';

export class Negociacoes implements Igualavel<Negociacoes> {

    private _negociacoes: Array<Negociacao> = [];

    adiciona(negociacao: Negociacao) {

        this._negociacoes.push(negociacao);
    }

    paraArray(): Array<Negociacao> {
        return this._negociacoes;
    }

    ehIgual(negociacoes: Negociacoes): boolean {
        return JSON.stringify(this._negociacoes) == JSON.stringify(negociacoes.paraArray());
    }
}