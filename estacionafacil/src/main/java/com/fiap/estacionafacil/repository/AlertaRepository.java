package com.fiap.estacionafacil.repository;

import com.fiap.estacionafacil.model.Alerta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlertaRepository extends MongoRepository<Alerta, String> {
    List<Alerta> findByMotoristaId(String motoristaId);
    List<Alerta> findByPagamentoId(String pagamentoId);
}
