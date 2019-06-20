package com.example.bitcoinexplorer0614.service.impl;

import com.example.bitcoinexplorer0614.dao.BlockMapper;
import com.example.bitcoinexplorer0614.dto.BlockListDto;
import com.example.bitcoinexplorer0614.po.Block;
import com.example.bitcoinexplorer0614.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;
    @Override
    public List<BlockListDto> getNewBlock() {
        ArrayList<BlockListDto> blockListDtos = new ArrayList<>();
        List<Block> blocks = blockMapper.selectNewBlock();
        for (Block block : blocks) {
            BlockListDto blockListDto = new BlockListDto();
            blockListDto.setBlockhash(block.getBlockhash());
            blockListDto.setHeight(block.getHeight());
//            blockListDto.setTime(block.getTime().getTime());
            blockListDto.setTxsize(block.getTxsize());
            blockListDto.setSize(block.getSize());
            blockListDtos.add(blockListDto);
        }
        return blockListDtos;
    }
}
