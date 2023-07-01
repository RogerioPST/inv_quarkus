# hackcaixa2023

Este projeto utiliza Quarkus, o framework supersônico subatômico Java. 

Este projeto foi desenvolvido com a versão 11 do Java e a versão 3.8.6 do Maven.

Se quiser saber mais sobre Quarkus, por favor, visite a página: https://quarkus.io/ .

Endereço do swagger UI: http://localhost:8080/q/swagger-ui/#/

## Executando a aplicação no modo desenvolvedor

Você pode executar a aplicação no modo desenvolvedor usando:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTA:_**  Quarkus agora entrega uma interface dev (Dev UI) disponível apenas no modo desenvolvedor em http://localhost:8080/q/dev/.

## Empacotando e executando a aplicação

A aplicação pode ser empacotada usando:
```shell script
./mvnw package
```

Esse comando gera o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`.

Fique atento que esse arquivo não é um _über-jar_, já que as dependências são copiadas no diretório `target/quarkus-app/lib/`.

A aplicação agora é executada usando `java -jar target/quarkus-app/quarkus-run.jar`.


Se quiser construir um arquivo _über-jar_, execute o seguinte comando:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

A Aplicação, empacotada como um _über-jar_, é agora executável usando `java -jar target/*-runner.jar`.

## Criando um executável nativo

Você pode criar um executável nativo usando: 
```shell script
./mvnw package -Pnative
```

Ou, se você não tem o GraalVM instalado, você pode rodar o executável nativo em container usando: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

Você pode então rodar o seu executável nativo com: `./target/hackcaixa2023-1.0.0-SNAPSHOT-runner`

Se você quiser aprender mais sobre construindo executáveis nativos, por favor consulte https://quarkus.io/guides/maven-tooling.