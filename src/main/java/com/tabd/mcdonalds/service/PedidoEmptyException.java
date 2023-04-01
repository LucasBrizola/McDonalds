package com.tabd.mcdonalds.service;

public class PedidoEmptyException extends RuntimeException {

    public PedidoEmptyException() {
        super("nenhum pedido foi realizado");
    }
}
