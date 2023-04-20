package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The type Demo repository.
 */
@Repository
public class DemoRepository implements IDemoRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoRepository.class);
    private final JdbcTemplate jdbcTemplate;

    /**
     * Instantiates a new Demo repository.
     *
     * @param jdbcTemplate the jdbc template
     */
    public DemoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from customers", Integer.class);
    }

    @Override
    public int save(Customer customer) {
        return jdbcTemplate.update(
                "insert into customers (name) values(?)",
                customer.name());
    }

    @Override
    public int update(Customer customer) {
        return jdbcTemplate.update(
                "update books set name = ? where id = ?",
                customer.name(), customer.id());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete customers where id = ?",
                id);
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(
                "select * from customers",
                (rs, rowNum) ->
                        new Customer(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String getNameById(Long id) {
        return null;
    }
}
