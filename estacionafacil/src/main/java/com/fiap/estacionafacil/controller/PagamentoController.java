package com.fiap.estacionafacil.controller;

import com.fiap.estacionafacil.model.Pagamento;
import com.fiap.estacionafacil.model.enumeracao.TipoPagamento;
import com.fiap.estacionafacil.service.PagamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@Api(value = "Gerenciador de Pagamento", description = "Operações para gerenciar o pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @ApiOperation(value = "Iniciar um novo pagamento")
    @PostMapping("/iniciar")
    public Pagamento iniciarPagamento(@RequestParam String motoristaId,
                                    @RequestParam String veiculoId,
                                    @RequestParam TipoPagamento tipoPagamento,
                                    @RequestParam boolean taxaFixa) {
        LocalDateTime dataInicio = LocalDateTime.now();
        return pagamentoService.criarPagamento(motoristaId, veiculoId, tipoPagamento, dataInicio, taxaFixa);
    }

    @ApiOperation(value = "Completar um pagamento existente")
    @PostMapping("/completar")
    public Pagamento completarPagamento(@RequestParam String pagamentoId) {
        LocalDateTime endTime = LocalDateTime.now();
        return pagamentoService.completarPagamento(pagamentoId, endTime);
    }

    @ApiOperation(value = "Get pagamentos by motorista ID")
    @GetMapping("/motorista/{motoristaId}")
    public List<Pagamento> getPagamentosByMotorista(@PathVariable String motoristaId) {
        return pagamentoService.getPagamentosByMotorista(motoristaId);
    }

    @ApiOperation(value = "Get pagamentos by veiculo ID")
    @GetMapping("/veiculo/{veiculoId}")
    public List<Pagamento> getPagamentosByVeiculo(@PathVariable String veiculoId) {
        return pagamentoService.getPagamentosByVeiculo(veiculoId);
    }
}