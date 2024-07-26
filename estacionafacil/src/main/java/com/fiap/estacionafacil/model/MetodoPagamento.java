package com.fiap.estacionafacil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fiap.estacionafacil.model.enumeracao.*;

@Document(collection = "metodos_pagamentos")
@ApiModel(description = "Detalhes sobre o método de pagamento")
@Data
public class MetodoPagamento {
    @Id
    @ApiModelProperty(notes = "O ID exclusivo do método de pagamento")
    private String id;

    @ApiModelProperty(notes = "O tipo de pagamento")
    private TipoPagamento tipo;

    @ApiModelProperty(notes = "Os detalhes do método de pagamento, como número do cartão ou chave PIX")
    private String detalhes;

    @ApiModelProperty(notes = "Indica se o PIX está disponível para períodos de estacionamento fixos")
    private boolean pixDisponivelPeriodosFixos;
}
