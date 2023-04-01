package com.tabd.mcdonalds.service;

public class PedidoNotFoundException extends RuntimeException {

    public PedidoNotFoundException(Integer n_pedido) {
        super("pedido " + n_pedido + " não encontrado");
    }
}
