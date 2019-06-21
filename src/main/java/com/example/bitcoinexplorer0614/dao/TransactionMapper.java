package com.example.bitcoinexplorer0614.dao;

import com.example.bitcoinexplorer0614.dto.TransactionListDto;
import com.example.bitcoinexplorer0614.po.Transaction;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);


    List<Transaction> getTranList1();
}