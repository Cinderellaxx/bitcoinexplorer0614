package com.example.bitcoinexplorer0614.service;

import com.alibaba.fastjson.JSONObject;
import com.example.bitcoinexplorer0614.dto.BlockListDto;

import java.util.Date;
import java.util.List;

public interface BlockService {
    List<BlockListDto> getNewBlock();

}
