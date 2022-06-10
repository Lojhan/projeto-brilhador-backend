# Mic Pessoas

Microserviço de exemplo. (Construído em sala de aula no dia 01/04/2022)

## Como baixar:

1) Windows: cmd deve ser executado na barra de navegação do Windows Explorer
2) A IDE Visual Studio Code deve estar instalada para executar o comando code .  

```
cmd na pasta raiz
git clone https://gitlab.com/gilbriatore/2022/prj-sex-noi/mic-pessoas.git
cd mic-pessoas
code .
```
## Para testar as APIs

3) Rodar a aplicação PessoaApplication
3) Utilizar a extensão YARC (Yet Another REST Client) do navegador Chrome

```
GET http://localhost:8080/pessoas
GET http://localhost:8080/pessoas/1
POST http://localhost:8080/pessoas
Payload:
{
  "nome": "..."
}
PUT http://localhost:8080/pessoas/1
Payload:
{
  "nome": "...novo nome..."
}
DELETE http://localhost:8080/pessoas/1
```