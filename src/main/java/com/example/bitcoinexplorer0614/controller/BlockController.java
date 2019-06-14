package com.example.bitcoinexplorer0614.controller;

import com.example.bitcoinexplorer0614.dto.BlockGetDto;
import com.example.bitcoinexplorer0614.dto.BlockListDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
    @GetMapping("/getRecentBlocks")
    public List<BlockListDto> getRecentBlocks(){
        return null;
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
