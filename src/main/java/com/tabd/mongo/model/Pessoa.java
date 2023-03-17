package com.tabd.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pessoa")
public class Pessoa {
    @Id
    private Integer id;
    private String name;
    private int idade;

    public Pessoa() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

}
