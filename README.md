[![Build Status](https://travis-ci.org/isagiongo/pragma-brewery.svg?branch=master)](https://travis-ci.org/isagiongo/pragma-brewery)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=isagiongo_pragma-brewery&metric=alert_status)](https://sonarcloud.io/dashboard?id=isagiongo_pragma-brewery)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=isagiongo_pragma-brewery&metric=coverage)](https://sonarcloud.io/dashboard?id=isagiongo_pragma-brewery)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=isagiongo_pragma-brewery&metric=bugs)](https://sonarcloud.io/dashboard?id=isagiongo_pragma-brewery)
[![Code smells](https://sonarcloud.io/api/project_badges/measure?project=isagiongo_pragma-brewery&metric=code_smells)](https://sonarcloud.io/dashboard?id=isagiongo_pragma-brewery)

# Code Challenge for PragmaTeam - DBServer - V1

### Para testar a API:
#### A API está no Heroku,  então não é necessário rodar localmente. Com a interface do Swagger é possível testar a requisição
1. Acesse https://pragma-brewery.herokuapp.com/
2. Clique em BeerController > POST Validade Temperature > Try it out
3. Digite no campo Beer Name, o nome da cerveja que você quer verificar (Opções válidas: Lager, IPA, Pilsner, Stout, PaleAle, WheatBeer)
4. Digite em Temperature, a temperatura atual do container que armazena a cerveja escolhida. Aceita valores positivos e negativos, como por exemplo: -1, -8, 0, 2, 5, ect.
5. Clique em Execute, e observe logo abaixo, no Server response, a mensagem retornada da API, que pode ser uma das seguintes:
* "message": "Temperature OK" - Stauts code: 200
* "message": "Inappropriate Temperature" - Status code: 417
* "message": "Invalid Beer" - Status code: 400

## Frameworks / Tecnologias utilizadas
* Java
* Spring Boot
* Gradle
* JUnit
* Rest Assured
* Swagger
* Travis CI
* Sonarcloud

## Descrição da implementação
- API Rest para validar a temperatura de determinado container de cerveja e responder se está adequada ou inválida. 
- A requisição é feita via POST, enviando o tipo da cerveja na URL e a temperatura atual do container via body. 
- Na resposta da requisição, teremos status e mensagem, informando se a temperatura está ok ou não. 
- Utilizado o padrão de projetos Strategy que, permite implementar uma interface genérica em nossas classes mais específicas, permitindo o projeto 
escalar em tipos de cerveja sem precisar sofrer modificações, seguindo o princípio aberto/fechado do SOLID. 
- Também foi verificado que o princípio da segregação de interface foi mantido, visto que as classes que implementam a interface não são obrigadas a depender de métodos que 
não utilizam. 
- No arquivo application.yml os tipos de cerveja são mapeadas para seus validadores específicos, eliminando a necessidade de 
IF's para identificar qual o validador deve ser utilizado quando é realizado uma requisição com o nome do tipo da cerveja.
- A aplicação está coberta por códigos unitários e de integração, com 96% de cobertura.
- Análise de código no Sonarcloud: https://sonarcloud.io/dashboard?id=isagiongo_pragma-brewery
- Api Docs (Swagger): https://pragma-brewery.herokuapp.com/
- Integração Contínua com Travis CI: https://travis-ci.org/isagiongo/pragma-brewery
