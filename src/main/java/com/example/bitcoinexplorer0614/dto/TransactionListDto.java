package com.example.bitcoinexplorer0614.dto;

import java.util.Date;

public class TransactionListDto {
    private String txhash;

    private Long time;

    private Double amount;



    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
