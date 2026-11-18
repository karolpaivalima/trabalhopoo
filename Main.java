import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Usuario cadastro = new Usuario();

        cadastro.cadastrar(entrada);
        cadastro.entrar(entrada);

        if (!cadastro.logado) {
            return;
        }

        Impressora impressora1 = new Impressora();
        Impressora.ler = entrada;

        int opcao = -1;

        System.out.println("Bem-vindo ao sistema da Impressora Elgin! :)");

        do {

            System.out.println("\n==============================");
            System.out.println("       IMPRESSORA ELGIN");
            System.out.println("==============================");
            System.out.println("1 - Configurar conexao");
            System.out.println("2 - Abrir conexao");
            System.out.println("3 - Fechar conexao");
            System.out.println("4 - Imprimir texto");
            System.out.println("5 - Imprimir QR Code");
            System.out.println("6 - Imprimir codigo de barras");
            System.out.println("7 - Imprimir XML SAT");
            System.out.println("8 - Imprimir XML de cancelamento SAT");
            System.out.println("9 - Abrir gaveta");
            System.out.println("10 - Sinal sonoro");
            System.out.println("0 - Sair");
            System.out.println("==============================");

            try {

                System.out.print("Escolha uma opcao: ");
                opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {

                    case 1:
                        impressora1.configurarConexao();
                        break;

                    case 2:
                        impressora1.abrirConexao();
                        break;

                    case 3:
                        impressora1.fecharConexao();
                        break;

                    case 4:
                        if (Impressora.conexaoAberta) {

                            System.out.print("Digite o texto: ");
                            String texto = entrada.nextLine();

                            impressora1.imprimirTexto(texto);

                        } else {
                            System.out.println("Abra a conexao primeiro!");
                        }
                        break;

                    case 5:
                        if (Impressora.conexaoAberta) {

                            System.out.print("Digite o conteudo do QR Code: ");
                            String qrCode = entrada.nextLine();

                            impressora1.imprimirQRCode(qrCode);

                        } else {
                            System.out.println("Abra a conexao primeiro!");
                        }
                        break;

                    case 6:
                        if (Impressora.conexaoAberta) {

                            impressora1.imprimirCodigoBarras("123456789012");

                        } else {
                            System.out.println("Abra a conexao primeiro!");
                        }
                        break;

                    case 7:
                        impressora1.imprimirXMLSAT();
                        break;

                    case 8:
                        impressora1.imprimirXMLCancelamento();
                        break;

                    case 9:
                        impressora1.abrirGaveta();
                        break;

                    case 10:
                        if (Impressora.conexaoAberta) {

                            System.out.print("Quantidade de sinais sonoros (1 a 5): ");
                            int quantidade = entrada.nextInt();
                            entrada.nextLine();

                            impressora1.sinalSonoro(quantidade);

                        } else {
                            System.out.println("Abra a conexao primeiro!");
                        }
                        break;

                    case 0:
                        if (Impressora.conexaoAberta) {
                            impressora1.fecharConexao();
                        }

                        System.out.println("Obrigada por utilizar nosso sistema! Ate logo <3");
                        break;

                    default:
                        System.out.println("Opcao invalida! :(");
                }

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas numeros inteiros!");
                entrada.nextLine();
            }

        } while (opcao != 0);

        entrada.close();
    }
}