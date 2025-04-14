
# Título do Projeto

Projeto que faz parte do conteúdo de avaliação da formação Java Backend ministrado pela Alura em parceria com o Projeto: ONE Oracle Next Education.

O desafio proposto e apresentado no código é um programa que converte valores de diferentes Moedas.

Para tanto é utilizado conexão com API externo afim de trazer dados dinâmicos e em tempo real das cotações das moedas.

A dinâmica de utilização do programa é apresentar um menu de opções , onde o usuário entra via teclado com a opção desejada e o montante de moeda que deseja converter.

O resultado da conversão é apresentado no console até que seja selecionada a opção de saída.


## Conversor de moeda com uso de API externa.
## Autores

- [@octokatherine](https://www.github.com/andrecosmos/)


## Apêndice

Coloque qualquer informação adicional aqui


## Documentação da API
 ## MENU DE ENTRADA DE DADOS /CLASSE MAIN

 String Menu = """
                \n
                -----------------------------------------------------------------------------
                -----------------------------------------------------------------------------
                ->>>>>>> Digite o Tipo de Conversão Desejada :
                1 - Dólar ___________-->>>>>> Peso Argentino
                2 - Peso Argentino___-->>>>>> Dólar
                3 - Dólar ___________-->>>>>> Real Brasileiro
                4 - Real Brasileiro__-->>>>>> Dólar
                5 - Dólar ___________-->>>>>> Peso Colombiano
                6 - Peso Colombiano__-->>>>>> Dólar
                7 - Sair
                ------------------------------------------------------------------------------
                ------------------------------------------------------------------------------
                """;

# REQUISIÇÃO AO AMBIENTE EXTERNO / CLASSE BUSCAR COTAÇÃO

 public Cotacao buscarCotacao(String moeda, double valor, String conv) {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/8322dbc257216409fb293439/latest/" + conv);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

# TRATAMENTO DE EXCEÇÕES EFORMATAÇÃO DE RETORNO / CLASSE BUSCAR COTAÇÃO

try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            JsonObject conversoes = json.getAsJsonObject("conversion_rates");
            double taxa = conversoes.get(moeda).getAsDouble();

            double resultado = taxa * valor;
            return new Cotacao(moeda, resultado);


        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a cotação.");
        }

# SAÍDA 

----------------------------------------------------------------------------
->>>>>>> Digite o Tipo de Conversão Desejada :
1 - Dólar ___________-->>>>>> Peso Argentino
2 - Peso Argentino___-->>>>>> Dólar
3 - Dólar ___________-->>>>>> Real Brasileiro
4 - Real Brasileiro__-->>>>>> Dólar
5 - Dólar ___________-->>>>>> Peso Colombiano
6 - Peso Colombiano__-->>>>>> Dólar
7 - Sair
------------------------------------------------------------------------------
------------------------------------------------------------------------------

3
Digite quanto quer converter:
100

 Valor de 100.0 [USD] Corresponde a : 585.3399999999999 [BRL]
