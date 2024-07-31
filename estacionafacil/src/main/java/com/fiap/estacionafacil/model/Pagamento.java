package com.fiap.estacionafacil.model;

import com.fiap.estacionafacil.model.enumeracao.TipoPagamento;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "pagamentos")
@Data
@ApiModel(description = "Detalhes sobre o pagamento")
public class Pagamento {
    @Id
    @ApiModelProperty(notes = "O ID exclusivo do pagamento")
    private String id;

    @ApiModelProperty(notes = "O ID do motorista do pagamento")
    private String motoristaId;

    @ApiModelProperty(notes = "O ID do veiculo do motorista do pagamento")
    private String veiculoId;

    @ApiModelProperty(notes = "Tipo de pagamento escolhido")
    private TipoPagamento metodoPagamento;

    @ApiModelProperty(notes = "Data Inicio para o calculo do pagamento")
    private LocalDateTime dataInicio;

    @ApiModelProperty(notes = "Data Fim para o calculo do pagamento")
    private LocalDateTime dataFim;

    @ApiModelProperty(notes = "Valor a pagar")
    private BigDecimal quantia;

    @ApiModelProperty(notes = "Flag de taxa fixa ou não")
    private boolean taxaFixa;

    @ApiModelProperty(notes = "Recibo do pagamento")
    private String recibo;

    @ApiModelProperty(notes = "Flag de saber se está ativo e filtrar na hora do alerta")
    private boolean ativo;

    @ApiModelProperty(notes = "Duração em minutos")
    private long duracaoMinutos;

}
