package com.example.bitcoinexplorer0614.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bitcoinexplorer0614.api.BitcoinRestApi;
import com.example.bitcoinexplorer0614.dao.BlockMapper;
import com.example.bitcoinexplorer0614.dao.TransactionDetailMapper;
import com.example.bitcoinexplorer0614.dao.TransactionMapper;
import com.example.bitcoinexplorer0614.enumration.TxDType;
import com.example.bitcoinexplorer0614.po.Block;
import com.example.bitcoinexplorer0614.po.Transaction;
import com.example.bitcoinexplorer0614.po.TransactionDetail;
import com.example.bitcoinexplorer0614.service.BTCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service

public class BTCServiceImpl implements BTCService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Override
    @Async
    @Transactional
    public void sysnBlock(String blockHash) {
        logger.info("sync bitcoin begin to {}",blockHash);
        String temp=blockHash;
        while(temp!=null && !temp.isEmpty()){
            JSONObject blockByHashJson = bitcoinRestApi.getBlockByHashJson(temp);
            Block block =new Block();
            block.setBlockhash(blockByHashJson.getString("hash"));
            block.setHeight(blockByHashJson.getInteger("height"));
//            Long time = blockByHashJson.getLong("time");
//            block.setTime(new Date(time*1000));
            Long t = blockByHashJson.getLong("time");
            Date time = new Date(t*1000);
            block.setTime(time);

            block.setTxsize(blockByHashJson.getShort("nTx"));
            block.setSize(blockByHashJson.getInteger("size"));
            block.setDifficulty(blockByHashJson.getDouble("difficulty"));
            block.setWeight(blockByHashJson.getFloat("weight"));
            block.setNextBlock(blockByHashJson.getString("nextblockhash"));
            block.setPrevBlock(blockByHashJson.getString("previousblockhash"));
            Integer confirmations = blockByHashJson.getInteger(("confirmations"));
            //todo sync txes
            JSONArray txArray = blockByHashJson.getJSONArray("tx");
            for (Object txObject : txArray) {
                JSONObject txJson =new JSONObject((LinkedHashMap)txObject);
                syncTx(txJson,blockHash,time,confirmations);
            }

            blockMapper.insert(block);

            temp=block.getNextBlock();
        }
        logger.info("end.......");
    }

    @Override
    public void syncTx(JSONObject txJson, String blockHash, Date time, Integer confirmations) {
        Transaction tx = new Transaction();
        String txid = txJson.getString("txid");
        tx.setTxhash(txid);
        tx.setBlockhash(blockHash);
        //todo set amount
        tx.setTime(time);
        tx.setSize(txJson.getInteger("size"));
        tx.setWeight(txJson.getFloat("weight"));
        tx.setConfirmations(confirmations);
        transactionMapper.insert(tx);

        txDetail(txJson,txid);
    }

    @Override
    public void txDetail(JSONObject txJson,String txid) {
        JSONArray vouts = txJson.getJSONArray("vout");
        txDetailVout(vouts,txid);
        JSONArray vins = txJson.getJSONArray("vin");
        txDetailVin(vins,txid);
    }

    @Override
    @Transactional
    public void txDetailVout(JSONArray vouts,String txid) {
        for (Object voutObject : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap)voutObject);
            TransactionDetail transactionDetail = new TransactionDetail();
            transactionDetail.setAmount(jsonObject.getDouble("value"));
            transactionDetail.setTxhash(txid);
            transactionDetail.setType((byte)TxDType.Receive.ordinal());
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray addresses = scriptPubKey.getJSONArray("address");
            if(addresses!=null){
                String address = addresses.getString(0);
                transactionDetail.setAddress(address);
            }
            transactionDetailMapper.insert(transactionDetail);

        }
    }

    @Override
    public void txDetailVin(JSONArray vin, String txid) {

    }
}
