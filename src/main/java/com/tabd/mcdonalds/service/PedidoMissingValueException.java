package com.tabd.mcdonalds.service;

public class PedidoMissingValueException extends RuntimeException {

    public PedidoMissingValueException() {
        super("o pedido necessita de todos os campos preenchidos");
    }
}
