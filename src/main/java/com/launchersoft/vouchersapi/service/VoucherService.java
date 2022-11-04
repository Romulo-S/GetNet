package com.launchersoft.vouchersapi.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchersoft.vouchersapi.dto.OfertaEspecialDTO;
import com.launchersoft.vouchersapi.dto.VoucherDTO;
import com.launchersoft.vouchersapi.model.Destinatario;
import com.launchersoft.vouchersapi.model.OfertaEspecial;
import com.launchersoft.vouchersapi.model.Voucher;
import com.launchersoft.vouchersapi.repository.DestinatarioRepository;
import com.launchersoft.vouchersapi.repository.OfertaEspecialRepository;
import com.launchersoft.vouchersapi.repository.VoucherRepository;

@Service
public class VoucherService {

    @Autowired
    private OfertaEspecialRepository ofertaEspecialRepository;

    @Autowired
    private DestinatarioRepository destinatarioRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    /**
     * Generate a Voucher for each destinatario.
     */
    public void generateVoucher(String id) {

        //Get the oferta especial by id and check if it exists in the database. If it does not exist, throw an exception.
        OfertaEspecial ofertaEspecial = ofertaEspecialRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Oferta especial not found"));


        //Gets all the destinatarios.
        List<Destinatario> destinatarios = destinatarioRepository.findAll();

        //Iterate over the destinatarios and create a voucher for each one.
        for (Destinatario destinatario : destinatarios) {
            Voucher voucher = Voucher.builder()
                .codigoUnico(UUID.randomUUID().toString().substring(0, 8))
                .dataCriacao(LocalDate.now())
                .dataUtilizacao(null)
                .destinatario(destinatario)
                .ofertaEspecial(ofertaEspecial)
                .utilizado(false)
                .build();

            voucherRepository.save(voucher);
        }
    }

    /**
     * Mark a voucher as used.
     */
    public double useVoucher(String id) {
        Voucher voucher = voucherRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Voucher not found"));

        //Check if the voucher has already been used.
        if (voucher.isUtilizado()) {
            throw new RuntimeException("Voucher already used");
        }

        //Check if the voucher has expired.
        if (voucher.getOfertaEspecial().getDataValidade().isBefore(LocalDate.now())) {
            throw new RuntimeException("Voucher expired");
        }

        voucher.setDataUtilizacao(LocalDate.now());
        voucher.setUtilizado(true);

        voucherRepository.save(voucher);

        return voucher.getOfertaEspecial().getPercentage();
    }

    /**
     * Get all vouchers.
     */
    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    /**
     * Get all vouchers by destinatario.
     */
    public List<Voucher> getAllVouchersByDestinatario(String id) {
        Destinatario destinatario = destinatarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Destinatario not found"));

        return voucherRepository.findByDestinatario(destinatario);
    }

    /**
     * Get all vouchers by oferta especial.
     */
    public List<Voucher> getAllVouchersByOfertaEspecial(String id) {
        OfertaEspecial ofertaEspecial = ofertaEspecialRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Oferta especial not found"));

        return voucherRepository.findByOfertaEspecial(ofertaEspecial);
    }

    /**
     * Get all vouchers by destinatario and oferta especial.
     */
    public List<Voucher> getAllVouchersByDestinatarioAndOfertaEspecial(String idDestinatario, String idOfertaEspecial) {
        Destinatario destinatario = destinatarioRepository.findById(idDestinatario)
            .orElseThrow(() -> new RuntimeException("Destinatario not found"));

        OfertaEspecial ofertaEspecial = ofertaEspecialRepository.findById(idOfertaEspecial)
            .orElseThrow(() -> new RuntimeException("Oferta especial not found"));

        return voucherRepository.findByDestinatarioAndOfertaEspecial(destinatario, ofertaEspecial);
    }


}
