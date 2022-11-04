package com.launchersoft.vouchersapi.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfertaEspecialDTO {

    private String nome;
    private final double desconto_percentual;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataValidade;
}
