package com.fiap.estacionafacil.service;

import com.fiap.estacionafacil.model.Alerta;
import com.fiap.estacionafacil.model.Pagamento;
import com.fiap.estacionafacil.repository.AlertaRepository;
import com.fiap.estacionafacil.repository.PagamentoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Alerta criarAlerta(String pagamentoId, String motoristaId, String mensagem, LocalDateTime dataAlerta) {
        Alerta alerta = new Alerta();
        alerta.setPagamentoId(pagamentoId);
        alerta.setMotoristaId(motoristaId);
        alerta.setMensagem(mensagem);
        alerta.setDataAlerta(dataAlerta);
        alerta.setResolvido(false);
        return alertaRepository.save(alerta);
    }

    public List<Alerta> getAlertasByMotorista(String motoristaId) {
        return alertaRepository.findByMotoristaId(motoristaId);
    }

    public List<Alerta> getAlertasByPagamento(String pagamentoId) {
        return alertaRepository.findByPagamentoId(pagamentoId);
    }

    public Alerta resolverAlerta(String alertaId) {
        Alerta alerta = alertaRepository
                .findById(alertaId)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
        alerta.setResolvido(true);
        return alertaRepository.save(alerta);
    }

    // Scheduled task para checar e criar alertaas
    @Scheduled(fixedRate = 60000) // a cada minuto
    public void checkForAlertas() {
        List<Pagamento> pagamentosAtivos = pagamentoRepository.findByAtivoTrue();
        LocalDateTime now = LocalDateTime.now();

        for (Pagamento pagamento : pagamentosAtivos) {
            if (!pagamento.isTaxaFixa() && pagamento.getDataFim() == null) {
                long hoursDecorrida = Duration.between(pagamento.getDataInicio(), now).toHours();
                if (hoursDecorrida >= 1 && (hoursDecorrida % 1 == 0)) {
                    criarAlerta(pagamento.getId(), pagamento.getMotoristaId(), "Seu estacionamento será adicionado mais uma hora!", now);
                }
            } else if (pagamento.isTaxaFixa() && pagamento.getDataFim().isAfter(now.minusMinutes(5))) {
                criarAlerta(pagamento.getId(), pagamento.getMotoristaId(), "Seu tempo de estacionamento está chegando ao limite!", now);
            }
        }
    }
}
