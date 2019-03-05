## Configurações para o correto funcionamento:

* Iniciar o projeto:

```console
~$ npm init
```
* Acrescentar os termos "compile" e "start" em package.json conforme a seguir:

```json
...
"scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "compile": "tsc",
    "start": "tsc -w"
  }
...
```

* Para o curso realizado, foi instalada a versão 2.3.2 do TypeScript, conforme a seguir:

```console
~$ npm install typescript@2.3.2 --save-dev
```
 
* Executar o comando ```npm start``` para o compilamento em tempo real.

* Para utilizar o jquery no desenvolvimento do código em TypeScript sem o aparecimento de erros, executar o comando abaixo:

```console
~$ npm install @types/jquery@2.0.42 --save-dev
```

**Obs:** Foi utilizado a versão 2.0.42 do JQuery para esta aplicação.

## Opções do arquivo tsconfig.json

```json
"noEmitOnError": true, # não gera os arquivo .js em caso de erro de compilamento
"noImplicitAny": true, # obriga a tipagem das variáveis
"removeComments": true # remove os comentários dos arquivos .js gerados
```
