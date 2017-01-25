package com.crazysalaryman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by lse0101 on 2017-01-13.
 */

//@EnableAutoConfiguration
//@ComponentScan
    @SpringBootApplication
public class App implements CommandLineRunner{
//    @Autowired
//    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(
            this.dataSourceProperties.getUrl()
        );
//        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
//        SqlParameterSource param = new MapSqlParameterSource()
//                .addValue("id", 1);
//
//        Customer result = jdbcTemplate.queryForObject(sql,
//                                                    param,
//            (rs, rowNum) -> new Customer(rs.getInt("id"),
//                                        rs.getString("first_name"),
//                                        rs.getString("last_name"))
//
//
//        );
//
//        System.out.println(result);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
