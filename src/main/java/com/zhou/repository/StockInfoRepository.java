package com.zhou.repository;

import com.zhou.model.StockInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockInfoRepository extends MongoRepository<StockInfo, String> {

}
