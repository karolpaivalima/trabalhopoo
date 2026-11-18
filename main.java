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
                        if (impressora.conexaoAberta == true) {
                            System.out.print("Digite o texto do QR Code: ");
                            String texto = entrada.nextLine();
                            impressora1.imprimirQRCode(texto);
                        } else {
                            System.out.println("Conexao fechada. Abra a conexao antes.");
                        }
                        break;

                    case 6:
                        if (impressora.conexaoAberta == true) {
                            System.out.print("Digite os dados do codigo de barras: ");
                            String dados = entrada.nextLine();
                            impressora1.imprimirCodigoBarras(dados);
                        } else {
                            System.out.println("Conexao fechada. Abra a conexao antes.");
                        }
                        break;

                    case 7:
                        if (impressora.conexaoAberta == true) {
                            System.out.print("Digite o caminho do arquivo XML SAT: ");
                            String caminho = entrada.nextLine();

                            try {
                                String xml = java.nio.file.Files.readString(
                                        java.nio.file.Path.of(caminho)
                                );

                                impressora1.imprimirXMLSAT(xml);

                            } catch (java.io.IOException e) {
                                System.out.println("Erro ao ler o arquivo XML SAT.");
                            }

                        } else {
                            System.out.println("Conexao fechada. Abra a conexao antes.");
                        }
                        break;

                    case 8:
                        if (impressora.conexaoAberta == true) {
                            System.out.print("Digite o caminho do XML de cancelamento: ");
                            String caminhoXML = entrada.nextLine();

                            System.out.print("Digite o caminho do arquivo ASS_QRCODE: ");
                            String caminhoASS = entrada.nextLine();

                            try {
                                String xml = java.nio.file.Files.readString(
                                        java.nio.file.Path.of(caminhoXML)
                                );

                                String assinatura = java.nio.file.Files.readString(
                                        java.nio.file.Path.of(caminhoASS)
                                ).trim();

                                if (assinatura.startsWith("ASS_QRCODE")) {
                                    assinatura = assinatura.substring(assinatura.indexOf("\"") + 1);
                                    assinatura = assinatura.substring(0, assinatura.indexOf("\""));
                                }

                                impressora1.imprimirXMLCancelamento(xml, assinatura);

                            } catch (java.io.IOException e) {
                                System.out.println("Erro ao ler os arquivos de cancelamento.");
                            }
                        } else {
                            System.out.println("Conexao fechada. Abra a conexao antes.");
                        }
                        break;
1

                    case 9:
                        impressora1.abrirGaveta();
                        break;

                    case 10:
                        impressora1.sinalSonoro();
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
    }
}
