package com.example.bitcoinexplorer0614.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BTCService {
    void sysnBlock(String blockHash);

    void syncTx(JSONObject txJson, String blockHash, Date time, Integer confirmations);
}
