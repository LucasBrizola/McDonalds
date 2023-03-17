package com.tabd.mongo.repository;

import com.tabd.mongo.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, Integer> {

    @Query("{name:'?0'}")
    Pessoa findByName(String name);

}
