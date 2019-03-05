const negociacao = new Negociacao(new Date(), 1, 100);

const controller = new NegociacaoController();

const negociacoes = new Negociacoes();



$('.form').submit(controller.adiciona.bind(controller));
