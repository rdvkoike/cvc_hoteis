# CVC - Hotel REST API

Sistema de Busca de Hoteis e valores de estadia

Desenvolvido como TDD, com tecnologias Java13, SpringBoot, Swagger, Junit, Gradle, Spring Data, Spring Security e H2 db.

Sistema funcional, consumindo API de terceiro.

## Como iniciar

Essa aplicação é empacotada com Tomcat embedded. Não é necessário instalação de servidor. 

Para iniciar, execute o comando "java -jar":

java -jar target/arquivobuild.jar

## Segurança

Autentificação Bearer, com token para acesso a API.

O sistema valida no Banco de Dados H2 os dados de autenticação.

Para pegar o token, acessar o "/signin" com "username" e "password" válido.

Valores default:

username: usertest1
password: 12345

Obs: Desabilitado para testes. Para habilitar, alterar classe "SecurityConfig".

## Documentação

Acesse http://localhost:8080/swagger-ui.html para documentação de uso da API.

## Pendencias / Próximos passos

- docker e kunernets para escalabilidade e performance

- melhorar segurança com Spring Security

- implementar build prod/dev

- melhorar performance do codigo

- melhorar validações

- melhorar documentação

- melhorar cobertura dos testes

- melhorar Error Handling
