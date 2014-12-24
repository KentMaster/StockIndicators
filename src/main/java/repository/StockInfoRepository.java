package repository;

import model.StockInfo;
import java.util.List;

/**
 * Created by li on 12/21/14.
 */
public interface StockInfoRepository {

    public long count();
    public void save(StockInfo stockInfo);
    public void save(List<String> stockInfo);
    public void delete(StockInfo stockInfo);
    public List<StockInfo> findAll();
}
