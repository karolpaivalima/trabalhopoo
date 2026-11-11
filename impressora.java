class impressora {
    int tipo;
    String modelo;
    String conexao;
    int parametro;
    boolean conexaoAberta = false;

    void configurarConexao(int t, String m, String c, int p) {
        tipo = t;
        modelo = m;
        conexao = c;
        parametro = p;

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

    void imprimirTexto(String texto) {
        if (conexaoAberta == true) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(texto, 0, 0, 0);

            if (retorno >= 0) {
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
}
