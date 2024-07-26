package com.fiap.estacionafacil.repository;

import com.fiap.estacionafacil.model.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {
}
