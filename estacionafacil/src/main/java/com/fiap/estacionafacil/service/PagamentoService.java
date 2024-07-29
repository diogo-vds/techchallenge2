package com.fiap.estacionafacil.service;

import com.fiap.estacionafacil.model.Pagamento;
import com.fiap.estacionafacil.model.enumeracao.TipoPagamento;
import com.fiap.estacionafacil.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento criarPagamento(String motoristaId, String veiculoId, TipoPagamento pagamentoMethod, LocalDateTime startTime, boolean taxaFixa) {
        Pagamento pagamento = new Pagamento();
        pagamento.setMotoristaId(motoristaId);
        pagamento.setVeiculoId(veiculoId);
        pagamento.setMetodoPagamento(pagamentoMethod);
        pagamento.setDataInicio(startTime);
        pagamento.setTaxaFixa(taxaFixa);

        if (taxaFixa) {
            pagamento.setQuantia(calcularTaxaFixa());
        } else {
            pagamento.setQuantia(new BigDecimal(0)); // Valor inicial da quantia
        }

        return pagamentoRepository.save(pagamento);
    }

    public Pagamento completarPagamento(String pagamentoId, LocalDateTime dataFim) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoId).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
        pagamento.setDataInicio(dataFim);

        if (!pagamento.isTaxaFixa()) {
            pagamento.setQuantia(calcularTaxaVariavel(pagamento.getDataInicio(), pagamento.getDataFim()));
        }

        return pagamentoRepository.save(pagamento);
    }

    private BigDecimal calcularTaxaFixa() {
        return new BigDecimal("8.0"); // Taxa fixa, podemos escolher um valor
    }

    private BigDecimal calcularTaxaVariavel(LocalDateTime startTime, LocalDateTime dataFim) {
        Duration duration = Duration.between(startTime, dataFim);
        long hours = duration.toHours();
        return new BigDecimal(hours * 2.5); // Exemplo de taxa por hora
    }

    public List<Pagamento> getPagamentosByMotorista(String motoristaId) {
        return pagamentoRepository.findByMotoristaId(motoristaId);
    }

    public List<Pagamento> getPagamentosByVeiculo(String veiculoId) {
        return pagamentoRepository.findByVeiculoId(veiculoId);
    }
}