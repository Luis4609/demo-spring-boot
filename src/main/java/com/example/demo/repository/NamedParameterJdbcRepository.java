package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NamedParameterJdbcRepository implements IDemoRepository{
    /**
     * @return
     */
    @Override
    public int count() {
        return 0;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public int save(Customer customer) {
        return 0;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public int update(Customer customer) {
        return 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteById(Long id) {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public List<Customer> findAll() {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String getNameById(Long id) {
        return null;
    }
}
