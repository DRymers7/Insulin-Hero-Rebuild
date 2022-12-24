package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.model.pojos.BloodSugar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class JdbcBloodSugarDao implements BloodSugarDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBloodSugarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BloodSugar getBloodSugar(int userId) throws SQLException {

        String sql = "SELECT bs.blood_sugar_id, input_level, time_last_measurement, date_last_measurement FROM blood_sugar bs " +
                "JOIN blood_sugar_user_data_join bj ON bj.blood_sugar_id = bs.blood_sugar_id " +
                "WHERE bj.user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        if (rowSet.next()) {
            return mapRowToBloodSugar(rowSet);
        } else {
            throw new SQLException("Could not find applicable user.");
        }

    }

    @Override
    public BloodSugar createBloodSugar(int userId, BloodSugar bloodSugar) throws SQLException {

        try {

            String sql = "INSERT INTO blood_sugar (input_level, time_last_measurement, date_last_measurement) VALUES (?, ?, ?) RETURNING blood_sugar_id;";
            int bloodSugarId = jdbcTemplate.queryForObject(sql, Integer.class, bloodSugar.getInputLevel(), bloodSugar.getTimeOfMeasurement(), bloodSugar.getDateOfMeasurement());
            createBloodSugarJoinEntry(userId, bloodSugarId);
            bloodSugar.setBloodSugarId(bloodSugarId);
            return bloodSugar;

        } catch (SQLException e) {
            throw new SQLException("Could not create blood sugar reading.");
        }
    }

    private boolean createBloodSugarJoinEntry(int bloodSugarId, int userId) throws SQLException {
        String sql = "INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (?, ?);";
        int rowsAffected = jdbcTemplate.update(sql, bloodSugarId, userId);
        return rowsAffected == 1;
    }

    private BloodSugar mapRowToBloodSugar(SqlRowSet rowSet) {
        BloodSugar bloodSugar = new BloodSugar();
        bloodSugar.setBloodSugarId(rowSet.getInt("blood_sugar_id"));
        bloodSugar.setInputLevel(rowSet.getInt("input_level"));
        bloodSugar.setTimeOfMeasurement(rowSet.getTime("time_last_measurement").toLocalTime());
        bloodSugar.setDateOfMeasurement(rowSet.getDate("date_last_measurement").toLocalDate());
        return bloodSugar;
    }


}
