package com.lcwd.electronic.store.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConifg {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
