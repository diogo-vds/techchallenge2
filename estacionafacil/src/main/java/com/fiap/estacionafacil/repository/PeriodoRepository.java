package com.fiap.estacionafacil.repository;

import com.fiap.estacionafacil.model.Periodo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PeriodoRepository extends MongoRepository<Periodo, String> {

    Periodo findByPlacaVeiculoAndEncerrado(String idVeiculo, boolean encerrado);
    List<Periodo> findByDataFim(LocalDateTime dataFim);
    List<Periodo> findByEncerradoAndPeriodoFixo(boolean encerrado, boolean periodoFixo);

}
