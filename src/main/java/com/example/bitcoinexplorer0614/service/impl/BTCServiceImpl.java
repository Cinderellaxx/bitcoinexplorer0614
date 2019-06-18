package com.example.bitcoinexplorer0614.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.bitcoinexplorer0614.api.BitcoinRestApi;
import com.example.bitcoinexplorer0614.dao.BlockMapper;
import com.example.bitcoinexplorer0614.po.Block;
import com.example.bitcoinexplorer0614.service.BTCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service

public class BTCServiceImpl implements BTCService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BlockMapper blockMapper;
    @Override
    @Async
    public void sysnBlock(String blockHash) {
        logger.info("sync bitcoin begin to {}",blockHash);
        String temp=blockHash;
        while(temp!=null && !temp.isEmpty()){
            JSONObject blockByHashJson = bitcoinRestApi.getBlockByHashJson(temp);
            Block block =new Block();
            block.setBlockhash(blockByHashJson.getString("hash"));
            block.setHeight(blockByHashJson.getInteger("height"));
            Long time = blockByHashJson.getLong("time");
            block.setTime(new Date(time*1000));
            block.setTxsize(blockByHashJson.getShort("nTx"));
            block.setSize(blockByHashJson.getInteger("size"));
            block.setDifficulty(blockByHashJson.getDouble("difficulty"));
            block.setWeight(blockByHashJson.getFloat("weight"));
            block.setNextBlock(blockByHashJson.getString("nextblockhash"));
            block.setPrevBlock(blockByHashJson.getString("previousblockhash"));
            blockMapper.insert(block);
            temp=block.getNextBlock();
        }
        logger.info("end.......");
    }
}
