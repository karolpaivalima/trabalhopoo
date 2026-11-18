import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

class impressora {

    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;
    static boolean conexaoAberta = false;
    static boolean verificarConexao = false;
    static Scanner ler;

    void configurarConexao() {

        if (conexaoAberta) {
            System.out.println("Feche a conexao antes de configurar novamente.");
            return;
        }

        verificarConexao = false;

        System.out.println("Qual o tipo de conexao?");
        System.out.println("1 - USB");
        System.out.println("2 - Serial (RS232)");
        System.out.println("3 - Rede (TCP/IP)");
        System.out.println("4 - Bluetooth");
        System.out.print("Tipo: ");

        try {
            tipo = ler.nextInt();
            ler.nextLine();

        } catch (InputMismatchException e) {
            ler.nextLine();
            System.out.println("Entrada invalida. Digite um numero!");
            return;
        }

        if (tipo < 1 || tipo > 4) {
            System.out.println("Tipo invalido!");
            return;
        }

        System.out.print("Modelo da impressora (i8/i9): ");
        modelo = ler.nextLine().trim();

        if (!modelo.equalsIgnoreCase("i8") &&
                !modelo.equalsIgnoreCase("i9")) {

            System.out.println("Modelo invalido!");
            return;
        }

        System.out.print("Digite a conexao: ");
        conexao = ler.nextLine().trim();

        if (conexao.equals("")) {
            System.out.println("Conexao invalida!");
            return;
        }

        System.out.print("Digite o parametro da conexao: ");

        try {
            parametro = ler.nextInt();
            ler.nextLine();

        } catch (InputMismatchException e) {
            ler.nextLine();
            System.out.println("Parametro invalido!");
            return;
        }

        if (tipo == 1 && parametro != 0) {
            System.out.println("Para USB, o parametro deve ser 0.");
            return;
        }

        if (tipo == 2 && parametro <= 0) {
            System.out.println("Velocidade serial invalida!");
            return;
        }

        if (tipo == 3 && (parametro <= 0 || parametro > 65535)) {
            System.out.println("Porta de rede invalida!");
            return;
        }

        verificarConexao = true;
        System.out.println("Configuracao da conexao completa!");
    }

    void abrirConexao() {

        if (!verificarConexao) {
            System.out.println("Configure a impressora na opcao 1 primeiro!");
            return;
        }

        if (conexaoAberta) {
            System.out.println("A impressora ja esta conectada!");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(
                    tipo, modelo, conexao, parametro
            );

            System.out.println("Retorno da DLL: " + retorno);

            if (retorno == 0) {

                conexaoAberta = true;
                System.out.println("Impressora conectada com sucesso! :)");

            } else {

                conexaoAberta = false;
                System.out.println("Erro ao conectar. Codigo: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            conexaoAberta = false;
            System.out.println("Erro ao carregar a DLL: " + e.getMessage());
        }
    }

    void fecharConexao() {

        if (!conexaoAberta) {
            System.out.println("A impressora ja esta desconectada!");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();

            if (retorno == 0) {

                conexaoAberta = false;
                System.out.println("Impressora desconectada com sucesso!");

            } else {

                System.out.println("Erro ao desconectar. Codigo: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    // Metodo de teste original do professor
    void imprimirTexto() {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(
                    "Teste", 1, 4, 0
            );

            if (retorno >= 0) {

                System.out.println("Texto de teste enviado!");
                cortarPapel();

            } else {

                System.out.println("Erro ao imprimir. Codigo: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    // Impressao personalizada
    void imprimirTexto(String texto) {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        if (texto.trim().equals("")) {
            System.out.println("Texto vazio. Digite algo!");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(
                    texto, 1, 0, 0
            );

            if (retorno >= 0) {

                System.out.println("Texto enviado para impressao! :)");
                cortarPapel();

            } else {

                System.out.println("Erro na impressao: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    void imprimirQRCode(String texto) {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        if (texto.trim().equals("")) {
            System.out.println("Texto do QR Code vazio!");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode(
                    texto, 6, 4
            );

            if (retorno == 0) {

                System.out.println("QR Code enviado para impressao!");
                cortarPapel();

            } else {

                System.out.println("Erro ao imprimir QR Code: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    void imprimirCodigoBarras(String dados) {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        if (dados.trim().equals("")) {
            System.out.println("Dados do codigo de barras vazios!");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(
                    8, "{A" + dados, 100, 3, 2
            );

            if (retorno == 0) {

                System.out.println("Codigo de barras enviado para impressao!");
                cortarPapel();

            } else {

                System.out.println("Erro ao imprimir codigo de barras: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    void imprimirXMLSAT() {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        File arquivo = new File("XMLSAT.xml");

        try {

            Scanner leitor = new Scanner(arquivo);
            leitor.close();

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo XMLSAT.xml nao encontrado! :(");
            return;
        }

        imprimirXMLSAT("path=" + arquivo.getAbsolutePath());
    }

    void imprimirXMLSAT(String xml) {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(xml, 0);

            if (retorno == 0) {

                System.out.println("XML SAT enviado para impressao!");
                cortarPapel();

            } else {

                System.out.println("Erro ao imprimir XML SAT: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    void imprimirXMLCancelamento() {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        File arquivo = new File("CANC_SAT.xml");

        try {

            Scanner leitor = new Scanner(arquivo);
            leitor.close();

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo CANC_SAT.xml nao encontrado! :(");
            return;
        }

        String assinatura =
                "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0" +
                        "E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQ" +
                        "sE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+Z" +
                        "fO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";

        imprimirXMLCancelamento(
                "path=" + arquivo.getAbsolutePath(), assinatura
        );
    }

    void imprimirXMLCancelamento(String xml, String assQRCode) {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        if (assQRCode.trim().equals("")) {
            System.out.println("Assinatura QR Code invalida!");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(
                    xml, assQRCode, 0
            );

            if (retorno == 0) {

                System.out.println("Cancelamento SAT enviado para impressao!");
                cortarPapel();

            } else {

                System.out.println("Erro ao imprimir cancelamento: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    void abrirGaveta() {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreGaveta(
                    1, 5, 10
            );

            if (retorno == 0) {

                System.out.println("Comando para abrir gaveta enviado!");

            } else {

                System.out.println("Erro ao abrir gaveta: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    void sinalSonoro() {
        sinalSonoro(1);
    }

    void sinalSonoro(int quantidade) {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        if (quantidade < 1 || quantidade > 5) {
            System.out.println("Escolha uma quantidade entre 1 e 5!");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(
                    quantidade, 50, 5
            );

            if (retorno == 0) {

                System.out.println("Sinal sonoro executado com sucesso! :)");

            } else {

                System.out.println("Erro no sinal sonoro: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }

    void cortarPapel() {

        if (!conexaoAberta) {
            System.out.println("Conexao fechada. Abra a conexao antes.");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.Corte(5);

            if (retorno == 0) {

                System.out.println("Papel cortado com sucesso!");

            } else {

                System.out.println("Erro ao cortar papel: " + retorno);
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Erro ao acessar a DLL: " + e.getMessage());
        }
    }
}