package com.fiap.estacionafacil.controller;

import com.fiap.estacionafacil.model.MetodoPagamento;
import com.fiap.estacionafacil.model.Motorista;
import com.fiap.estacionafacil.model.Veiculo;
import com.fiap.estacionafacil.service.ParquimetroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Estaciona Fácil", description = "Operações para gerenciar o sistema de parquímetro")
public class ParquimetroController {

    @Autowired
    private ParquimetroService parquimetroService;

    @PostMapping("/motoristas")
    @ApiOperation(value = "Registrar um novo condutor", response = Motorista.class)
    public Motorista saveMotorista(
            @ApiParam(value = "Detalhes do novo condutor", required = true) @RequestBody Motorista motorista) {
        return parquimetroService.saveMotorista(motorista);
    }

    @ApiOperation(value = "Registrar um novo veículo para um condutor", response = Veiculo.class)
    @PostMapping("/motoristas/{motoristaId}/veiculos")
    public Veiculo saveVeiculo(
            @ApiParam(value = "ID do condutor", required = true) @PathVariable String motoristaId,
            @ApiParam(value = "Detalhes do novo veículo", required = true) @RequestBody Veiculo veiculo) {
        return parquimetroService.saveVeiculo(motoristaId, veiculo);
    }

    @ApiOperation(value = "Registrar um novo método de pagamento para um condutor", response = MetodoPagamento.class)
    @PostMapping("/motoristas/{motoristaId}/pagamento-metodos")
    public MetodoPagamento saveMetodoPagamento(
            @ApiParam(value = "ID do condutor", required = true) @PathVariable String motoristaId,
            @ApiParam(value = "Detalhes do novo método de pagamento", required = true) @RequestBody MetodoPagamento metodoPagamento) {
        return parquimetroService.saveMetodoPagamento(motoristaId, metodoPagamento);
    }

    @GetMapping("/motoristas")
    @ApiOperation(value = "Listar todos os condutores", response = List.class)
    public List<Motorista> getAllMotoristas() {
        return parquimetroService.getAllMotoristas();
    }

    @GetMapping("/veiculos")
    @ApiOperation(value = "Listar todos os veiculos", response = List.class)
    public List<Veiculo> getAllVeiculos() {
        return parquimetroService.getAllVeiculos();
    }

    @GetMapping("/metodos-pagamento")
    @ApiOperation(value = "Listar todos os metodos de pagamento", response = List.class)
    public List<MetodoPagamento> getAllMetodoPagamentos() {
        return parquimetroService.getAllMetodoPagamentos();
    }
}
