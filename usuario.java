import java.util.*;

class usuario {
    String nome;
    String senha;

    void cadastrar() {
        Scanner ler = new Scanner(System.in);

        System.out.println("--- CADASTRO ---");

        System.out.print("Crie seu usuário: ");
        nome = ler.nextLine();

        System.out.print("Crie sua senha: ");
        senha = ler.nextLine();

        System.out.println("Cadastro concluído com êxito.");
    }
}