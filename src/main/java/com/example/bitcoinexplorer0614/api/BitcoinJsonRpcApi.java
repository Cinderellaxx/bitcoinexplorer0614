package com.example.bitcoinexplorer0614.api;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {
    JSONObject getblockchaininfo() throws Throwable;
}
