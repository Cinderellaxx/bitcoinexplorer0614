package com.example.bitcoinexplorer0614.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bitcoinexplorer0614.api.BitcoinJsonRpcApi;
import com.example.bitcoinexplorer0614.api.BitcoinRestApi;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @GetMapping("/test")
    public String test(){
        JSONObject blockChainInfo = bitcoinRestApi.getChainInfo();
        return blockChainInfo.toJSONString();
    }
    @GetMapping("/test1")
    public String test1(){
        JSONObject blockByHashJson = bitcoinRestApi.getBlockByHashJson("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943");
        return blockByHashJson.toJSONString();
    }
    @GetMapping("/test2")
    public String test2(){
        JSONObject blockNoTxDetail = bitcoinRestApi.getBlockNoTxDetail("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943");
        return  blockNoTxDetail.toJSONString();
    }

   @GetMapping("/test3")
    public JSONArray test3(){
        JSONArray blockHeaders = bitcoinRestApi.getBlockHeaders(5,"0000000000169a671787ee8b694e53f69be7a92fa004961126059d2cd63c739e");
        return blockHeaders;
    }

   @GetMapping("/test4")
    public String test4(){
       JSONObject tx = bitcoinRestApi.getTx("b3e3977a45707e5238819f4bd3bee4405a621b40ff15c7320a0d9387e58bdd94");
       return tx.toJSONString();
   }

   @GetMapping("/test5")
    public String test5(){
       JSONObject blockHashByHeight = bitcoinRestApi.getBlockHashByHeight(1255925);
       return blockHashByHeight.toJSONString();
   }

   @GetMapping("/test6")
    public String  test6(){
       JSONObject memoryPool = bitcoinRestApi.getMemoryPool();
       return memoryPool.toJSONString();
   }

   @GetMapping("/test7")
    public String test7(){
       JSONObject memoryPoolContents = bitcoinRestApi.getMemoryPoolContents();
       return memoryPoolContents.toJSONString();

   }

    @GetMapping("/test8")
    public String test8() throws Throwable {

        JSONObject getblockchaininfo = bitcoinJsonRpcApi.getblockchaininfo();
        return null;

    }
    @GetMapping("/test9")
    public String test9() throws Throwable {
        JSONObject blockByHash = bitcoinJsonRpcApi.getBlockByHash("00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09");
        return null;

    }
    @GetMapping("/test10")
    public String test10() throws Throwable {
        JSONObject txByHash = bitcoinJsonRpcApi.getTxByHash("500f82b327426b9559bbc2054067025ba482afea8cc69b21799db36b77b52745");
        return null;

    }

    @GetMapping("/test11")
    public String test11(){
        JSONObject utxo = bitcoinRestApi.getUTXO("4ab6da982a4f4dc501114492dec7fd96e87094ae37328a77c607caec875eb67d", 0);
        return utxo.toJSONString();

    }

    @GetMapping("/test12")
    public String test12(){
        JSONObject utxoCheckmempool = bitcoinRestApi.getUTXOCheckmempool("4ab6da982a4f4dc501114492dec7fd96e87094ae37328a77c607caec875eb67d", 0);
        return utxoCheckmempool.toJSONString();
    }
}
