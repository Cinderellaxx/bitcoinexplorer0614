package com.example.bitcoinexplorer0614.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BitcoinRestApi",url = "http://localhost:18332")
public interface BitcoinRestApi {

    @GetMapping("/rest/chaininfo.json")
    JSONObject getChainInfo();


    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getBlockByHashJson(@PathVariable("blockhash") String blockhash);


    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getBlockNoTxDetail(@PathVariable("blockhash") String blockhash);

    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    JSONArray getBlockHeaders(@PathVariable("count")Integer count, @PathVariable("blockhash") String blockhash);

    @GetMapping("/rest/tx/{blockhash}.json")
    JSONObject getTx(@PathVariable("blockhash") String blockhash);

    @GetMapping("/rest/blockhashbyheight/{height}.json")
    JSONObject getBlockHashByHeight(@PathVariable("height") Integer height);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getMemoryPool();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getMemoryPoolContents();
}
