package com.bot.analyze.telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@Configuration
@EnableCaching
public class Application {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(Application.class, args);
    }

}
