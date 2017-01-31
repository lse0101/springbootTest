package com.crazysalaryman;

import com.crazysalaryman.domain.Customer;
import com.crazysalaryman.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Created by lse0101 on 2017-01-13.
 */

@ComponentScan
@EnableAutoConfiguration
@Slf4j
public class App implements CommandLineRunner{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.save(new Customer(null, "lee", "seungeun"));

        log.info("created: " + customer);
        List<Customer> customerList = customerRepository.findAll();

        customerList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
