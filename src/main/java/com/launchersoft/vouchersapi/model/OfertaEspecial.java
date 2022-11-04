package com.launchersoft.vouchersapi.model;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Document(collection = "ofertas_especiais")
@Data
@Builder
public class OfertaEspecial {


    private String Id;
    private String nome;
    private double percentage;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;


}
