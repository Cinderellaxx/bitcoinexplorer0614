package com.example.bitcoinexplorer0614.controller;

import com.example.bitcoinexplorer0614.dao.TransactionDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @RequestMapping("/getMoneyDetail")
    public Double getMoneyDetail(@RequestParam String address){
        Double moneyDetail = transactionDetailMapper.getMoneyDetail(address);
        return moneyDetail;
    }
}
