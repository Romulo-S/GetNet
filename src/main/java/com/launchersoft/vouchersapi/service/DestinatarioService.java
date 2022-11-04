package com.launchersoft.vouchersapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchersoft.vouchersapi.dto.DestinatarioDTO;
import com.launchersoft.vouchersapi.exception.ResourceNotFoundException;
import com.launchersoft.vouchersapi.model.Destinatario;
import com.launchersoft.vouchersapi.repository.DestinatarioRepository;

@Service
public class DestinatarioService {

    @Autowired
    private DestinatarioRepository destinatarioRepository;

    /**
     * Save a destinatario.
     */
    public DestinatarioDTO save(DestinatarioDTO destinatarioDTO) {

        Destinatario destinatario = Destinatario.builder()
                .nome(destinatarioDTO.getNome())
                .email(destinatarioDTO.getEmail())
                .build();
        destinatarioRepository.save(destinatario);
        return destinatarioDTO;
    }

    /**
     * Get a destinatario by id.
     */
    public Destinatario getDestinatarioById(String id) {
        return destinatarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destinatario not exist with id: " + id));
    }

    /**
     * Delete a destinatario.
     * @param destinatario
     * @return
     */
    public void delete(Destinatario destinatario) {
        destinatarioRepository.delete(destinatario);
    }
}
