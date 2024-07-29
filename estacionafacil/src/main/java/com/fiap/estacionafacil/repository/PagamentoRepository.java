package com.fiap.estacionafacil.repository;

import com.fiap.estacionafacil.model.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
    List<Pagamento> findByMotoristaId(String motoristaId);
    List<Pagamento> findByVeiculoId(String veiculoId);
}
