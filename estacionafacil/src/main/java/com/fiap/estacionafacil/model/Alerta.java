package com.fiap.estacionafacil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "alertas")
@ApiModel(description = "Detalhes sobre o alerta de estacionamento")
@Data
public class Alerta {
    @Id
    @ApiModelProperty(notes = "O ID exclusivo do Alerta")
    private String id;
    private String pagamentoId;
    private String motoristaId;
    private LocalDateTime dataAlerta;
    private String mensagem;
    private boolean resolvido;
}
