package com.launchersoft.vouchersapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

//The @Document for Destinatario
@Document(collection = "destinatarios")
@Data
@Builder
public class Destinatario {

    @Id
    private String id;
    private String nome;
    private String email;

}
