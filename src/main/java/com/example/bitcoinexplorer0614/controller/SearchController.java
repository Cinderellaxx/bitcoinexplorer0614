package com.example.bitcoinexplorer0614.controller;

import com.example.bitcoinexplorer0614.dao.BlockMapper;
import com.example.bitcoinexplorer0614.dao.TransactionDetailMapper;
import com.example.bitcoinexplorer0614.dao.TransactionMapper;
import com.example.bitcoinexplorer0614.po.Block;
import com.example.bitcoinexplorer0614.po.Transaction;
import com.example.bitcoinexplorer0614.po.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@EnableAutoConfiguration
@CrossOrigin
public class SearchController {
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @RequestMapping("/searchAll")
    public Object searchAll(@RequestParam String s){

       if(s.length()==64){
            String regular="^[0]{14,}";
            if(s.matches(regular)){
                Block block = blockMapper.selectByPrimaryKey(s);
                return block;
            }else {
                Transaction transaction = transactionMapper.selectByPrimaryKey(s);
                return transaction;

            }
        }else{
           List<TransactionDetail> transactionDetail = transactionDetailMapper.selectAddress(s);
           return transactionDetail;
       }
    }
}
