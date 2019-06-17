package com.example.bitcoinexplorer0614.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.bitcoinexplorer0614.api.BitcoinJsonRpcApi;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
@Component
public class BitcoinJsonRpcApiImpl implements BitcoinJsonRpcApi {
    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoinJsonRpcApiImpl() throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s","xxx","123456");
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL("http://localhost:18332"),headers);
    }
@Override
    public JSONObject getblockchaininfo() throws Throwable {
        JSONObject getblockchaininfo = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return getblockchaininfo;
    }
}
