Code Challenge for PragmaTeam - DBServer

- API Rest para validar a temperatura de determinado container de cerveja e responder se está adequada ou inválida. 
- A requisição é feita via POST, enviando o tipo da cerveja na URL e a temperatura atual do container via body. 
- Na resposta da requisição, teremos status e mensagem, informando se a temperatura está ok ou não. 
- Utilizado o padrão de projetos Strategy que, permite implementar uma interface genérica em nossas classes mais específicas, permitindo o projeto 
escalar em tipos de cerveja sem precisar sofrer modificações, seguindo o princípio aberto/fechado do SOLID. 
- Também foi verificado que o princípio da segregação de interface foi mantido, visto que as classes que implementam a interface não são obrigadas a depender de métodos que 
não utilizam. 
- No arquivo application.yml os tipos de cerveja são mapeadas para seus validadores específicos, eliminando a necessidade de 
IF's para identificar qual o validador deve ser utilizado quando é realizado uma requisição com o nome do tipo da cerveja.
