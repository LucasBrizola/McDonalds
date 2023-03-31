package com.tabd.mcdonalds.repository;

import com.tabd.mcdonalds.model.McDonalds;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface McDonaldsRepository extends MongoRepository<McDonalds, Integer> {

}
