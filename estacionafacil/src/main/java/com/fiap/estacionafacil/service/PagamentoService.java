package com.fiap.estacionafacil.service;

import com.fiap.estacionafacil.model.Motorista;
import com.fiap.estacionafacil.model.Pagamento;
import com.fiap.estacionafacil.model.enumeracao.TipoPagamento;
import com.fiap.estacionafacil.repository.MotoristaRepository;
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

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Pagamento criarPagamento(String motoristaId, String veiculoId, TipoPagamento pagamentoMethod, LocalDateTime startTime, boolean taxaFixa) {
        Motorista motorista = motoristaRepository.findById(motoristaId).orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        if (pagamentoMethod == TipoPagamento.PIX) {
            throw new IllegalArgumentException("PIX só disponível para períodos fixos!");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setMotoristaId(motoristaId);
        pagamento.setVeiculoId(veiculoId);
        pagamento.setMetodoPagamento(pagamentoMethod);
        pagamento.setDataInicio(startTime);
        pagamento.setTaxaFixa(taxaFixa);
        pagamento.setAtivo(true);

        if (taxaFixa) {
            pagamento.setQuantia(calcularTaxaFixa());
        } else {
            pagamento.setQuantia(new BigDecimal(0)); // Valor inicial da quantia
        }

        return pagamentoRepository.save(pagamento);
    }

    public Pagamento completarPagamento(String pagamentoId, LocalDateTime dataFim) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoId).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
        pagamento.setDataFim(dataFim);
        pagamento.setAtivo(false);
        pagamento.setDuracaoMinutos(calcularDuracao(pagamento));
        pagamento.setRecibo(gerarRecibo(pagamento));

        if (!pagamento.isTaxaFixa()) {
            pagamento.setQuantia(calcularTaxaVariavel(pagamento.getDataInicio(), pagamento.getDataFim()));
        }

        return pagamentoRepository.save(pagamento);
    }

    private long calcularDuracao(Pagamento pagamento) {
        return Duration.between(pagamento.getDataInicio(), pagamento.getDataFim()).toMinutes();
    }

    private String gerarRecibo(Pagamento pagamento) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Motorista ID: ").append(pagamento.getMotoristaId()).append("\n");
        receipt.append("Inicio: ").append(pagamento.getDataInicio()).append("\n");
        receipt.append("Fim: ").append(pagamento.getDataFim()).append("\n");
        receipt.append("Duração: ").append(pagamento.getDuracaoMinutos()).append(" minutes\n");
        receipt.append("Método Pagamento: ").append(pagamento.getMetodoPagamento()).append("\n");
        receipt.append("Total: ").append(pagamento.getQuantia()).append("\n");
        return receipt.toString();
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