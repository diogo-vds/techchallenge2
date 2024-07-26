package com.fiap.estacionafacil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "motoristas")
@Data
@ApiModel(description = "Detalhes sobre o condutor")
public class Motorista {
    @Id
    @ApiModelProperty(notes = "O ID exclusivo do condutor")
    private String id;

    @ApiModelProperty(notes = "O nome do condutor")
    private String nome;

    @ApiModelProperty(notes = "O endereço do condutor")
    private String endereco;

    @ApiModelProperty(notes = "Informações de contato do condutor")
    private String contato;

    @ApiModelProperty(notes = "Lista de veículos associados ao condutor")
    private List<Veiculo> veiculos;

    @ApiModelProperty(notes = "Lista de métodos de pagamento associados ao condutor")
    private List<MetodoPagamento> metodosPagamento;
}
