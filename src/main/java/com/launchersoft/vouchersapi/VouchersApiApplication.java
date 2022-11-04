package com.launchersoft.vouchersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class VouchersApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VouchersApiApplication.class, args);
    }

}
