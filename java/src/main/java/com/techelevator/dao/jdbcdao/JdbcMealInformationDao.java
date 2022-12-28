package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.MealInformationDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcMealInformationDao implements MealInformationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMealInformationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    

}
