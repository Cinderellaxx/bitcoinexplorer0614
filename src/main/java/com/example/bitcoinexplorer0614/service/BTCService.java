package com.example.bitcoinexplorer0614.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BTCService {
    void sysnBlock(String blockHash) throws Throwable;

    void syncTx(JSONObject txJson, String blockHash, Date time, Integer confirmations) throws Throwable;

    void txDetail(JSONObject txJson,String txid) throws Throwable;

    void txDetailVout(JSONArray vout,String txid);

    void txDetailVin(JSONArray vin,String txid) throws Throwable;
}
