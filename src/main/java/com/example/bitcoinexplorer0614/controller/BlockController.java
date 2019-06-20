package com.example.bitcoinexplorer0614.controller;

import com.example.bitcoinexplorer0614.dao.BlockMapper;
import com.example.bitcoinexplorer0614.dto.BlockGetDto;
import com.example.bitcoinexplorer0614.dto.BlockListDto;
import com.example.bitcoinexplorer0614.po.Block;
import com.example.bitcoinexplorer0614.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BlockService blockService;
    @GetMapping("/getNewBlock")
    public List<BlockListDto> getNewBlock(){

        /*ArrayList<BlockListDto> blockListDTOS = new ArrayList<>();

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
*/
        List<BlockListDto> newBlock = blockService.getNewBlock();
        return newBlock;
    }

    @GetMapping("/getByBlockhash")
    public List<BlockListDto> getByBlockhash(@RequestParam String blockhash){
//        BlockGetDto blockGetDTO = new BlockGetDto();
//        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
//        blockGetDTO.setHeight(580643);
//        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
//        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
//        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
//        blockGetDTO.setTime(new Date().getTime());
//        blockGetDTO.setFees(8766.38);
//        blockGetDTO.setTxSize((short) 2702);
//        blockGetDTO.setSize(1322496);
//        blockGetDTO.setDifficulty(7409399249090.25);
        List<BlockListDto> byBlockhash = blockMapper.getByBlockhash(blockhash);
        return byBlockhash;

    }

    @GetMapping("/getByHeight")
    public BlockGetDto getByHeight(@RequestParam Integer height){
//        BlockGetDto blockGetDTO = new BlockGetDto();
//        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
//        blockGetDTO.setHeight(580643);
//        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
//        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
//        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
//        blockGetDTO.setTime(new Date().getTime());
//        blockGetDTO.setFees(8766.38);
//        blockGetDTO.setTxSize((short) 2702);
//        blockGetDTO.setSize(1322496);
//        blockGetDTO.setDifficulty(7409399249090.25);
        BlockGetDto byHeight = blockMapper.getByHeight(height);
        return byHeight;
    }

    @GetMapping("/getByPrevBlcok")
    public BlockGetDto getByPrevBlcok(@RequestParam String prevBlcok){
        BlockGetDto blockGetDTO = new BlockGetDto();
        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockGetDTO.setHeight(580643);
        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(8766.38);
        blockGetDTO.setTxSize((short) 2702);
        blockGetDTO.setSize(1322496);
        blockGetDTO.setDifficulty(7409399249090.25);

        return blockGetDTO;
    }

    @GetMapping("/getByNextBlcok")
    public BlockGetDto getByNextBlcok(@RequestParam String nextBlcok){
        BlockGetDto blockGetDTO = new BlockGetDto();
        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockGetDTO.setHeight(580643);
        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(8766.38);
        blockGetDTO.setTxSize((short) 2702);
        blockGetDTO.setSize(1322496);
        blockGetDTO.setDifficulty(7409399249090.25);

        return blockGetDTO;
    }
}
