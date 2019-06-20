package com.example.bitcoinexplorer0614.dao;

import com.example.bitcoinexplorer0614.dto.BlockGetDto;
import com.example.bitcoinexplorer0614.dto.BlockListDto;
import com.example.bitcoinexplorer0614.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> selectNewBlock();

    Block getByBlockhash(@Param("blockhash") String blockhash);
}