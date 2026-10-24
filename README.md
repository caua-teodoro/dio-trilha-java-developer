# ☕ Trilha Java Developer - DIO

Repositório dedicado aos estudos, códigos de aulas práticas e desafios de projeto desenvolvidos durante a **Trilha Java Developer** da [DIO (Digital Innovation One)](https://www.dio.me/).

---

## 📂 Estrutura do Repositório

O repositório está organizado de forma progressiva por módulos temáticos, padronizado em `kebab-case`:

```text
dio-trilha-java-developer/
├── 01-sintaxe-java/
│   ├── tipos-variaveis-e-operadores/   # Tipos primitivos, variáveis, operadores e comparações
│   ├── metodos/                        # Anatomia de métodos e exercício prático SmartTv
│   ├── documentacao/                   # Boas práticas de comentários e tags Javadoc
│   ├── terminal-e-argumentos/          # Execução via terminal, argumentos (args) e Scanner
│   └── desafio-conta-banco/            # 🏆 Desafio: Simulação de conta bancária via terminal
│
├── 02-controle-de-fluxo/
│   ├── estruturas-de-controle/         # Condicionais (if/switch), repetição (for/while) e exceções
│   ├── controle-candidatos/            # 📋 Estudo de Caso: Sistema de processo seletivo
│   └── desafio-controle-fluxo/         # 🏆 Desafio: Contador com validação e exceção customizada
│
└── 03-poo/
    ├── poo-fundamentos/                # Pacotes, visibilidade, getters/setters, construtores, Enums e UML
    ├── poo-pilares/                    # Encapsulamento, herança, abstração, polimorfismo e interfaces
    ├── desafio-componente-iphone/      # 🏆 Desafio: Modelagem UML e código dos componentes do iPhone
    └── desafio-banco-digital/          # 🏆 Desafio: Banco Digital orientado a objetos (Maven/Java)
```

---

## 🧭 Índice por Módulo

### 1️⃣ Sintaxe Java (`01-sintaxe-java`)
Fundamentos da linguagem e estrutura básica de programas em Java:
- **[`tipos-variaveis-e-operadores`](./01-sintaxe-java/tipos-variaveis-e-operadores)**: Declaração de variáveis, tipos primitivos, operadores aritméticos, relacionais, lógicos e comparações.
- **[`metodos`](./01-sintaxe-java/metodos)**: Definição de métodos, parâmetros, retornos e implementação da classe `SmartTv`.
- **[`documentacao`](./01-sintaxe-java/documentacao)**: Exemplo de classe documentada (`Calculadora`) para geração de documentação com Javadoc.
- **[`terminal-e-argumentos`](./01-sintaxe-java/terminal-e-argumentos)**: Passagem de parâmetros pela linha de comando e entrada interativa com `Scanner`.
- 🏆 **[`desafio-conta-banco`](./01-sintaxe-java/desafio-conta-banco)**: Projeto `ContaTerminal` que recebe dados bancários via terminal e exibe a mensagem de confirmação de abertura de conta.

---

### 2️⃣ Controle de Fluxo (`02-controle-de-fluxo`)
Direcionamento da execução do código, laços e tratamento de erros:
- **[`estruturas-de-controle`](./02-controle-de-fluxo/estruturas-de-controle)**:
  - `estruturascondicionais`: `if/else`, ternário e `switch-case`.
  - `estruturasderepeticao`: `for`, `for-each`, `while`, `do-while` e `break/continue`.
  - `tratamentoexcecoes`: Blocos `try-catch` e criação de exceções personalizadas (`CepInvalidoException`).
- 📋 **[`controle-candidatos`](./02-controle-de-fluxo/controle-candidatos)**: Estudo de caso simulando seleção, triagem salarial e tentativas de contato com candidatos.
- 🏆 **[`desafio-controle-fluxo`](./02-controle-de-fluxo/desafio-controle-fluxo)**: Sistema `Contador` que lê dois parâmetros inteiros, valida a ordem lançando `ParametrosInvalidosException` quando necessário e realiza a contagem no console.

---

### 3️⃣ Programação Orientada a Objetos (`03-poo`)
Modelagem de domínio, princípios de orientação a objetos e arquitetura de classes:
- **[`poo-fundamentos`](./03-poo/poo-fundamentos)**: Organização em pacotes (`lanchonete`, `escola`, `clinical`), visibilidade de recursos, `Getters` e `Setters`, construtores, `Enums` (`EstadoBrasileiro`) e anotações de UML.
- **[`poo-pilares`](./03-poo/poo-pilares)**: Prática dos 4 pilares da POO (`encapsulamento`, `heranca_abstracao_polimorfismo`) e contratos com `interfaces` (`Impressora`, `Digitalizadora`, `Copiadora`, `EquipamentoMultifuncional`).
- 🏆 **[`desafio-componente-iphone`](./03-poo/desafio-componente-iphone)**: Diagramação UML e implementação em Java das interfaces `ReprodutorMusical`, `AparelhoTelefonico` e `NavegadorInternet` unificadas na classe `Iphone`.
- 🏆 **[`desafio-banco-digital`](./03-poo/desafio-banco-digital)**: Aplicação completa de um Banco Digital utilizando POO, camadas (`model`, `repository`, `service`, `controller`) e gerenciamento via Maven.

---

## 🚀 Como Executar os Projetos

1. Certifique-se de ter o **JDK (Java Development Kit)** instalado (Java 17+ recomendado).
2. Navegue até a pasta do módulo/projeto desejado.
3. Para projetos simples, compile e execute o arquivo `.java` principal a partir da pasta `src`:
   ```bash
   javac NomeDaClasse.java
   java NomeDaClasse
   ```
4. Para o projeto Maven (`03-poo/desafio-banco-digital`), utilize sua IDE ou o Maven CLI:
   ```bash
   cd 03-poo/desafio-banco-digital
   mvn compile exec:java
   ```
