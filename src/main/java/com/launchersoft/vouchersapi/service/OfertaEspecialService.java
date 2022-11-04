package com.launchersoft.vouchersapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchersoft.vouchersapi.dto.OfertaEspecialDTO;
import com.launchersoft.vouchersapi.model.OfertaEspecial;
import com.launchersoft.vouchersapi.repository.OfertaEspecialRepository;

/**
 * OfertaEspecialService
 */
@Service
public class OfertaEspecialService {

    @Autowired
    private OfertaEspecialRepository ofertaEspecialRepository;

    /**
     * Create a oferta especial.
     */
    public OfertaEspecialDTO save(OfertaEspecialDTO ofertaEspecialDTO) {
        OfertaEspecial ofertaEspecial = OfertaEspecial.builder()
                .nome(ofertaEspecialDTO.getNome())
                .descricao(ofertaEspecialDTO.getDescricao())
                .dataValidade(ofertaEspecialDTO.getDataValidade())
                .percentage(ofertaEspecialDTO.getDesconto_percentual())
                .build();
        ofertaEspecialRepository.save(ofertaEspecial);

        return ofertaEspecialDTO;
    }
}
