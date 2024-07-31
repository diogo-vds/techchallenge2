package com.fiap.estacionafacil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "periodos")
@Data
@ApiModel(description = "Detalhes sobre o Periodo e seu calculo")
public class Periodo {
    @Id
    @ApiModelProperty(notes = "O ID exclusivo do Periodo")
    private String id;

    @ApiModelProperty(notes = "Data Inicio para o calculo do pagamento")
    private LocalDateTime dataInicio;

    @ApiModelProperty(notes = "Data Fim para o calculo do pagamento")
    private LocalDateTime dataFim;

    @ApiModelProperty(notes = "Flag de encerrado ou não")
    private boolean encerrado;

    @ApiModelProperty(notes = "Flag de periodo fixo ou não")
    private boolean periodoFixo;

    @ApiModelProperty(notes = "Nome do motorista do estacionamento")
    private String nomeMotorista;

    @ApiModelProperty(notes = "Placa do veiculo")
    private String placaVeiculo;

    @ApiModelProperty(notes = "Valor do pagamento")
    private BigDecimal valorHora;

    @ApiModelProperty(notes = "Quantidade de horas")
    private BigDecimal qtdHoras;
}
