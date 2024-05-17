import java.util.Scanner;

public class Menu {

    private static final int REAL_PARA_DOLAR_AMERICANO = 1;
    private static final int REAL_PARA_EURO = 2;
    private static final int REAL_PARA_DOLAR_CANADENSE = 3;

    public void iniciar() {
        imprimirMenu();
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        ConversorRestClient conversorRestClient = new ConversorRestClient();
        executarOpcao(opcao, sc, conversorRestClient);

        sc.close();
    }

    private void executarConversao(Scanner sc, ConversorRestClient conversorRestClient, String moedaBase, String moedaAlvo) {
        System.out.println("Digite a quantidade: ");
        double quantidade = sc.nextDouble();
        ConversorExchangeRateResponse c = conversorRestClient.converter(moedaBase, moedaAlvo, quantidade);
        System.out.printf("%.2f %s = %.2f %s%n", quantidade, moedaBase, c.conversionResult(), moedaAlvo);
    }

    private void imprimirMenu() {
        System.out.print("""
                -----------------------------------------------------------
                       € $ £ ¥   CONVERSOR DE MOEDA  € $ £ ¥ 
                                
                1) R$  >> US$   (Real >> Dólar Americano)
                2) R$  >> €     (Real >> Euro)
                3) R$  >> C$    (Real >> Dólar Canadense)
                4) US$ >> R$    (Dólar Americano >> Real)
                5) €   >> R$    (Euro >> Real)
                6) C$  >> R$    (Dólar Canadense >> Real)
                7) SAIR
                                
                Escolha um opção para conversão:                
                """);
    }

    private void executarOpcao(int opcao, Scanner sc, ConversorRestClient conversorRestClient) {
        switch (opcao) {
            case REAL_PARA_DOLAR_AMERICANO:
                executarConversao(sc, conversorRestClient, Moeda.BRASIL.getValue(), Moeda.EUA.getValue());
                break;
            case REAL_PARA_EURO:
                executarConversao(sc, conversorRestClient, Moeda.BRASIL.getValue(), Moeda.EUROPA.getValue());
                break;
            case REAL_PARA_DOLAR_CANADENSE:
                executarConversao(sc, conversorRestClient, Moeda.BRASIL.getValue(), Moeda.CANADA.getValue());
                break;
            case 4:
                executarConversao(sc, conversorRestClient, Moeda.EUA.getValue(), Moeda.BRASIL.getValue());
                break;
            case 5:
                executarConversao(sc, conversorRestClient, Moeda.EUROPA.getValue(), Moeda.BRASIL.getValue());
                break;
            case 6:
                executarConversao(sc, conversorRestClient, Moeda.CANADA.getValue(), Moeda.BRASIL.getValue());
                break;
            case 7:
                System.out.println("\nFIM");
                break;
            default:
                System.out.println("\nOpção inválida!");
                break;
        }
    }

}
