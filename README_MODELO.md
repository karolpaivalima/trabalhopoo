# 🖨️ ELGIN | Sistema de Controle de Impressora Térmica

**Projeto acadêmico • Programação Orientada a Objetos • Java**

![Java](https://img.shields.io/badge/JAVA-POO-167D68?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/STATUS-DESENVOLVIDO-267D5C?style=for-the-badge)
![Testes](https://img.shields.io/badge/TESTES-PARCIAIS-E6A23C?style=for-the-badge)
![IDE](https://img.shields.io/badge/INTELLIJ_IDEA-304C89?style=for-the-badge&logo=intellijidea&logoColor=white)

---

## ✦ Apresentação

O **Sistema de Controle de Impressora Elgin** é uma aplicação desenvolvida em Java para realizar operações com impressoras térmicas Elgin, especialmente os modelos **i8 e i9**.

O projeto foi desenvolvido por **Karoline Carvalho Paiva Terceiro Lima e Daniel Sampaio**, estudantes do 2º ano do Ensino Médio Técnico em Tecnologia da Informação do UNASP, no contexto da disciplina de **Programação Orientada a Objetos (POO)**.

Por meio de uma interface de terminal, o programa oferece cadastro e autenticação de usuários, configuração de conexão e acesso a dez funcionalidades relacionadas à impressora.

O desenvolvimento permitiu explorar conceitos de orientação a objetos, estruturas de repetição, validação de dados, tratamento de erros e integração entre Java e bibliotecas nativas.

## ✦ Funcionalidades implementadas

| Opção | Funcionalidade | Descrição |
|---|---|---|
| `01` | Configurar conexão | Define modelo, tipo de conexão e parâmetros. |
| `02` | Abrir conexão | Estabelece comunicação com a impressora. |
| `03` | Fechar conexão | Encerra a comunicação com o equipamento. |
| `04` | Imprimir texto | Permite informar um texto personalizado. |
| `05` | Imprimir QR Code | Envia dados para impressão de um código QR. |
| `06` | Imprimir código de barras | Envia dados para impressão em formato de barras. |
| `07` | Imprimir XML SAT | Processa um documento fiscal XML SAT. |
| `08` | Cancelamento SAT | Processa XML de cancelamento e assinatura QR Code. |
| `09` | Abrir gaveta | Envia o comando de acionamento da gaveta. |
| `10` | Sinal sonoro | Permite solicitar de um a cinco sinais sonoros. |
| `00` | Sair | Finaliza o sistema. |

Além dessas funcionalidades, foram implementados mecanismos de validação de entradas, verificação do estado da conexão e tratamento de determinados erros de comunicação.

## ✦ Tecnologias e ferramentas

| Tecnologia | Aplicação |
|---|---|
| **Java** | Desenvolvimento da aplicação |
| **Programação Orientada a Objetos** | Organização de classes, atributos e métodos |
| **IntelliJ IDEA** | Ambiente de desenvolvimento |
| **JNA 5.15.0** | Comunicação entre Java e código nativo |
| **SDK Elgin / E1_Impressora01.dll** | Acesso às funções da impressora |
| **Git e GitHub** | Controle de versões e documentação |

## ✦ Organização do código

```text
trabalhopoo/
│
├── main.java
├── impressora.java
├── usuario.java
├── login.java
├── ImpressoraDLL.java
│
├── libs Java/
├── Bibliotecas E1 Impressora/
│
├── XMLSAT.xml
├── CANC_SAT.xml
├── README_MODELO.md
└── README.md
```

**Responsabilidades principais:**

- `main.java`: execução do sistema e gerenciamento do menu.
- `impressora.java`: configuração e execução das operações da impressora.
- `usuario.java`: cadastro de usuários.
- `login.java`: autenticação e controle de acesso.
- `ImpressoraDLL.java`: interface de integração com a biblioteca nativa da Elgin.
- `libs Java/`: biblioteca JNA utilizada pelo projeto.
- `Bibliotecas E1 Impressora/`: arquivos nativos necessários à comunicação com a impressora.

## ✦ Como executar

### 01. Preparação do ambiente

Para executar a aplicação, é necessário:

- Ter o Java instalado e configurado.
- Utilizar o IntelliJ IDEA ou outro ambiente compatível.
- Configurar a biblioteca `jna-5.15.0.jar`.
- Disponibilizar as bibliotecas nativas da Elgin compatíveis com o sistema operacional.
- Possuir uma impressora Elgin compatível para executar as operações físicas.

### 02. Download e abertura

1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia os arquivos.
4. Abra a pasta do projeto no IntelliJ IDEA.
5. Em **File → Project Structure → Libraries**, confira se a biblioteca JNA está adicionada.

### 03. Configuração da execução

Verifique se o diretório de trabalho (*Working directory*) está configurado para a pasta principal do projeto, onde se encontram as bibliotecas da impressora.

Execute a classe `main.java` para iniciar o programa.

### 04. Utilização

1. Realize o cadastro e a autenticação.
2. No menu principal, escolha `1 - Configurar conexão`.
3. Informe o tipo de conexão, o modelo e os parâmetros solicitados.
4. Selecione `2 - Abrir conexão`.
5. Após a conexão ser estabelecida, utilize as funcionalidades disponíveis.
6. Ao finalizar, selecione `0 - Sair`.

**Exemplo de configuração USB:**

| Parâmetro | Valor |
|---|---|
| Tipo | `1` |
| Modelo | `i8` ou `i9` |
| Conexão | `USB` |
| Parâmetro | `0` |

## ✦ Cadastro e autenticação

Diferentemente de sistemas que utilizam credenciais fixas, este projeto apresenta um fluxo de **cadastro e login**.

Ao iniciar a aplicação, o usuário informa os dados solicitados para cadastro. Posteriormente, deve utilizar as credenciais cadastradas para acessar o menu principal.

O sistema permite **até três tentativas de autenticação**.

Caso as credenciais sejam informadas incorretamente durante todas as tentativas, o acesso é encerrado.

**Login de teste:** utilize o usuário e a senha definidos durante o cadastro na própria execução do programa.

Esse mecanismo permite demonstrar a utilização de atributos, métodos, condicionais e estruturas de repetição.

## ✦ Testes realizados e limitações

> ⚠️ **Transparência técnica:** as dez funcionalidades foram implementadas no código, mas nem todas foram verificadas presencialmente em uma impressora física.

Durante o desenvolvimento, foram realizados testes de execução do programa e de comportamento de algumas funcionalidades.

| Verificação | Situação |
|---|---|
| Inicialização da aplicação | Testada |
| Cadastro e autenticação | Testados durante o desenvolvimento |
| Exibição e navegação pelo menu | Testadas |
| Seleção de funcionalidades com conexão fechada | Testada em diferentes opções |
| Validação de entradas e parâmetros | Implementada; testes ainda parciais |
| Abertura e fechamento da conexão física | Validação completa pendente |
| Impressão de textos personalizados | Teste físico pendente |
| Impressão de QR Codes | Teste físico pendente |
| Impressão de códigos de barras | Teste físico pendente |
| Impressão de XML SAT e cancelamento | Teste físico pendente |
| Acionamento da gaveta | Teste físico pendente |
| Emissão de sinais sonoros | Teste físico pendente |

As operações dependem da configuração correta das bibliotecas nativas, da conexão e da compatibilidade do equipamento.

**A implementação de um método não constitui, por si só, comprovação de seu funcionamento físico.**

Portanto, o projeto deve ser compreendido como uma aplicação acadêmica em desenvolvimento e validação, e não como um sistema comercial homologado.

## ✦ Desenvolvimento e aprendizado

Este trabalho proporcionou experiência prática com:

- Desenvolvimento de aplicações Java orientadas a objetos.
- Separação de responsabilidades entre classes.
- Construção de menus e fluxos interativos.
- Cadastro e autenticação de usuários.
- Validação de dados e tratamento de erros.
- Integração com bibliotecas externas por meio de JNA.
- Interpretação dos códigos de retorno de funções nativas.
- Utilização de Git e GitHub para versionamento.
- Leitura, adaptação e compreensão de implementações de referência.

O código foi aprimorado progressivamente ao longo da atividade, incorporando correções, sugestões e melhorias técnicas.

## ✦ Documentação e referências

A implementação foi orientada pelos materiais disponibilizados na disciplina e pela documentação técnica da biblioteca Elgin.

- **Trabalho_Impressora_Elgin.pdf** — enunciado, requisitos e critérios de avaliação fornecidos pelo professor.
- [Documentação oficial do SDK E1_Impressora](https://elgindevelopercommunity.github.io/group___m1.html) — referência dos comandos e parâmetros da impressora.
- [Projeto ImpressoraElgin — Pietro Mandu Gama e equipe](https://github.com/PietroGiftHub/ImpressoraElgin) — implementação consultada como referência durante o aprimoramento do projeto.

## ✦ Autoria

**Desenvolvimento acadêmico:**

- **Karoline Carvalho Paiva Terceiro Lima**
- **Daniel Sampaio**

**Instituição:** Centro Universitário Adventista de São Paulo — UNASP

**Curso:** Ensino Médio Técnico em Tecnologia da Informação

**Disciplina:** Programação Orientada a Objetos

**Ano:** 2026

## ✦ Créditos e agradecimentos

O desenvolvimento deste projeto contou com orientações, materiais de referência e contribuições importantes durante sua elaboração.

**Ao professor Richard:** agradecemos pelas explicações, correções e orientações técnicas, fundamentais para a estruturação do projeto e para a compreensão dos métodos utilizados.

**A Pietro Mandu Gama:** agradecemos pelo compartilhamento de seu projeto, utilizado como referência na implementação e no aprimoramento de funcionalidades, especialmente nas operações de impressão, validação e integração com a biblioteca Elgin.

O trabalho também contou com o apoio de ferramentas de **inteligência artificial**, utilizadas na organização, revisão, adaptação de trechos do código e elaboração da documentação.

Reconhecemos essas contribuições como parte do processo de aprendizagem, pesquisa e desenvolvimento acadêmico.

## ✦ Considerações finais

O desenvolvimento do Sistema de Controle de Impressora Elgin representa uma aplicação prática dos conhecimentos adquiridos em Programação Orientada a Objetos, conectando conceitos estudados em sala de aula à comunicação com um dispositivo real.

O projeto reúne as funcionalidades propostas em uma aplicação organizada, com autenticação, menu interativo, gerenciamento de conexões e integração com a biblioteca nativa da impressora.

Embora ainda existam etapas de validação física, sua implementação permitiu aprofundar conhecimentos em Java, compreender desafios de integração com hardware e desenvolver habilidades de resolução de problemas.

---

**Desenvolvido para fins educacionais.**

*Java • Programação Orientada a Objetos • Tecnologia da Informação • 2026*

**Karoline Carvalho Paiva Terceiro Lima & Daniel Sampaio**