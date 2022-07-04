package Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;


@Slf4j
@SpringBootApplication
@EnableCaching
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShopApplication.class, args);

        //Сделать страничку со списком книг на Spring MVC + thymeleaf

    }

}