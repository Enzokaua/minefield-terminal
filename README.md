# Campo Minado no Terminal

> **Campo Minado no Terminal** é um projeto desenvolvido para simular o clássico jogo **Campo Minado**, utilizando **Java 21**. O jogo é executado no terminal, com um tabuleiro gerado dinamicamente e interação via teclado. Foi projetado para oferecer uma experiência simples e funcional, utilizando **arrays** para representar o tabuleiro e a classe **Scanner** para capturar as jogadas do usuário. O projeto também inclui testes automatizados com **JUnit 5** para validar suas funcionalidades.

## 💡 Funcionalidades

O jogo implementa as principais regras do **Campo Minado**:
- O jogador pode selecionar células do tabuleiro informando coordenadas (linha e coluna).
- Células podem conter bombas, números (indicando a quantidade de bombas adjacentes) ou espaços vazios.
- Caso o jogador escolha uma célula com bomba, o jogo termina.
- O jogador vence ao revelar todas as células sem bombas.
- O tabuleiro é gerado de forma dinâmica, com bombas distribuídas aleatoriamente.


---

## 💻 Pré-requisitos

Certifique-se de ter o seguinte ambiente configurado antes de executar o projeto:
- **Java 21** instalado no sistema;
- **JUnit 5** para rodar os testes unitários;
- Um editor de código como IntelliJ IDEA ou VS Code.

## 🚀 Sobre o Projeto

O projeto foi desenvolvido com foco em boas práticas de programação, como:
- Uso de **arrays** para manipular o tabuleiro;
- Validação de entrada do usuário com a classe **Scanner**;
- Métodos modulares para facilitar a leitura e manutenção do código;
- Testes unitários abrangentes utilizando **JUnit 5**, cobrindo cenários de vitória, derrota e jogadas inválidas.

### Estrutura do Código

#### Tabuleiro
- Representado por um array bidimensional de caracteres.
- Os estados possíveis das células incluem:
- Célula não revelada.
- Célula contendo uma bomba.
- Quantidade de bombas adjacentes.
- Célula vazia (sem bombas adjacentes).

#### Entrada do Usuário
- O jogador informa coordenadas no formato `linha coluna`.
- Entradas inválidas (fora do tabuleiro ou células já reveladas) são tratadas com mensagens de erro.

#### Testes Unitários
- Validação de cenários com JUnit 5:
- Testes para geração de tabuleiro.
- Testes para jogadas válidas e inválidas.
- Testes para condições de vitória e derrota.

---

## :coffee: Como Usar

1. **Clone o repositório**:
 ```bash
 git clone https://github.com/seu-usuario/campo-minado-terminal.git
 cd campo-minado-terminal
```
2. **Compile e execute o jogo**
3. **Execute os testes**
```maven
mvn test
```
