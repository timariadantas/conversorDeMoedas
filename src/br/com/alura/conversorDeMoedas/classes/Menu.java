package br.com.alura.conversorDeMoedas.classes;



import java.util.Scanner;


public class Menu {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        Exchanger exchanger = new Exchanger("10877d15d7cb5066f746cce4");

        int controller = 0;

        while (controller != 8) {
            System.out.println("************* CONVERSOR DE MOEDAS ************" + '\n');
            System.out.println("1) Dólar -> Real");
            System.out.println("2) Real -> Dólar");
            System.out.println("3) Euro -> Real");
            System.out.println("4) Real -> Euro");
            System.out.println("5) Dólar -> Euro");
            System.out.println("6) Euro -> Dólar");
            System.out.println("7) Customizar moedas");
            System.out.println("8) Sair");

            controller = scanner.nextInt();
            double inputValue;

            switch (controller) {
                case 1: {
                    System.out.println("Digite o valor em dólar que queira converter em real: ");
                    inputValue = scanner.nextDouble();
                    exchanger.exchange("USD", "BRL", inputValue);
                    break;
                }
                case 2: {
                    System.out.println("Digite o valor em real que queira converter em dólar: ");
                    inputValue = scanner.nextDouble();
                    exchanger.exchange("BRL", "USD", inputValue);
                    break;
                }
                case 3: {
                    System.out.println("Digite o valor em euro que queira converter em real: ");
                    inputValue = scanner.nextDouble();
                    exchanger.exchange("EUR", "BRL", inputValue);
                    break;
                }
                case 4: {
                    System.out.println("Digite o valor em real que queira converter em euro: ");
                    inputValue = scanner.nextDouble();
                    exchanger.exchange("BRL", "EUR", inputValue);
                    break;
                }
                case 5: {
                    System.out.println("Digite o valor em dólar que queira converter em euro: ");
                    inputValue = scanner.nextDouble();
                    exchanger.exchange("USD", "EUR", inputValue);
                    break;
                }
                case 6: {
                    System.out.println("Digite o valor em euro que queira converter em dólar: ");
                    inputValue = scanner.nextDouble();
                    exchanger.exchange("EUR", "USD", inputValue);
                    break;
                }

                case 7: {
                    System.out.println("Digite a moeda que queira usar como base. Exemplo: BRL, ARS, LYD, SSP, VES...");
                    System.out.println("Consulte todas as moedas suportadas em: https://www.exchangerate-api.com/docs/supported-currencies \n");
                    String customBaseCurrency = scanner.next();

                    System.out.println("Digite a moeda que queira converter:");
                    String customTargetCurrency = scanner.next();

                    System.out.println("Digite o valor que queira converter: ");
                    inputValue = scanner.nextDouble();

                    exchanger.exchange(customBaseCurrency, customTargetCurrency, inputValue);
                    break;
                }

                case 8: {
                    break;
                }

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
