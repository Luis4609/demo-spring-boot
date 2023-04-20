package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    JdbcTemplate jdbcTemplate;

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
        return jdbcTemplate.query(
                "select * from customers where name like ? ",
                new Object[]{"%" + name + "%"},
                (rs, rowNum) ->
                        new Customer(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from customers where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Customer(
                                rs.getLong("id"),
                                rs.getString("name")
                        ))
        );
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from customers where id = ?",
                new Object[]{id},
                String.class
        );
    }
}
