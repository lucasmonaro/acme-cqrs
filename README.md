# POC: CQRS com Spring Boot e Kafka


Este projeto é uma POC que demonstra a implementação de CQRS (Command Query Responsibility
Segregation) usando Spring Boot e Kafka. Nesse projeto será possível
observar o comportamento de um microsserviço de comando, outro de consulta
e outro responsável por sincronizar dados.

## Pré-requisitos 📋

- JDK 17
- Docker e Docker Compose

## Imagens Docker 🐳
- MySQL
- MongoDB
- Apache Kafka
- Zookeper
- KafDrop

## Instalação 🔧

Inicie o ambiente utilizando o Docker Compose:
```sh
docker-compose up -d
```

Gere os arquivos .jar rodando o comando na pasta principal do projeto:
```sh
mvn clean package
```

### Microsserviço para comando

Rode o comando na pasta principal do projeto: 
```bash
java -jar microservice-command/target/microservice-command-0.0.1-SNAPSHOT.jar
```

### Microsserviço para consultas

Rode o comando na pasta principal do projeto:
```bash
java -jar microservice-query/target/microservice-query-0.0.1-SNAPSHOT.jar
```

### Microsserviço para sincronização

Rode o comando na pasta principal do projeto:
```bash
java -jar microservice-sync/target/microservice-sync-0.0.1-SNAPSHOT.jar
```

## Utilizando 🚀

Para testar o microsserviço de comando você pode executar a seguinte requisição:
````
curl --location 'localhost:8080/command/produto' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Foo",
    "descricao": "Bar",
    "preco": 1000
}'
````


Para testar o microsserviço de consulta você pode executar a seguinte requisição:
````
curl --location 'localhost:8081/query/produto?nome=foo'
````
