package com.playground.jdbcplayground.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcDataSourceConfig
{
    @Bean
    @Qualifier("mysqlJdbcTemplate")
    public JdbcTemplate mysqlDataSource()
    {
        DriverManagerDataSource mysqlDataSource = new DriverManagerDataSource();
        mysqlDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        mysqlDataSource.setUsername("fola");
        mysqlDataSource.setPassword("password");
        mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC");

        return new JdbcTemplate(mysqlDataSource);
    }

}
