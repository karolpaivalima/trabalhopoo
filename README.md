# 🖨️ ELGIN | Sistema de Controle de Impressora Térmica

**Projeto acadêmico • Programação Orientada a Objetos • Java**

![Java](https://img.shields.io/badge/JAVA-POO-167D68?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/STATUS-DESENVOLVIDO-267D5C?style=for-the-badge)
![Testes](https://img.shields.io/badge/TESTES-PARCIAIS-E6A23C?style=for-the-badge)
![IDE](https://img.shields.io/badge/INTELLIJ_IDEA-2026-304C89?style=for-the-badge&logo=intellijidea&logoColor=white)

---

## ✦ Apresentação

O **Sistema de Controle de Impressora Elgin** é uma aplicação desenvolvida em Java para realizar operações com impressoras térmicas Elgin, especialmente os modelos **i8 e i9**.

O projeto foi realizado no contexto da disciplina de **Programação Orientada a Objetos (POO)**, no curso técnico em Tecnologia da Informação integrado ao Ensino Médio.

Por meio de uma interface de terminal, o programa oferece cadastro e autenticação de usuários, configuração de conexão e acesso a dez funcionalidades relacionadas à impressora.

O desenvolvimento permitiu explorar tanto conceitos de orientação a objetos quanto a integração entre Java e bibliotecas nativas.

## ✦ Funcionalidades implementadas

| Opção | Funcionalidade | Descrição |
|---|---|---|
| `01` | Configurar conexão | Define modelo, tipo de conexão e parâmetros. |
| `02` | Abrir conexão | Estabelece comunicação com a impressora. |
| `03` | Fechar conexão | Encerra a comunicação com o equipamento. |
| `04` | Imprimir texto | Permite informar um texto personalizado. |
| `05` | Imprimir QR Code | Gera a impressão de um código QR. |
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
| **POO** | Organização de classes, atributos e métodos |
| **IntelliJ IDEA** | Ambiente de desenvolvimento |
| **JNA 5.15.0** | Comunicação entre Java e código nativo |
| **SDK Elgin / DLL** | Acesso às funções da impressora |
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
└── README.md
```

**Responsabilidades principais:**

- `main.java`: execução do sistema e gerenciamento do menu.
- `impressora.java`: configuração e execução das operações da impressora.
- `usuario.java`: cadastro de usuários.
- `login.java`: autenticação e controle de acesso.
- `ImpressoraDLL.java`: interface de integração com a biblioteca nativa da Elgin.

## ✦ Como executar

**1. Preparação do ambiente**

É necessário ter o Java instalado, configurar a biblioteca JNA e disponibilizar as bibliotecas nativas compatíveis com a arquitetura do sistema operacional.

**2. Abertura do projeto**

Abra a pasta do repositório no IntelliJ IDEA e confirme a configuração das dependências.

**3. Execução**

Execute a classe `main.java`. O programa iniciará o processo de cadastro e autenticação, seguido do menu principal.

**4. Utilização da impressora**

Configure a conexão antes de tentar abri-la. Para executar as operações físicas, é necessário utilizar uma impressora Elgin compatível e corretamente conectada.

## ✦ Testes e limitações

> ⚠️ **Transparência sobre os testes:** a implementação das funcionalidades no código não significa que todas tenham sido verificadas em uma impressora física.

Durante o desenvolvimento, foram realizados testes de execução do programa, navegação pelo menu, autenticação e verificações de comportamento diante de uma conexão fechada.

**Nem todas as dez funcionalidades foram testadas presencialmente no equipamento.**

Portanto, a impressão efetiva de textos, QR Codes, códigos de barras, documentos SAT, bem como o acionamento da gaveta e os sinais sonoros, ainda dependem de validação física completa.

O projeto representa uma implementação acadêmica das funcionalidades previstas, e não um sistema comercial homologado ou integralmente validado.

## ✦ Desenvolvimento e aprendizado

Este trabalho proporcionou experiência prática com:

- Desenvolvimento de aplicações Java orientadas a objetos.
- Separação de responsabilidades entre classes.
- Construção de menus e fluxos interativos.
- Validação de dados e tratamento de erros.
- Integração com bibliotecas externas.
- Uso de ferramentas de versionamento.
- Leitura, adaptação e compreensão de implementações de referência.

O código foi aprimorado progressivamente ao longo da atividade, incorporando correções, sugestões e melhorias técnicas.

## ✦ Créditos e agradecimentos

O projeto foi desenvolvido como atividade acadêmica, contando com orientações e contribuições importantes durante sua elaboração.

**Ao professor Richard:** agradecimento pelas explicações, correções e orientações técnicas que contribuíram para a estruturação do projeto e para a compreensão dos métodos utilizados.

**A Pietro Mandu Gama:** agradecimento pelo auxílio como referência na implementação e no aprimoramento de funcionalidades, especialmente em operações de impressão, validação e integração com a biblioteca Elgin.

O trabalho também contou com apoio de ferramentas de inteligência artificial na organização, revisão e adaptação de trechos do código e da documentação.

Essas contribuições são reconhecidas como parte do processo de aprendizagem e desenvolvimento acadêmico.

## ✦ Considerações finais

O desenvolvimento deste sistema representa uma aplicação prática dos conhecimentos adquiridos em Programação Orientada a Objetos, conectando conceitos estudados em sala a um dispositivo real.

Embora ainda existam etapas de validação física, o projeto reúne as funcionalidades propostas em uma aplicação organizada, com autenticação, menu interativo e integração com a biblioteca da impressora.

---

**Desenvolvido para fins educacionais.**

*Java • Programação Orientada a Objetos • Tecnologia da Informação • 2026*