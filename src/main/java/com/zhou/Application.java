package com.zhou;

import com.zhou.model.StockInfo;
import com.zhou.repository.StockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigInteger;

@ComponentScan(basePackages = "com.zhou")
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    StockInfoRepository stockInfoRepository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stockInfoRepository.save(new StockInfo("", 50.0, 20.0, 20.0, 5000, BigInteger.ONE, 20.0));
    }
}
