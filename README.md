# Sistema de Controle para Estadia de Brinquedos

![Demonstração do Check-in Kids](https://i.imgur.com/wvYEPQE.gif)

## Descrição

Este é um projeto simples em Java com Swing, desenvolvido originalmente como um trabalho de faculdade e posteriormente refatorado para aplicar conceitos de Clean Code, boas práticas de desenvolvimento e arquitetura em camadas. O software gerencia o cadastro de responsáveis e crianças, e calcula o valor a ser pago pela estadia em um espaço de recreação com base no tempo de permanência.

## Funcionalidades

- Cadastro completo de responsáveis e crianças.
- Validação de dados de entrada (idade mínima para responsável, idade máxima para criança).
- Cálculo de valor da estadia com descontos progressivos baseados no tempo.
- Interface gráfica intuitiva dividida em 3 etapas.

## Status Atual e Melhorias Futuras

No estado atual, o projeto **não utiliza um banco de dados**. Todas as informações de cadastro são voláteis, ou seja, mantidas em memória apenas durante uma única execução do programa.

Este projeto serve como uma base sólida e existem várias oportunidades para melhorias futuras, como:

- [ ] **Persistência de Dados:** Implementar a conexão com um banco de dados como o **MySQL** ou **PostgreSQL** para armazenar os registros de forma permanente.
- [ ] **Geração de Relatórios:** Adicionar uma funcionalidade para gerar relatórios simples, como o total faturado em um período.
- [ ] **Melhorias na UI:** Refinar a interface do usuário.

## Tecnologias Utilizadas

- **Java (JDK 24)**
- **Java Swing** para a interface gráfica
- **Maven** para gerenciamento de dependências e build do projeto

## Pré-requisitos

Antes de começar, você precisa ter instalado em sua maquina:

[Java JDK24](https://www.oracle.com/java/technologies/downloads/) ou superior.  
[Git](https://git-scm.com/) para clonar o repositório.

## Como Executar

1. Clone o repositório:
2. Abra o projeto em sua IDE (ex: IntelliJ, NetBeans, Eclipse).
3. Se estiver usando Maven, a IDE irá baixar as dependências automaticamente.
4. Localize e execute a classe principal: `io.github.periclesfmartins.checkinkids.main.Aplicacao`.

## Estrutura do Projeto

O projeto segue uma arquitetura básica separando as responsabilidades em:

- `model`: Classes que representam os dados (Responsavel, Crianca, Estadia).
- `ui`: Classes responsáveis pela interface gráfica (as Telas).
- `service`: Classes que contêm a lógica de negócio (cálculo de valores).
- `main`: Classe principal que inicia a aplicação.
