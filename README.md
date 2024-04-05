# Projeto API REST para CRUD de Farmácia

Este é um projeto de API REST desenvolvido em Spring Boot, destinado a gerenciar operações CRUD (Create, Read, Update, Delete) para uma aplicação de farmácia. A API é construída utilizando tecnologias modernas e práticas de desenvolvimento, incluindo Maven para gerenciamento de dependências, MySQL como banco de dados, Flyway para controle de migrações de banco de dados, Lombok para redução de código boilerplate, DTOs para transferência de dados e documentação da API em Swagger.

## Tecnologias Utilizadas:

- **Spring Boot**: Framework Java para construção de aplicativos web e APIs REST de forma rápida e fácil.
- **Maven**: Gerenciador de dependências e construção de projetos.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.
- **Flyway**: Ferramenta para versionamento e migração de banco de dados.
- **Lombok**: Biblioteca para reduzir a verbosidade do código Java.
- **DTO**: Objetos de Transferência de Dados para definir a estrutura dos dados transferidos pela API.
- **Swagger**: Ferramenta para documentação e teste de APIs REST.

## Funcionalidades Principais:

- Cadastro, leitura, atualização e exclusão de produtos farmacêuticos.
- Gestão de categorias de produtos.
- Documentação detalhada da API utilizando Swagger.

## Como Utilizar:

1. **Clonagem do Repositório**:
   ```bash
   git clone https://github.com/arthurvalger/crud-farmacia.git

Configuração do Banco de Dados:

    Configure o arquivo application.properties com as credenciais do seu banco de dados MySQL.

Compilação e Execução:

bash

    mvn clean install
    mvn spring-boot:run

    Acesso à Documentação da API:
        Após a execução do aplicativo, acesse http://localhost:8080/swagger-ui.html para visualizar a documentação da API gerada pelo Swagger.

Este projeto é uma excelente base para o desenvolvimento de sistemas de gerenciamento de farmácias, proporcionando uma estrutura sólida e bem documentada para expansão e personalização.
