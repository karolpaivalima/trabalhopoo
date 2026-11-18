import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        usuario cadastro = new usuario();
        cadastro.cadastrar();

        login acesso = new login();

        acesso.nome = cadastro.nome;
        acesso.senha = cadastro.senha;

        acesso.entrar();

        if (acesso.logado == false) {
            return;
        }

        System.out.println("Bem-vindo ao sistema da Impressora Elgin!");

        Scanner entrada = new Scanner(System.in);
        impressora impressora1 = new impressora();

        int opcao = -1;

        while (opcao != 0) {
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
            System.out.print("Escolha uma opcao: ");

            if (!entrada.hasNextInt()) {
                entrada.nextLine();
                System.out.println("Entrada invalida! Digite um numero.");
                continue;
            }

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 0:
                    if (impressora.conexaoAberta) {
                        impressora1.fecharConexao();
                    }
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
                    if (impressora.conexaoAberta) {
                        System.out.print("Digite o texto para imprimir: ");
                        String textoImpressao = entrada.nextLine();
                        impressora1.imprimirTexto(textoImpressao);
                    } else {
                        System.out.println("Conexao fechada. Abra a conexao antes.");
                    }
                    break;

                case 5:
                    if (impressora.conexaoAberta) {
                        System.out.print("Digite o texto do QR Code: ");
                        String texto = entrada.nextLine();
                        impressora1.imprimirQRCode(texto);
                    } else {
                        System.out.println("Conexao fechada. Abra a conexao antes.");
                    }
                    break;

                case 6:
                    if (impressora.conexaoAberta) {
                        System.out.print("Digite os dados do codigo de barras: ");
                        String dados = entrada.nextLine();
                        impressora1.imprimirCodigoBarras(dados);
                    } else {
                        System.out.println("Conexao fechada. Abra a conexao antes.");
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
                    if (impressora.conexaoAberta) {
                        System.out.print("Quantos sinais sonoros? (1 a 5): ");

                        if (entrada.hasNextInt()) {
                            int quantidade = entrada.nextInt();
                            entrada.nextLine();
                            impressora1.sinalSonoro(quantidade);
                        } else {
                            entrada.nextLine();
                            System.out.println("Digite um numero inteiro!");
                        }
                    } else {
                        System.out.println("Conexao fechada. Abra a conexao antes.");
                    }
                    break;

                default:
                    System.out.println("Opcao invalida! Escolha de 0 a 10.");
            }
        }
    }
}