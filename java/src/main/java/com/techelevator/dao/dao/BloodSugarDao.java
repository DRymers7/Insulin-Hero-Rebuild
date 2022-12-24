package com.techelevator.dao.dao;

import com.techelevator.model.pojos.BloodSugar;

import java.sql.SQLException;
import java.util.List;

public interface BloodSugarDao {

    BloodSugar getBloodSugar(int userId) throws SQLException;
    BloodSugar createBloodSugar(int userId, BloodSugar bloodSugar) throws SQLException;
    List<BloodSugar> getPreviousWeekBloodSugars(int userId) throws SQLException;
}
