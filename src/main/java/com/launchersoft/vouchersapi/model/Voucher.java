package com.launchersoft.vouchersapi.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

/**
 * @Document for Voucher
 * @author romulo.domingos
 */
@Document
@Data
@Builder
public class Voucher {

    @Id
    private String id;
    private Destinatario destinatario;
    private OfertaEspecial ofertaEspecial;
    private String codigoVoucher;
    private String codigoUnico;
    private boolean utilizado;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataUtilizacao;


}
