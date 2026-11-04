# 🖨️ Sistema de Controle de Impressora Elgin

## 📘 Sobre o Projeto

Este projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos (POO), com o objetivo de criar um sistema em Java capaz de controlar uma impressora térmica Elgin i8 ou i9.

O sistema utiliza a biblioteca JNA para estabelecer comunicação com a DLL disponibilizada pela fabricante. O projeto contempla autenticação de usuários, um menu interativo e operações de impressão.

## 🧰 Tecnologias Utilizadas

- Java — JDK 27
- IntelliJ IDEA
- JNA 5.15.0
- Biblioteca E1_Impressora01.dll
- Git e GitHub
- Impressora térmica Elgin i8/i9

## 📁 Estrutura do Projeto

- `main.java` — Classe responsável pela inicialização do programa.
- `usuario.java` — Classe destinada ao armazenamento e à validação das credenciais.
- `login.java` — Classe destinada ao processo de autenticação.
- `ImpressoraDLL.java` — Interface de comunicação com a DLL da Elgin.
- `Bibliotecas E1 Impressora/` — Bibliotecas nativas para arquiteturas x64 e x86.
- `libs Java/` — Biblioteca JNA 5.15.0.
- `XMLSAT.xml` — Arquivo de exemplo para impressão de cupom fiscal.
- `CANC_SAT.xml` — Arquivo de exemplo para impressão de cancelamento.

## ⚙️ Instalação e Execução

1. Baixe o projeto pelo GitHub.
2. Extraia os arquivos e abra a pasta no IntelliJ IDEA.
3. Configure o JDK 27.
4. Adicione a biblioteca `jna-5.15.0.jar` nas dependências do projeto.
5. Configure o Working directory como `$PROJECT_DIR$`.
6. Conecte e ligue uma impressora Elgin compatível.
7. Execute a classe principal do projeto.

## 🔐 Login

O sistema deverá solicitar usuário e senha, permitindo até três tentativas de autenticação.

**Credenciais de teste:** [Preencher após implementar o login.]

## 📋 Funcionalidades do Menu

O sistema deverá disponibilizar:

1. Configurar conexão
2. Abrir conexão
3. Fechar conexão
4. Imprimir texto
5. Imprimir QR Code
6. Imprimir código de barras
7. Imprimir XML SAT
8. Imprimir XML de cancelamento SAT
9. Abrir gaveta
10. Emitir sinal sonoro
11. Sair do sistema

As operações de impressão deverão ser bloqueadas quando não houver conexão ativa.

## 🧪 Testes Realizados

- [x] Organização das bibliotecas no projeto.
- [x] Configuração da biblioteca JNA 5.15.0.
- [x] Configuração da execução no IntelliJ IDEA.
- [x] Execução inicial da classe principal.
- [ ] Teste de autenticação com três tentativas.
- [ ] Teste de carregamento da DLL.
- [ ] Teste de conexão com a impressora.
- [ ] Teste das funcionalidades de impressão.

## 📚 Documentação Adicional

- [Documentação oficial da Elgin](https://elgindevelopercommunity.github.io/group___m1.html)

## 👥 Autores

[Inserir os nomes completos dos integrantes em ordem alfabética.]

**Disciplina:** Programação Orientada a Objetos

**Projeto:** Sistema de Controle de Impressora Elgin