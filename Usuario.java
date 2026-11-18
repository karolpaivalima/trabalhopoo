import java.util.Scanner;

class Usuario {
    String nome;
    String senha;
    boolean logado = false;

    void cadastrar(Scanner ler) {

        System.out.println("--- CADASTRO ---");

        System.out.print("Crie seu usuario: ");
        nome = ler.nextLine();

        System.out.print("Crie sua senha: ");
        senha = ler.nextLine();

        System.out.println("Cadastro concluido com exito! :)");
    }

    void entrar(Scanner ler) {

        logado = false;

        System.out.println("=== LOGIN ===");

        for (int tentativa = 1; tentativa <= 3; tentativa++) {

            System.out.print("Usuario: ");
            String usuarioDigitado = ler.nextLine();

            System.out.print("Senha: ");
            String senhaDigitada = ler.nextLine();

            if (usuarioDigitado.equals(nome) && senhaDigitada.equals(senha)) {

                System.out.println("Login realizado com sucesso! :)");
                logado = true;
                break;

            } else {

                System.out.println("Usuario ou senha incorretos!");
                System.out.println("Tentativas restantes: " + (3 - tentativa));
            }
        }

        if (logado == false) {
            System.out.println("Acesso bloqueado! :(");
        }
    }
}