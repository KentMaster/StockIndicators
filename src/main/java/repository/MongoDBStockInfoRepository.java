package repository;

import model.StockInfo;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigInteger;
import java.util.List;


public class MongoDBStockInfoRepository implements StockInfoRepository{

    private final MongoTemplate mongo;
    private final String collectionName;

    public MongoDBStockInfoRepository(MongoTemplate mongo, String collectionName) {
        this.mongo = mongo;
        this.collectionName = collectionName;
    }


    @Override
    public long count() {
        return mongo.count(null,collectionName);
    }

    @Override
    public void save(StockInfo stockInfo) {
        mongo.save(stockInfo,collectionName);
    }

    @Override
    public void delete(StockInfo stockInfo) {
        mongo.remove(stockInfo, collectionName);
    }

    @Override
    public List<StockInfo> findAll() {
        return mongo.findAll(StockInfo.class, collectionName);
    }

    public void save(List<String> line) {
        mongo.save(new StockInfo(
                line.get(0),
                Double.parseDouble(line.get(1)),
                Double.parseDouble(line.get(2)),
                Double.parseDouble(line.get(2)),
                new BigInteger(line.get(4)),
                Double.parseDouble(line.get(5))), collectionName);
    }

}
