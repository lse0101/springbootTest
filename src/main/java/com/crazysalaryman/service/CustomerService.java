package com.crazysalaryman.service;

import com.crazysalaryman.domain.Customer;
import com.crazysalaryman.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lse0101 on 2017-01-23.
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
