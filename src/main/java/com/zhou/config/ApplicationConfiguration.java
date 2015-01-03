//package com.zhou.config;
//
//import com.mongodb.Mongo;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
//@EnableMongoRepositories
//class ApplicationConfiguration extends AbstractMongoConfiguration {
//
//    @Override
//    protected String getDatabaseName() {
//        return "e-store";
//    }
//
//    @Override
//    public Mongo mongo() throws Exception {
//        return new Mongo();
//    }
//
//    @Override
//    protected String getMappingBasePackage() {
//        return "com.zhou.*";
//    }
//}