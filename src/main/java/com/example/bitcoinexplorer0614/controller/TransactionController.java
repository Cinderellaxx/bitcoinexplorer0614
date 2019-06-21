package com.example.bitcoinexplorer0614.controller;

import com.example.bitcoinexplorer0614.dao.TransactionMapper;
import com.example.bitcoinexplorer0614.dto.TransactionListDto;
import com.example.bitcoinexplorer0614.po.Transaction;
import com.example.bitcoinexplorer0614.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getByTxHash")
    public Transaction getByTxHash(@RequestParam String txhash){
        Transaction byTxHash = transactionMapper.selectByPrimaryKey(txhash);
        return byTxHash;
    }
}
