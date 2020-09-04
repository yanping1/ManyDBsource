package com.yanping.manydb.manydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ManydbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManydbApplication.class, args);
    }

}
