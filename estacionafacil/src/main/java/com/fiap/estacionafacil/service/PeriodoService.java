package com.fiap.estacionafacil.service;

import com.fiap.estacionafacil.model.Motorista;
import com.fiap.estacionafacil.model.Periodo;
import com.fiap.estacionafacil.repository.MotoristaRepository;
import com.fiap.estacionafacil.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class PeriodoService {

    @Autowired
    PeriodoRepository periodoRepository;

    @Autowired
    MotoristaRepository motoristaRepository;

    public Periodo criarPagamento(Periodo periodo) throws Exception {
        Periodo periodoRecuperado = periodoRepository
                .findByPlacaVeiculoAndEncerrado(periodo.getPlacaVeiculo(), false);

        if(Objects.isNull(periodoRecuperado)){
            throw new Exception("Nenhum período em aberto encontrado para o período");
        }

        return periodoRepository.save(periodo);
    }

    public Periodo encerrarPeriodo(Periodo periodoEntrada) throws Exception {
        Periodo periodoRecuperado = periodoRepository
                .findByPlacaVeiculoAndEncerrado(periodoEntrada.getPlacaVeiculo(), false);

        if(Objects.isNull(periodoRecuperado)){
            throw new Exception("Nenhum período em aberto encontrado para o período");
        }

        if(Objects.isNull(periodoRecuperado.getDataFim())) {
            periodoRecuperado.setDataFim(LocalDateTime.now());
        }
        periodoRecuperado.setEncerrado(true);

        return periodoRecuperado;
    }

    public Periodo consultarPeriodo(String idVeiculo) throws Exception {
        Periodo periodoRecuperado = periodoRepository
                .findByPlacaVeiculoAndEncerrado(idVeiculo, false);

        if(Objects.isNull(periodoRecuperado)){
            throw new Exception("Nenhum período em aberto encontrado para o período");
        }

        return periodoRecuperado;
    }

    @Scheduled(cron = "*/60 * * * * *")
    public void emitirAlertas(){

        System.out.println("Iniciando alertas para encerramento na hora: " + LocalDateTime.now().getHour() +":"+LocalDateTime.now().getMinute());

        List<Periodo> periodosEncerrando = periodoRepository.findByDataFim(LocalDateTime.now().plusMinutes(5));
        if(Objects.nonNull(periodosEncerrando)){
            periodosEncerrando.forEach(periodo -> {
                Motorista motorista = motoristaRepository.findByNome(periodo.getNomeMotorista());
                System.out.println("Prezado " + motorista.getNome() + ",\n o período de " +
                        "estacionamento se encerra em 5 minutos.");
            });
        }
        List<Periodo> periodosAbertos = periodoRepository.findByEncerradoAndPeriodoFixo(false, false);
        if(Objects.nonNull(periodosAbertos)){
            periodosAbertos.forEach(periodo -> {
                if(periodo.getDataInicio().getMinute() == LocalDateTime.now().plusMinutes(5).getMinute()){
                    Motorista motorista = motoristaRepository.findByNome(periodo.getNomeMotorista());
                    System.out.println("Prezado " + motorista.getNome() + ",\n  sistema estenderá\n" +
                            " automaticamente o estacionamento por mais uma hora, " +
                            "a menos que o condutor desligue o registro.");
                }
            });
        }
        System.out.println("Finalizando alertas para encerramento na hora: " + LocalDateTime.now().getHour() +":"+LocalDateTime.now().getMinute());
    }
}