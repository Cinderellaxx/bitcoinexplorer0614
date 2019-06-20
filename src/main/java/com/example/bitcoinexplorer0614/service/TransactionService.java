package com.example.bitcoinexplorer0614.service;

import com.example.bitcoinexplorer0614.dto.TransactionListDto;

import java.util.List;

public interface TransactionService {
    List<TransactionListDto> getTranList();
}
