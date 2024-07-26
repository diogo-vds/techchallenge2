package com.fiap.estacionafacil.repository;

import com.fiap.estacionafacil.model.Motorista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MotoristaRepository extends MongoRepository<Motorista, String> {
}
