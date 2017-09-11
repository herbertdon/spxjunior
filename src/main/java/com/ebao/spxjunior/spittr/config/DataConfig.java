package com.ebao.spxjunior.spittr.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by dondavid on 17/9/7.
 */
@Configuration
public class DataConfig {
  //dbcp datasource
  @Bean
  public DataSource dataSource() {
    BasicDataSource datasource = new BasicDataSource();
//    datasource.setDriverClassName("com.mysql.jdbc.Driver"); //this driver should be configured in properties.
    datasource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //this driver should be configured in properties.
    datasource.setUrl("jdbc:mysql://127.0.0.1:3306/spxjunior?useUnicode=true&characterEncoding=utf8"
        + "&useSSL=false");
    datasource.setUsername("root");
    datasource.setPassword("passw0rd");
    datasource.setInitialSize(2);
    datasource.setMaxActive(10);
    datasource.setMaxIdle(2);
//    datasource.setMaxWait(100);
//    datasource.setRemoveAbandoned(true);
//    datasource.setRemoveAbandonedTimeout(200);
//    datasource.setLogAbandoned(true);
    return datasource;
  }

  @Bean
  public JdbcOperations jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
