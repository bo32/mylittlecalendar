package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context {

    @Bean
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource getDataSource() {
    	return DataSourceBuilder.create().build();
    }
}
