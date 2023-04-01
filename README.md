# mongo

API restful para a aula de TABD na fundatec, com conexão no mongoDB Atlas

Exemplo de body:
{
  "id":1,
  "nome":"lucas",
  "idade":"30"
}

endpoints:

GET localhost:8080/mongo/pessoas - listar todas as pessoas
GET localhost:8080/mongo/pessoa/{id} - listar pessoa por id
GET localhost:8080/mongo/pessoa/nome/{nome} - listar pessoa por nome
POST localhost:8080/mongo/pessoa - salvar pessoa
PUT localhost:8080/pessoa/{id} - editar pessoa
DELETE localhost:8080/pessoa/{id} - deletar pessoa
