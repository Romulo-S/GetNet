package com.launchersoft.vouchersapi.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.launchersoft.vouchersapi.dto.OfertaEspecialDTO;
import com.launchersoft.vouchersapi.service.OfertaEspecialService;

/**
 * The @Controller for OfertaEspecialRepository
 */
@RestController
@RequestMapping(path = "/api/v1/oferta_especial", produces = APPLICATION_JSON_VALUE)
public class OfertaEspecialController {

    @Autowired
    private OfertaEspecialService ofertaEspecialService;

    /**
     * Create @OfertaEspecial.
     */
    @PostMapping
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OfertaEspecialDTO createOfertaEspecial(@RequestBody OfertaEspecialDTO ofertaEspecialDTO) {
        return ofertaEspecialService.save(ofertaEspecialDTO);
    }
}
