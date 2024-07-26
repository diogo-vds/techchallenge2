package com.fiap.estacionafacil.repository;

import com.fiap.estacionafacil.model.MetodoPagamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetodoPagamentoRepository extends MongoRepository<MetodoPagamento, String> {
}
