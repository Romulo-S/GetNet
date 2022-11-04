package com.launchersoft.vouchersapi.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.launchersoft.vouchersapi.model.Destinatario;
import com.launchersoft.vouchersapi.model.OfertaEspecial;

public class VoucherDTO {

    @Id
    private String id;
    private Destinatario destinatario;
    private String nome;
    private String email;
    private OfertaEspecial ofertaEspecial;
    private String codigoVoucher;
    private String codigoUnico;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataUtilizacao;
    private boolean utilizado;
}
