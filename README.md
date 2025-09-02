# Sistema de Controle para Estadia de Brinquedos

## Descrição

Este é um projeto simples em Java com Swing, desenvolvido originalmente como um trabalho de faculdade e posteriormente refatorado para aplicar conceitos de Clean Code e boas práticas de desenvolvimento. O software gerencia o cadastro de responsáveis e crianças, e calcula o valor a ser pago pela estadia em um espaço de recreação.

## Tecnologias Utilizadas

- JDK 24
- Swing para a interface gráfica

## Como Executar

1. Clone o repositório.
2. Abra o projeto em sua IDE (ex: IntelliJ, NetBeans, Eclipse).
3. Se estiver usando Maven, a IDE irá baixar as dependências automaticamente.
4. Localize e execute a classe principal: `io.github.periclesfmartins.checkinkids.main.Aplicacao`.

## Estrutura do Projeto

O projeto segue uma arquitetura básica separando as responsabilidades em:

- `model`: Classes que representam os dados (Responsavel, Crianca, Estadia).
- `ui`: Classes responsáveis pela interface gráfica (as Telas).
- `service`: Classes que contêm a lógica de negócio (cálculo de valores).
- `main`: Classe principal que inicia a aplicação.
