package com.example.bitcoinexplorer0614.scheduling;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class BtcScheduling {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Scheduled(fixedRate = 10*60*1000)
    public void syncData(){
        logger.info("sync bitcoin data");
    }
}
