package com.example.demo.repository;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface IDemoRepository {

    int count();

    int save(Customer customer);

    int update(Customer customer);

    int deleteById(Long id);

    List<Customer> findAll();

    List<Customer> findByName(String name);

    Optional<Customer> findById(Long id);

    String getNameById(Long id);
}
