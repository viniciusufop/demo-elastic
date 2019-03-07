# Demostração de Integração do Spring com o ElasticSearch

Projeto tem objetivo estudar a comunicação entre Spring Data e o ElasticSearch

## Tecnologias utilizadas

* Java 8
* Spring Boot
* Spring Data
* Spring Data ElasticSearch
* ElasticSearch
* Kibana
* Docker

## Configurando o ElasticSearch

Utilizei imagem docker disponibilizada pelo [Sebp](https://hub.docker.com/u/sebp) no [imagens](https://elk-docker.readthedocs.io/) versão 4.6.1.
Executando o comando:
```
docker run -p 5601:5601 -p 9200:9200 -p 9300:9300 -p 5044:5044 -it --name elasticsearch sebp/elk:641
```
Para verificar se o container subiu corretamente, acesse as url's: 

* [elasticsearch](http://localhost:9200)
* [kibana](http://localhost:5601)


## Executando o projeto no Intelij

Importe o projeto e execute a classe ``` DemoElasticApplication.class ```

## Swagger

O projeto está configurado para utilizar springfox-swagger, disponibilizando interface de comunição através da url http://localhost:9000/swagger-ui.html.
