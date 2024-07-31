package com.fiap.estacionafacil.controller;

import com.fiap.estacionafacil.model.Alerta;
import com.fiap.estacionafacil.service.AlertaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/alertas")
@Api(value = "Gerenciador de Alertaas", description = "Operações para alertas do estacionamento")
public class AlertaController {
    
    @Autowired
    private AlertaService alertaService;

    @ApiOperation(value = "Criar novo alerta")
    @PostMapping("/criar")
    public Alerta criarAlerta(@RequestParam String pagamentoId,
                               @RequestParam String motoristaId,
                               @RequestParam String mensagem,
                               @RequestParam LocalDateTime dataAlerta) {
        return alertaService.criarAlerta(pagamentoId, motoristaId, mensagem, dataAlerta);
    }

    @ApiOperation(value = "Get alertas by motorista ID")
    @GetMapping("/motorista/{motoristaId}")
    public List<Alerta> getAlertasByMotorista(@PathVariable String motoristaId) {
        return alertaService.getAlertasByMotorista(motoristaId);
    }

    @ApiOperation(value = "Get alertas by pagamento ID")
    @GetMapping("/pagamento/{pagamentoId}")
    public List<Alerta> getAlertasByPagamento(@PathVariable String pagamentoId) {
        return alertaService.getAlertasByPagamento(pagamentoId);
    }

    @ApiOperation(value = "Resolver um alerta")
    @PostMapping("/resolver")
    public Alerta resolveAlerta(@RequestParam String alertId) {
        return alertaService.resolverAlerta(alertId);
    }
}
