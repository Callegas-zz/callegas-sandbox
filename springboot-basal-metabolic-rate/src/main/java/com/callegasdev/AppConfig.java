package com.callegasdev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BRMService brmService(){
        return new BRMService();
    }
}
