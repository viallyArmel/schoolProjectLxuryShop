package com.example.henallux.luxuryshopProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LuxuryShopProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuxuryShopProjectApplication.class, args);
    }

}
