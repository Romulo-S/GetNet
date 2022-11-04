package com.launchersoft.vouchersapi.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.launchersoft.vouchersapi.dto.DestinatarioDTO;
import com.launchersoft.vouchersapi.model.Destinatario;
import com.launchersoft.vouchersapi.service.DestinatarioService;

/**
 * The controller class for @Destinatario
 */
@RestController
@RequestMapping(path = "/api/v1/destinatario", produces = APPLICATION_JSON_VALUE)
public class DestinatarioController {

    @Autowired
    private DestinatarioService destinatarioService;

    /**
     * Create destinatario.
     */
    @PostMapping
    public DestinatarioDTO createDestinatario(@RequestBody DestinatarioDTO destinatarioDTO) {
        return destinatarioService.save(destinatarioDTO);
    }

    /**
     * Delete destinatario.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> createDestinatario(@PathVariable String id) {
        //Gets the destinatario by id and delete it
        Destinatario destinatario = destinatarioService.getDestinatarioById(id);

         destinatarioService.delete(destinatario);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
