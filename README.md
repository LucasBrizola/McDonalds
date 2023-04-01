# McDonalds

API restful para a prova final de TABD na fundatec, com conexão no mongoDB Atlas

Exemplo de body:
{
    "n_Pedido":"1",
    "item":"batata pequena",
    "qtd":1,
    "valor": 18.50
}

endpoints:

GET http://localhost:8080/mcdonalds/cardapio - listar todos pedidos
GET http://localhost:8080/mcdonalds/cardapio/{n_Pedido} - listar pedido por n_Pedido
POST http://localhost:8080/mcdonalds/cardapio - salvar pedido
PUT http://localhost:8080/mcdonalds/cardapio/{n_Pedido} - editar pedido
DELETE http://localhost:8080/mcdonalds/cardapio/{n_Pedido} - deletar pedido
