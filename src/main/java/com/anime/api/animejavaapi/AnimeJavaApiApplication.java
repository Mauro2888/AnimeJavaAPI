package com.anime.api.animejavaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnimeJavaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeJavaApiApplication.class, args);
    }

}
