package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Autowired
    DataSource dataSource;

    @Bean(name = "jdbctemplate")
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "namedparameterjdbctemplate")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() { return new NamedParameterJdbcTemplate(dataSource);}
}

