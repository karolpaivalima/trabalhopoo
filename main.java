
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
        }
    }
}
