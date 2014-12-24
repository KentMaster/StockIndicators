package service;

import model.StockInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import repository.MongoDBStockInfoRepository;
import repository.StockInfoRepository;

import java.io.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by li on 12/21/14.
 */
public class StockData {

    @Autowired
    private StockInfoRepository mongoDBStockInfoRepository;

    public void getStockData(String symbol) throws IOException {
        FileUtils.copyURLToFile(
                new URL(String.format("http://real-chart.finance.yahoo.com/table.csv?s=%s&d=11&e=21&f=2014&g=d&a=11&b=12&c=1980&ignore=.csv", symbol)),
                new File(symbol + ".csv")
        );
        for(List<String> line: readRecords(new FileReader(symbol + ".csv"))){
            mongoDBStockInfoRepository.save(line);
        }

    }

    public static List<List<String>> readRecords(Reader source) {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                    .map(line -> Arrays.asList(line.split(",")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
