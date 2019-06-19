package com.example.bitcoinexplorer0614.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BTCService {
    void sysnBlock(String blockHash);

    void syncTx(JSONObject txJson, String blockHash, Date time, Integer confirmations);

    void txDetail(JSONObject txJson,String txid);

    void txDetailVout(JSONArray vout,String txid);

    void txDetailVin(JSONArray vin,String txid);
}
