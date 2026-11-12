import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        usuario cadastro = new usuario();
        cadastro.cadastrar();

        login acesso = new login();

        acesso.nome = cadastro.nome;
        acesso.senha = cadastro.senha;

        acesso.entrar();

        if (acesso.logado == true) {
            System.out.println("Bem-vindo ao sistema da Impressora Elgin!");

            Scanner entrada = new Scanner(System.in);
            impressora impressora1 = new impressora();

            int opcao = -1;

            while (opcao != 0) {
                System.out.println("\n--- MENU IMPRESSORA ELGIN ---");
                System.out.println("1 - Configurar conexão");
                System.out.println("2 - Abrir conexão");
                System.out.println("3 - Fechar conexão");
                System.out.println("4 - Imprimir texto");
                System.out.println("5 - Imprimir QR Code");
                System.out.println("6 - Imprimir código de barras");
                System.out.println("7 - Imprimir XML SAT");
                System.out.println("8 - Imprimir XML de cancelamento");
                System.out.println("9 - Abrir gaveta");
                System.out.println("10 - Sinal sonoro");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                if (entrada.hasNextInt()) {
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                } else {
                    entrada.nextLine();
                    System.out.println("Digite um numero válido :)");
                    continue;
                }

                switch (opcao) {
                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;

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
                        impressora1.imprimirTexto();
                        break;

                    case 5:
                        System.out.println("Imprimir QR Code");
                        break;

                    case 6:
                        System.out.println("Imprimir codigo de barras");
                        break;

                    case 7:
                        System.out.println("Imprimir XML SAT");
                        break;

                    case 8:
                        System.out.println("Imprimir XML de cancelamento");
                        break;

                    case 9:
                        System.out.println("Abrir gaveta");
                        break;

                    case 10:
                        System.out.println("Sinal sonoro");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
    }
}
