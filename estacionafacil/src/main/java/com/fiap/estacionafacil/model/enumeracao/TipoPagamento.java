package com.fiap.estacionafacil.model.enumeracao;

import io.swagger.annotations.ApiModelProperty;

public enum TipoPagamento {
    @ApiModelProperty(notes = "Cartão de Crédito")
    CREDIT_CARD,

    @ApiModelProperty(notes = "Cartão de Débito")
    DEBIT_CARD,

    @ApiModelProperty(notes = "PIX")
    PIX
}
