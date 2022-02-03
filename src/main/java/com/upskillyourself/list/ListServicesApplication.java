package com.upskillyourself.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ListServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListServicesApplication.class, args);
    }

}
