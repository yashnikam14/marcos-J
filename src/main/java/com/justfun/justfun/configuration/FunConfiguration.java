package com.justfun.justfun.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class FunConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
