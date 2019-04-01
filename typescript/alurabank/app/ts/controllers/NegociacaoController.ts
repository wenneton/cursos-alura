import {Negociacoes, Negociacao, NegociacaoParcial} from '../models/index';
import {NegociacoesView, MensagemView} from '../views/index';
import { DomInject } from '../helpers/decorators/DomInject';
import { Throttle } from '../helpers/decorators/index';
import {NegociacaoService} from '../services/index';

export class NegociacaoController {

    @DomInject('#data')
    private _inputData: JQuery;

    @DomInject('#quantidade')
    private _inputQuantidade: JQuery;

    @DomInject('#valor')
    private _inputValor: JQuery;

    private _negociacoes = new Negociacoes();
    private _negociacoesView = new NegociacoesView('#negociacoesView');
    private _mensagemView = new MensagemView('#mensagemView');
    private _negociacaoService = new NegociacaoService();

    constructor() {
        this._negociacoesView.update(this._negociacoes);
    }

    @Throttle()
    adiciona() {
        let data = new Date(this._inputData.val().replace(/-/g, '.'));

        if (!this._ehDiaUtil(data)){
            this._mensagemView.update('Somente negociações em dia úteis!');
            return;
        }

        const negociacao = new Negociacao(
            new Date(this._inputData.val().replace(/-/g, ',')),
            parseInt(this._inputQuantidade.val()),
            parseFloat(this._inputValor.val()));

        this._negociacoes.adiciona(negociacao);

        this._negociacoesView.update(this._negociacoes);

        this._mensagemView.update("Negociacão adicionada com sucesso!");
    }

    private _ehDiaUtil(data: Date){
        return (data.getDay() != DiaDaSemana.Sabado) && (data.getDay() != DiaDaSemana.Domingo);
    }

    @Throttle(1000)
    importaDados() {

        function isOk(res: Response){

            if(res.ok){
                return res;
            } else {
                throw new Error(res.statusText);
            }
        }

        this._negociacaoService.obterNegociacoes(isOk)
            .then(negociacoes => {negociacoes
                .forEach(negociacao => this._negociacoes.adiciona(negociacao));
            this._negociacoesView.update(this._negociacoes);     
            });
    }

}

enum DiaDaSemana {

    Domingo,
    Segunda, 
    Terca,
    Quarta,
    Quinta,
    Sexta,
    Sabado
}