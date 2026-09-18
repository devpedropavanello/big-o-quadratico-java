# Big O Quadrático em Java

Exemplo prático de um algoritmo com complexidade quadrática **O(N²)**, desenvolvido em Java.

O projeto gera todos os confrontos possíveis entre os participantes de uma lista, sem criar confrontos repetidos e sem colocar um participante contra ele mesmo.

## Objetivo

Demonstrar, de forma prática, como o tempo de execução de um algoritmo cresce de maneira quadrática em relação à quantidade de elementos recebidos.

## Cenário utilizado

Considere uma competição em que todos os participantes precisam se enfrentar uma vez.

Para os participantes:

```text
Ana, Bruno, Carlos e Diana
```

São gerados os confrontos:

```text
Ana x Bruno
Ana x Carlos
Ana x Diana
Bruno x Carlos
Bruno x Diana
Carlos x Diana
```

## Algoritmo

O algoritmo utiliza dois laços de repetição:

```java
for (int i = 0; i < participantes.size(); i++) {
    for (int j = i + 1; j < participantes.size(); j++) {
        confrontos.add(
                new Confronto(
                        participantes.get(i),
                        participantes.get(j)
                )
        );
    }
}
```

O segundo laço começa em `i + 1` para evitar:

- confronto de um participante contra ele mesmo;
- confrontos repetidos;
- geração de `Ana x Bruno` e `Bruno x Ana` como confrontos diferentes.

## Análise de complexidade

Para uma entrada com `N` participantes, a quantidade de confrontos é:

```text
N × (N - 1) / 2
```

Expandindo a expressão:

```text
(N² - N) / 2
```

Na análise assintótica, constantes e termos de menor crescimento são desconsiderados. Portanto, a complexidade é:

```text
O(N²)
```

Mais precisamente, o algoritmo possui complexidade **Θ(N²)**, pois sempre precisa gerar todos os pares possíveis.

| Participantes (N) | Confrontos |
|------------------:|-----------:|
| 2                 | 1          |
| 3                 | 3          |
| 4                 | 6          |
| 5                 | 10         |
| 10                | 45         |
| 100               | 4.950      |

### Complexidade de tempo

A complexidade de tempo é **O(N²)** porque a quantidade de operações cresce de forma quadrática conforme o número de participantes aumenta.

### Complexidade de espaço

A complexidade de espaço também é **O(N²)**, pois todos os confrontos gerados são armazenados em uma lista.

## Tecnologias

- Java 21;
- Apache Maven 3.9;
- JUnit 5.

## Como executar

### Pré-requisitos

- JDK 21 ou superior;
- Maven 3.9 ou superior.

Clone o repositório:

```bash
git clone git@github.com:devpedropavanello/big-o-quadratico-java.git

cd big-o-quadratico-java
```

Compile o projeto:

```bash
mvn clean compile
```

Execute com os participantes padrão:

```bash
java -cp target/classes br.com.pedropavanello.bigo.Main
```

Também é possível informar participantes pelo terminal:

```bash
java -cp target/classes br.com.pedropavanello.bigo.Main Pedro Renan Caio
```

## Exemplo de saída

```text
Participantes (N = 4): Ana, Bruno, Carlos, Diana

Confrontos gerados:
1. Ana x Bruno
2. Ana x Carlos
3. Ana x Diana
4. Bruno x Carlos
5. Bruno x Diana
6. Carlos x Diana

Total de confrontos: 6
```

## Testes

Execute os testes unitários com:

```bash
mvn clean test
```

Os testes verificam:

- geração de todos os confrontos únicos;
- quantidade de confrontos conforme a fórmula `N × (N - 1) / 2`;
- comportamento quando não existem participantes suficientes;
- rejeição de uma lista nula.

## Estrutura do projeto

- `Confronto.java`: representa um confronto imutável;
- `GeradorConfrontos.java`: contém o algoritmo O(N²);
- `Main.java`: executa e apresenta o exemplo;
- `GeradorConfrontosTest.java`: contém os testes unitários.

## Autor

[Pedro Pavanello](https://github.com/devpedropavanello)