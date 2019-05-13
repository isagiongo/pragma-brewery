[![Comments (%)](https://sonarcloud.io/api/badges/measure?key=isagiongo_pragma-brewery&metric=comment_lines_density)](https://sonarcloud.io/component_measures?id=isagiongo_pragma-brewery&metric=comment_lines_density)
[![Open issues](https://sonarcloud.io/api/badges/measure?key=isagiongo_pragma-brewery&metric=open_issues)](https://sonarcloud.io/component_measures?id=isagiongo_pragma-brewery&metric=open_issues)
[![Code smells](https://sonarcloud.io/api/badges/measure?key=isagiongo_pragma-brewery&metric=code_smells)](https://sonarcloud.io/component_measures?id=isagiongo_pragma-brewery&metric=code_smells)
[![Technical debt](https://sonarcloud.io/api/badges/measure?key=isagiongo_pragma-brewery&metric=sqale_index)](https://sonarcloud.io/component_measures?id=isagiongo_pragma-brewery&metric=sqale_index)
[![Bugs](https://sonarcloud.io/api/badges/measure?key=isagiongo_pragma-brewery&metric=bugs)](https://sonarcloud.io/component_measures?id=isagiongo_pragma-brewery&metric=bugs)
[![Reliability remediation effort](https://sonarcloud.io/api/badges/measure?key=isagiongo_pragma-brewery&metric=reliability_remediation_effort)](https://sonarcloud.io/component_measures?id=isagiongo_pragma-brewery&metric=reliability_remediation_effort)
[![Coverage](https://sonarcloud.io/api/badges/measure?key=isagiongo_pragma-brewery&metric=coverage)](https://sonarcloud.io/component_measures?id=isagiongo_pragma-brewery&metric=coverage)

Code Challenge for PragmaTeam - DBServer - V1

- API Rest para validar a temperatura de determinado container de cerveja e responder se está adequada ou inválida. 
- A requisição é feita via POST, enviando o tipo da cerveja na URL e a temperatura atual do container via body. 
- Na resposta da requisição, teremos status e mensagem, informando se a temperatura está ok ou não. 
- Utilizado o padrão de projetos Strategy que, permite implementar uma interface genérica em nossas classes mais específicas, permitindo o projeto 
escalar em tipos de cerveja sem precisar sofrer modificações, seguindo o princípio aberto/fechado do SOLID. 
- Também foi verificado que o princípio da segregação de interface foi mantido, visto que as classes que implementam a interface não são obrigadas a depender de métodos que 
não utilizam. 
- No arquivo application.yml os tipos de cerveja são mapeadas para seus validadores específicos, eliminando a necessidade de 
IF's para identificar qual o validador deve ser utilizado quando é realizado uma requisição com o nome do tipo da cerveja.

- Análise de código no Sonarcloud: https://sonarcloud.io/dashboard?id=isagiongo_pragma-brewery
- Swagger (Deploy no Heroku): https://pragma-brewery.herokuapp.com/
