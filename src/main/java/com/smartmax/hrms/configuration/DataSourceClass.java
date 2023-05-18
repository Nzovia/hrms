package com.smartmax.hrms.configuration;

import com.smartmax.hrms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceClass {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource getDataSource() {
    DataSource dataSource;
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.url(url);
    dataSourceBuilder.driverClassName(driverClassName);
    dataSourceBuilder.username(username);
    dataSourceBuilder.password(password);
    dataSource = dataSourceBuilder.build();
    return dataSource;
    }
}
