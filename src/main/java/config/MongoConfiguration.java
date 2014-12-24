package config;

import model.StockInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import repository.MongoDBStockInfoRepository;
import repository.MongoDBVehicleRepository;
import repository.StockInfoRepository;
import repository.VehicleRepository;

@Configuration
public class MongoConfiguration {


    public static final String DB_NAME = "stockdb";

    @Bean
    public MongoTemplate mongo() throws Exception {
        return new MongoTemplate(mongoFactoryBean().getObject(), DB_NAME);
    }

    @Bean
    public MongoFactoryBean mongoFactoryBean() {
        return new MongoFactoryBean();
    }

    @Bean
    public StockInfoRepository stockInfoRepository(MongoTemplate mongo) {
        return new MongoDBStockInfoRepository(mongo, "vehicles") {
        };
    }

    @Bean
    public VehicleRepository vehicleRepository(MongoTemplate mongo) {
        return new MongoDBVehicleRepository(mongo, "vehicles");
    }

//    @Bean
//    public Mongo mongo() throws UnknownHostException {
//        return new MongoClient();
//    }
//
//    @Bean
//    public VehicleRepository vehicleRepository(Mongo mongo) {
//        return new MongoDBVehicleRepository(mongo, DB_NAME, " vehicles");
//    }
}
