package com.zhou.service;

import com.zhou.model.StockInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import com.zhou.repository.StockInfoRepository;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Service
//@Configurable
public class StockData {
//    @Autowired
    protected StockInfoRepository mongoDBStockInfoRepository;

//    @Autowired
//    public StockData(StockInfoRepository mongoDBStockInfoRepository){
//        this.mongoDBStockInfoRepository = mongoDBStockInfoRepository;
////        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
////        this.mongoDBStockInfoRepository = ctx.getBean(StockInfoRepository.class);
//    }

    public void getStockData(String symbol) throws IOException {
        FileUtils.copyURLToFile(
                new URL(String.format("http://real-chart.finance.yahoo.com/table.csv?s=%s&d=11&e=21&f=2014&g=d&a=11&b=12&c=1980&ignore=.csv", symbol)),
                new File(symbol + ".csv")
        );
        readRecords(symbol);


    }

    public List<StockInfo> readRecords(String symbol) throws IOException {
        Function<String, StockInfo> csvToStockInfo = line -> save(line);
        Path path = Paths.get(symbol + ".csv");
        List<StockInfo> collect = Files.lines(path).skip(1).map(csvToStockInfo).collect(Collectors.toList());
        return collect;
    }

    public StockInfo save(String input) {
        String[] line = input.split(",");
        StockInfo stockInfo = new StockInfo(
                line[0],
                Double.parseDouble(line[1]),
                Double.parseDouble(line[2]),
                Double.parseDouble(line[3]),
                Double.parseDouble(line[4]),
                new BigInteger(line[5]),
                Double.parseDouble(line[6]));
//        mongo.save(stockInfo, collectionName);
        return stockInfo;
    }


}
