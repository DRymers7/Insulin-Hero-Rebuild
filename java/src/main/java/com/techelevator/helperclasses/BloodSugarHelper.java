package com.techelevator.helperclasses;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.model.pojos.BloodSugar;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BloodSugarHelper {

    private BloodSugarDao bloodSugarDao;

    public BloodSugarHelper(BloodSugarDao bloodSugarDao) {
        this.bloodSugarDao = bloodSugarDao;
    }

    public Map<String, List<BloodSugar>> getBloodSugarHistory(int userId) throws SQLException {
        Map<String, List<BloodSugar>> bloodSugarData = new HashMap<>();
        bloodSugarData.put("thisWeek", getThisWeekBloodSugars(userId));
        bloodSugarData.put("previousWeek", getLastWeekBloodSugars(userId));
        return bloodSugarData;
    }

    private List<BloodSugar> getThisWeekBloodSugars(int userId) throws SQLException {
        return bloodSugarDao.getThisWeekBloodSugars(userId);
    }

    private List<BloodSugar> getLastWeekBloodSugars(int userId) throws SQLException {
        return bloodSugarDao.getPreviousWeekBloodSugars(userId);
    }

}
