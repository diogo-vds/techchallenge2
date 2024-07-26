package com.fiap.estacionafacil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "veiculos")
@Data
@ApiModel(description = "Detalhes sobre o veículo")
public class Veiculo {

    @Id
    @ApiModelProperty(notes = "O ID exclusivo do veículo")
    private String id;

    @ApiModelProperty(notes = "A placa do veículo")
    private String placa;

    @ApiModelProperty(notes = "O modelo do veículo")
    private String modelo;

    @ApiModelProperty(notes = "A cor do veículo")
    private String cor;
}
