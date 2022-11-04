package com.launchersoft.vouchersapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.launchersoft.vouchersapi.model.Destinatario;
import com.launchersoft.vouchersapi.model.OfertaEspecial;
import com.launchersoft.vouchersapi.model.Voucher;

@Repository
public interface VoucherRepository extends MongoRepository<Voucher, String> {

    List<Voucher> findByDestinatario(Destinatario destinatario);

    List<Voucher> findByOfertaEspecial(OfertaEspecial ofertaEspecial);

    List<Voucher> findByDestinatarioAndOfertaEspecial(Destinatario destinatario, OfertaEspecial ofertaEspecial);
}
