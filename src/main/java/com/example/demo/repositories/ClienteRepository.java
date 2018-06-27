package com.example.demo.repositories;

import com.example.demo.documents.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    Cliente findByNome(String name);

    @Query("{ 'idade' : { $gt: ?0, $lt: ?1} }")
    List<Cliente> findByIdadeBetween(int idadeInicial, int idadeFinal);
}
