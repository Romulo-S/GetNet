package com.launchersoft.vouchersapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DestinatarioDTO {

    private String nome;
    private String email;

}
