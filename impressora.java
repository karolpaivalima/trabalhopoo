import java.util.Scanner;

class impressora {
    static int tipo;
    static String modelo;
    static  String conexao;
    static int parametro;
    static boolean conexaoAberta = false;
    static Scanner ler = new Scanner(System.in);

    void configurarConexao() {
        tipo = ler.nextInt();
        modelo = ler.next();
        conexao = ler.next();
        parametro = ler.nextInt();

        System.out.println("Configuração da conexão completa!");
    }

    void abrirConexao() {
        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);

            if (retorno == 0) {
                conexaoAberta = true;
                System.out.println("Impressora conectada com sucesso!");
            } else {
                conexaoAberta = false;
                System.out.println("Erro ao conectar. Codigo: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            conexaoAberta = false;
            System.out.println("Erro ao carregar a DLL da impressora.");
        }
    }

    void fecharConexao() {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();

            if (retorno == 0) {
                conexaoAberta = false;
                System.out.println("Impressora desconectada com sucesso!");
            } else {
                System.out.println("Erro ao desconectar. Codigo: " + retorno);
            }

        } else {
            System.out.println("A impressora ja esta desconectada!");
        }
    }

    void imprimirTexto() {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto("Teste", 1, 4, 0);

            if (retorno >= 0) {
                ImpressoraDLL.INSTANCE.Corte(5);
                System.out.println("Texto enviado para impressao!");
            } else {
                System.out.println("Erro ao imprimir. Codigo: " + retorno);
            }

        } else {
            System.out.println("Conexao fechada. Abra a conexao antes.");
        }
    }

    void imprimirQRCode(String texto) {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode(texto, 4, 2);

            if (retorno == 0) {
                System.out.println("QR Code impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir QR Code. Codigo: " + retorno);
            }

        } else {
            System.out.println("Conexao fechada. Abra a conexao antes.");
        }
    }

    void imprimirCodigoBarras(String dados) {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(8, dados, 100, 3, 1);

            if (retorno == 0) {
                System.out.println("Codigo de barras impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir codigo de barras. Codigo: " + retorno);
            }

        } else {
            System.out.println("Conexao fechada. Abra a conexao antes.");
        }
    }

    void imprimirXMLSAT(String xml) {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(xml, 0);

            if (retorno == 0) {
                System.out.println("XML SAT impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir XML SAT. Codigo: " + retorno);
            }

        } else {
            System.out.println("Conexao fechada. Abra a conexao antes.");
        }
    }

    void imprimirXMLCancelamento(String xml, String assQRCode) {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(xml, assQRCode, 0);

            if (retorno == 0) {
                System.out.println("XML de cancelamento impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir cancelamento. Codigo: " + retorno);
            }

        } else {
            System.out.println("Conexao fechada. Abra a conexao antes.");
        }
    }

    void abrirGaveta() {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.AbreGaveta(1, 100, 100);

            if (retorno == 0) {
                System.out.println("Comando para abrir gaveta enviado!");
            } else {
                System.out.println("Erro ao abrir gaveta. Codigo: " + retorno);
            }

        } else {
            System.out.println("Conexao fechada. Abra a conexao antes.");
        }
    }

    void sinalSonoro() {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(1, 50, 5);

            if (retorno == 0) {
                System.out.println("Sinal sonoro executado com sucesso!");
            } else {
                System.out.println("Erro ao executar sinal sonoro. Codigo: " + retorno);
            }

        } else {
            System.out.println("Conexao fechada. Abra a conexao antes.");
        }
    }
}
