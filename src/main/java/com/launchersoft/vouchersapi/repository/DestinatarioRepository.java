package com.launchersoft.vouchersapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.launchersoft.vouchersapi.model.Destinatario;
@Repository
public interface DestinatarioRepository extends MongoRepository<Destinatario, String> {

    
}

