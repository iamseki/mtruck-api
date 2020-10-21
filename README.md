# MTruck API

**Informaçes sobre o projeto**:

- Versão do Java: `1.8`
- Gerenciador de pacotes: `Maven`
- Ambiente de desenvolvimento: `NetBeans v12.0`

## Rodando a API localmente :book:

Para rodar a API localmente em **`localhost:8080`**

- Windows

  No diretório raíz do projeto execute : `mvnw spring-boot:run`

- Linux/Mac

  No diretório raíz do projeto execute : `./mvnw spring-boot:run`

## Banco de Dados :floppy_disk:

- Banco Relacional utilizado: `Postgres SQL`
  - String de conexão: `jdbc:postgresql://localhost/lp2`
  - Usuário: `postgres` Senha: `admin`
  - Para criação do banco foi utilizado o seguinte [scritp](./scripts/bancomtruck_v1.sql)
  
- Se estiver em um ambiente linux com a engine docker, execute o seguinte comando para inicializar o banco em um container:

      docker run --name mtruck-pg -p 5432:5432 -e POSTGRES_DB=lp2 -e POSTGRES_PASSWORD=admin -d postgres:alpine

## Logging com threads :file_folder:

Criamos dois serviços que executam a thread responsável pela auditoria das rotas, sendo eles: 
  - [AuditoriaService](./src/main/java/mtruck/api/services/AuditoriaService.java)
  - [AuditoriaThread](src/main/java/mtruck/api/services/AuditoriaThread.java)         

>e.g auditoria da rota **[datalog](src/main/java/mtruck/api/services/DatalogService.java)**


## Acesso à documentação :books:

- Rode a API localmente e acesse o endpoint: `http://localhost:8080/swagger-ui.html#/`
