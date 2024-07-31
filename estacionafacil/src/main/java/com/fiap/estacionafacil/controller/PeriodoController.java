package com.fiap.estacionafacil.controller;

import com.fiap.estacionafacil.model.Periodo;
import com.fiap.estacionafacil.service.PeriodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/periodos")
@Api(value = "Gerenciador de Periodo", description = "Operações para gerenciar o periodo do estacionamento")
public class PeriodoController {

    //- O sistema permite iniciar o período de estacionamento, oferecendo opções de tempo fixo ou por hora.
//- Para períodos fixos, o sistema requer que o condutor indique a duração desejada no momento do registro.
//- Para períodos variáveis, o sistema inicia o tempo de estacionamento automaticamente.
//            - O sistema monitora o tempo com precisão para garantir a cobrança correta.

    @Autowired
    PeriodoService service;

    @ApiOperation(value = "Iniciar um novo periodo")
    @PostMapping("/iniciar")
    public Periodo iniciarPeriodo(@RequestBody Periodo periodo) throws Exception {
        return service.criarPagamento(periodo);
    }

    @ApiOperation(value = "Completar um periodo de estacionamento")
    @PostMapping("/encerrar")
    public Periodo encerrarPeriodo(@RequestBody Periodo periodo) throws Exception {
        return service.encerrarPeriodo(periodo);
    }

    @ApiOperation(value = "Consultar um periodo de estacionamento")
    @GetMapping("/consultar")
    public Periodo consultarPeriodo(@PathVariable String veiculoId) throws Exception {
        return service.consultarPeriodo(veiculoId);
    }
}