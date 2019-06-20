package com.example.bitcoinexplorer0614.controller;

import com.example.bitcoinexplorer0614.dao.TransactionMapper;
import com.example.bitcoinexplorer0614.dto.TransactionListDto;
import com.example.bitcoinexplorer0614.po.Transaction;
import com.example.bitcoinexplorer0614.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private TransactionService transactionService;
    @GetMapping("/getTranList")
    public List<TransactionListDto> getTranList(){
        List<TransactionListDto> tranList = transactionService.getTranList();
        return tranList;
    }
}
