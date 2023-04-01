package com.tabd.mcdonalds.service;

public class PedidoRepeatedException extends RuntimeException {

    public PedidoRepeatedException(Integer n_pedido) {
        super("pedido " + n_pedido + " já existe!");
    }
}
