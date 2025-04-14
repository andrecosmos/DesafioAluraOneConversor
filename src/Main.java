import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String Menu = """
                \n
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
                """;


        Scanner leitura = new Scanner(System.in);

        int operacao = 0;
        while (operacao != 7) {
            System.out.println(Menu);
            operacao = leitura.nextInt();


            if (operacao == 1) {

                System.out.println("Digite quanto quer converter:");
                var valor = leitura.nextDouble();
                BuscarCotacao buscarcotacao = new BuscarCotacao();
                Cotacao novaCotacao = buscarcotacao.buscarCotacao("ARS", valor,"USD" );

                System.out.println("\n Valor de " + valor + "  [USD] Corresponde a : " + novaCotacao.valor() + "[ARS]");


            } else if (operacao == 2) {

                System.out.println("Digite quanto quer converter:");
                var valor = leitura.nextDouble();
                BuscarCotacao buscarcotacao = new BuscarCotacao();
                Cotacao novaCotacao = buscarcotacao.buscarCotacao("USD", valor, "ARS");

                System.out.println("\n Valor de " + valor + "  [ARS] Corresponde a : " + novaCotacao.valor() + "[USD]");

            }

         else if (operacao == 3) {

            System.out.println("Digite quanto quer converter:");
            var valor = leitura.nextDouble();
            BuscarCotacao buscarcotacao = new BuscarCotacao();
            Cotacao novaCotacao = buscarcotacao.buscarCotacao("BRL", valor, "USD");

            System.out.println("\n Valor de " + valor + " [USD] Corresponde a : " + novaCotacao.valor() + " [BRL]");

        }

         else if(operacao == 4) {

            System.out.println("Digite quanto quer converter:");
            var valor = leitura.nextDouble();
            BuscarCotacao buscarcotacao = new BuscarCotacao();
            Cotacao novaCotacao = buscarcotacao.buscarCotacao("USD", valor, "BRL");

            System.out.println("\n Valor de " + valor + " [BRL] Corresponde a : " + novaCotacao.valor() + " [USD]");

        }

            else if(operacao == 5) {

                System.out.println("Digite quanto quer converter:");
                var valor = leitura.nextDouble();
                BuscarCotacao buscarcotacao = new BuscarCotacao();
                Cotacao novaCotacao = buscarcotacao.buscarCotacao("COP", valor, "USD");

                System.out.println("\n Valor de " + valor + " [USD] Corresponde a : " + novaCotacao.valor() + " [COP]");

            }

            else if(operacao == 6) {

                System.out.println("Digite quanto quer converter:");
                var valor = leitura.nextDouble();
                BuscarCotacao buscarcotacao = new BuscarCotacao();
                Cotacao novaCotacao = buscarcotacao.buscarCotacao("USD", valor, "COP");

                System.out.println("\n Valor de " + valor + " [USD] Corresponde a : " + novaCotacao.valor() + " [COP]");

            }

            else if(operacao > 7 ){
                System.out.println("Operação inválida !! Escolha outra opção OU 7 para Sair ");
            }


        }
    }
}