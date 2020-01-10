package com.mohammad.banking.controller;

import com.mohammad.banking.service.ITransferServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banking")
public class BankingServiceController {
    @Autowired
    private ITransferServiceRemote transferServiceRemote;

    @RequestMapping("transfer/{source}/{destination}/{amount}")
    public String transfer(@PathVariable int source, @PathVariable int destination, @PathVariable long amount) {
        transferServiceRemote.transfer(source, destination, amount);
        return "Amount transfered.";
    }
}
