package com.example.bitcoinexplorer0614.dao;

import com.example.bitcoinexplorer0614.po.TransactionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    Double getMoneyDetail(@Param("address") String address);

    List<TransactionDetail> selectAddress(@Param("s") String s);
}