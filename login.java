
import java.util.*;

class login {
    String nome;
    String senha;
    boolean logado = false;

    void entrar() {
        Scanner ler = new Scanner(System.in);

        System.out.println("=== LOGIN ===");

        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Usuario: ");
            String usuarioDigitado = ler.nextLine();

            System.out.print("Senha: ");
            String senhaDigitada = ler.nextLine();

            if (usuarioDigitado.equals(nome) && senhaDigitada.equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                logado = true;
                break;
            } else {
                System.out.println("Usuario ou senha incorretos!");
                System.out.println("Tentativas restantes: " + (3 - tentativa));
            }
        }

        if (logado == false) {
            System.out.println("Acesso bloqueado!");
        }
    }
}
