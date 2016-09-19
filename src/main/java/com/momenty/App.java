package com.momenty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Created by manish on 12/09/16.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.momenty", "com.auth0.spring.security.api"})
@EnableAutoConfiguration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:auth0.properties")
})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
