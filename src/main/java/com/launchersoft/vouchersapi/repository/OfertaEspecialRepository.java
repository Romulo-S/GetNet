package com.launchersoft.vouchersapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.launchersoft.vouchersapi.model.OfertaEspecial;

@Repository
public interface OfertaEspecialRepository extends MongoRepository<OfertaEspecial, String> {

}
