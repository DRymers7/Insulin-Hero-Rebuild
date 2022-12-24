package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.model.pojos.BloodSugar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcBloodSugarDao implements BloodSugarDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBloodSugarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BloodSugar getBloodSugar(int userId) {
        return null;
    }

    /*
    SELECT bs.blood_sugar_id, input_level, time_last_measurement, date_last_measurement FROM blood_sugar bs
JOIN blood_sugar_user_data_join bj ON bj.blood_sugar_id = bs.blood_sugar_id
WHERE bj.user_id = ?
     */
}
