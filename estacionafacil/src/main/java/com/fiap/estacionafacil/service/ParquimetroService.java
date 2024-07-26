package com.fiap.estacionafacil.service;

import com.fiap.estacionafacil.model.MetodoPagamento;
import com.fiap.estacionafacil.model.Motorista;
import com.fiap.estacionafacil.model.Veiculo;
import com.fiap.estacionafacil.repository.MetodoPagamentoRepository;
import com.fiap.estacionafacil.repository.MotoristaRepository;
import com.fiap.estacionafacil.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ParquimetroService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;

    public Motorista saveMotorista(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    public Veiculo saveVeiculo(String motoristaId, Veiculo veiculo) {
        Motorista motorista = motoristaRepository.findById(motoristaId).orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        motorista.getVeiculos().add(veiculo);
        veiculoRepository.save(veiculo);
        motoristaRepository.save(motorista);
        return veiculo;
    }

    public MetodoPagamento saveMetodoPagamento(String MotoristaId, MetodoPagamento metodoPagamento) {
        Motorista motorista = motoristaRepository.findById(MotoristaId).orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        motorista.getMetodosPagamento().add(metodoPagamento);
        metodoPagamentoRepository.save(metodoPagamento);
        motoristaRepository.save(motorista);
        return metodoPagamento;
    }

    public List<Motorista> getAllMotoristas() {
        return motoristaRepository.findAll();
    }

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public List<MetodoPagamento> getAllMetodoPagamentos() {
        return metodoPagamentoRepository.findAll();
    }
}
