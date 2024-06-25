# Professor Allocation DeepDevs

Este é o repositório do projeto Professor Allocation DeepDevs, Api desenvolvida pelos integrantes Bruno Dutra, Jacob Berenstein, [Fábio Queiroz](https://www.linkedin.com/in/antoniofabioqueiroz/) e [Pablo Jorge](https://www.linkedin.com/in/pjmaciel/). 

# Design da Aplicação

A nossa aplicação segue o padrão de arquitetura em camadas, com a separação de responsabilidades clara entre diferentes componentes. As principais camadas da nossa aplicação são as seguintes:

## Modelo (Model)

A camada de modelo é responsável por representar a estrutura de dados da nossa aplicação. Nela, definimos as entidades, objetos ou classes que representam os dados da aplicação e como eles se relacionam entre si. É onde são definidos os atributos, métodos e lógica de negócios associados aos objetos de dados.

## Repositório (Repository)

A camada de repositório lida com o acesso aos dados. Ela fornece interfaces ou classes que abstraem a interação com o banco de dados. Os repositórios são usados para consultar, criar, atualizar e excluir dados no banco de dados. Eles encapsulam a complexidade do acesso aos dados, tornando mais fácil a interação com o banco de dados.

## Serviço (Service)

A camada de serviço contém a lógica de negócios da nossa aplicação. Aqui, implementamos regras de negócios, validações e processamento de dados. Os serviços atuam como intermediários entre o controle e o acesso aos dados. Eles coordenam as ações entre as outras camadas, garantindo a integridade dos dados e a execução correta das operações.

## Controle (Controller)

A camada de controle é responsável por receber as solicitações dos clientes, geralmente via API HTTP, e direcioná-las para a camada de serviço apropriada. Os controladores lidam com a interação do usuário e a apresentação de dados. Eles recebem entradas, processam solicitações e fornecem respostas apropriadas.

Esta arquitetura em camadas proporciona uma separação clara de responsabilidades e torna o nosso código mais organizado e fácil de manter. Além disso, seguimos as melhores práticas de desenvolvimento ao adotar essa abordagem.

Este projeto utiliza o Spring Boot e inclui as seguintes dependências:

- **Spring Boot Version:** 2.7.13
- **Java Version:** 1.8
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Web**
- **MySQL Connector**
- **Spring Boot Starter Test**
- **SpringDoc OpenAPI UI Version:** 1.7.0

# Instalação de Software

Para acompanhar o curso, é necessário ter alguns softwares instalados previamente.

## Ambiente de Desenvolvimento

### Java Development Kit (JDK)

O Java Development Kit (JDK) é necessário para desenvolver aplicativos Java. Certifique-se de instalar o JDK em seu sistema. Você pode baixá-lo [aqui](https://www.oracle.com/br/java/technologies/downloads/).

### Eclipse

O Eclipse é uma IDE (Integrated Development Environment) popular para o desenvolvimento Java. Certifique-se de ter o Eclipse instalado. Você pode baixá-lo [aqui](https://www.eclipse.org/downloads/).

## Banco de Dados

### MySQL

O MySQL é um sistema de gerenciamento de banco de dados relacional amplamente utilizado. Certifique-se de instalá-lo em seu sistema. Você pode baixar o MySQL [aqui](https://dev.mysql.com/downloads/mysql/).

Certifique-se de que todos os softwares estejam devidamente instalados antes de iniciar o projeto.

## Clonar o Repositório

Para clonar este repositório, execute o seguinte comando:

```bash
git clone https://github.com/seu-usuario/professor-allocation-deepdevs.git
```

### Instalação

Certifique-se de ter o Java 8 instalado em seu sistema. Você pode instalar as demais dependências utilizando o Maven. Execute o seguinte comando na raiz do projeto:

```bash
mvn clean install
```

### Documentação da API

A documentação da API pode ser acessada no Swagger UI. Certifique-se de que o aplicativo está em execução localmente e acesse a documentação da API em [Link](http://localhost:8080/swagger-ui/index.html).

