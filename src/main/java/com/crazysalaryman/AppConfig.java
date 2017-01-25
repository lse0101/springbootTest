package com.crazysalaryman;

import lombok.extern.slf4j.Slf4j;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * Created by lse0101 on 1/24/17.
 */
@Slf4j
@Configuration
public class AppConfig {

  @Autowired
  DataSourceProperties dataSourceProperties;
  DataSource dataSource;

  @Bean
  @ConfigurationProperties("spring.datasource")
  DataSource realDataSource(){
//    DataSourceBuilder factory = DataSourceBuilder
//        .create(this.dataSourceProperties.getClassLoader())
//        .url(this.dataSourceProperties.getUrl())
//        .username(this.dataSourceProperties.getUsername())
//        .password(this.dataSourceProperties.getPassword());
    System.out.println(this.dataSourceProperties.getUrl());
    DataSourceBuilder factory = DataSourceBuilder.create();

    this.dataSource = factory.build();
    return this.dataSource;
  }

  @Bean
  @Primary
  DataSource dataSource(){
    return new Log4jdbcProxyDataSource(this.dataSource);
  }

}
