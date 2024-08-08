package com.example.chat.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@RequiredArgsConstructor
@EnableMongoRepositories(basePackages = "com.example.chat")
@Configuration
public class MongoConfig {

    private final MongoProperties mongoProperties;
    @Value("${mongodb.client}")
    private String MONGO_DB_CLIENT;
    @Value("${mongodb.name}")
    private String MONGO_DB_NAME;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(MONGO_DB_CLIENT);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), MONGO_DB_NAME);
    }

}