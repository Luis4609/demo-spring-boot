package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NamedParameterJdbcRepository extends DemoRepository{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * @param customer
     * @return
     */
    @Override
    public int update(Customer customer) {
        return namedParameterJdbcTemplate.update(
                "update customers set name = :name where id = :id",
                new BeanPropertySqlParameterSource(customer));
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<Customer> findByName(String name) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", "%" + name + "%");

        return namedParameterJdbcTemplate.query(
                "select * from customers where name like :name",
                mapSqlParameterSource,
                (rs, rowNum) ->
                        new Customer(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Customer> findById(Long id) {
        return namedParameterJdbcTemplate.queryForObject(
                "select * from books where id = :id",
                new MapSqlParameterSource("id", id),
                (rs, rowNum) ->
                        Optional.of(new Customer(
                                rs.getLong("id"),
                                rs.getString("name")
                        ))
        );
    }
}