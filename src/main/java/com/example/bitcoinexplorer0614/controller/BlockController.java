package com.example.bitcoinexplorer0614.controller;

import com.example.bitcoinexplorer0614.dto.BlockGetDto;
import com.example.bitcoinexplorer0614.dto.BlockListDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
    @GetMapping("/getRecentBlocks")
    public List<BlockListDto> getRecentBlocks(){

        ArrayList<BlockListDto> blockListDTOS = new ArrayList<>();

        BlockListDto blockListDTO = new BlockListDto();
        blockListDTO.setBlockhash("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockListDTO.setHeight(580644);
        blockListDTO.setTime(new Date());
        blockListDTO.setTxsize((short) 2390);
        blockListDTO.setSize(1257767);
        blockListDTOS.add(blockListDTO);

        BlockListDto blockListDTO2 = new BlockListDto();
        blockListDTO2.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockListDTO2.setHeight(580643);
        blockListDTO2.setTime(new Date());
        blockListDTO2.setTxsize((short) 2702);
        blockListDTO2.setSize(1322496);
        blockListDTOS.add(blockListDTO2);

        return blockListDTOS;
    }

    @GetMapping("/getByBlockhash")
    public BlockGetDto getByBlockhash(@RequestParam String blockhash){
       return null;
    }

    @GetMapping("/getByHeight")
    public BlockGetDto getByHeight(@RequestParam Integer height){
        return null;
    }
}
