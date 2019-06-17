package com.example.bitcoinexplorer0614;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.example.bitcoinexplorer0614.dao")
@EnableFeignClients
public class Bitcoinexplorer0614Application {

	public static void main(String[] args) {
		SpringApplication.run(Bitcoinexplorer0614Application.class, args);
	}

}
