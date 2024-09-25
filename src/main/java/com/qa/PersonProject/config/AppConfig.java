package com.qa.PersonProject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
//    instantiate - create an instance of - model mapper

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
