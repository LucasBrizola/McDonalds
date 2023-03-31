package com.tabd.mcdonalds.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("mcDonalds")
public class McDonalds {
    @Id
    private int n_Pedido;
    private String item;
    private int qtd;
    private double valor;

    public McDonalds() {
    }

    public void setN_Pedido(Integer n_Pedido) {
        this.n_Pedido = n_Pedido;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getN_Pedido() {
        return n_Pedido;
    }

    public String getItem() {
        return item;
    }

    public int getQtd() {
        return qtd;
    }

    public double getValor() {
        return valor;
    }

}
