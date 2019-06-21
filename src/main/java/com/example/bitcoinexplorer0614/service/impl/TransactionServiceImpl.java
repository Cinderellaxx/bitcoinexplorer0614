package com.example.bitcoinexplorer0614.service.impl;

import com.example.bitcoinexplorer0614.dao.TransactionMapper;
import com.example.bitcoinexplorer0614.dto.TransactionListDto;
import com.example.bitcoinexplorer0614.po.Transaction;
import com.example.bitcoinexplorer0614.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public List<TransactionListDto> getTranList() {
        ArrayList<TransactionListDto> tList = new ArrayList<>();
        List<Transaction> tranList = transactionMapper.getTranList1();
        for (Transaction t : tranList) {
            TransactionListDto tListDto = new TransactionListDto();
            tListDto.setTxhash(t.getTxhash());
            tListDto.setTime(t.getTime().getTime());
            tListDto.setAmount(t.getAmount());
            tList.add(tListDto);
        }
        return tList;
    }
}
