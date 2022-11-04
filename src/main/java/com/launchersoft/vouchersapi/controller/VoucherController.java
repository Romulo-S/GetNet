package com.launchersoft.vouchersapi.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.launchersoft.vouchersapi.service.VoucherService;

/**
 * The controller class for @Voucher
 */
@RestController
@RequestMapping(path = "/api/v1/voucher", produces = APPLICATION_JSON_VALUE)
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    /**
     * Receive an OfertaEspecial Id and generates a Voucher for each Destinatario .
     */
    @PostMapping("{id}")
    public void generateVoucher(@PathVariable String id) {
        voucherService.generateVoucher(id);
    }

    /**
     * Receive a Voucher Id and mark it as used.
     */
    @PostMapping("{id}/utilizar")
    public double useVoucher(@PathVariable String id) {
       return voucherService.useVoucher(id);
    }



}
