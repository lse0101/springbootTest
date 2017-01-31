package com.crazysalaryman.repository;

import com.crazysalaryman.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by lse0101 on 2017-01-23.
 */
@Repository
@Transactional
public class CustomerRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    SimpleJdbcInsert insert;

    @PostConstruct
    public void init(){
        insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations())
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    private static final RowMapper<Customer> customerRowMapper = (rs, i) ->{
        Integer id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        return new Customer(id, firstName, lastName);
    };

    public List<Customer> findAll() {
        List<Customer> customers = jdbcTemplate.query(
                                    "select id, first_name, last_name from customers order by id",
                                    customerRowMapper
                                    );
        return customers;
    }

    public Customer findOne(Integer customerId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", customerId);
        return jdbcTemplate.queryForObject("select id, first_name, last_name from customers where id = :id",
                                    parameterSource,
                                    customerRowMapper);
    }

    public Customer save(Customer customer){
        SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
        if (customer.getId() == null) {
            Number id = insert.executeAndReturnKey(param);
            customer.setId(id.intValue());
        } else {
            jdbcTemplate.update("update customers set first_name = :firstName, lastName = :last_name where id= :id", param);
        }

        return customer;
    }

    public void delete(Integer customerId) {

        SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
        jdbcTemplate.update("delete from customers where id = :id", param);
    }
}
