package com.techelevator.dao;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.jdbcdao.JdbcBloodSugarDao;
import com.techelevator.model.pojos.BloodSugar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class JdbcBloodSugarDaoTests extends BaseDaoTests{

    private BloodSugarDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcBloodSugarDao(jdbcTemplate);
    }

    @Test
    public void getBloodSugar_returns_blood_sugar() throws SQLException {
        BloodSugar bloodSugar = dao.getBloodSugar(1);
        Assert.assertEquals(1, bloodSugar.getBloodSugarId());
        Assert.assertEquals(100, bloodSugar.getInputLevel());
        Assert.assertEquals("12:00", bloodSugar.getTimeOfMeasurement().toString());
        Assert.assertEquals("2022-12-24", bloodSugar.getDateOfMeasurement().toString());
    }

    @Test
    public void create_blood_sugar_returns_blood_sugar() throws SQLException {
        BloodSugar bloodSugar = new BloodSugar();
        bloodSugar.setInputLevel(200);
        bloodSugar.setTimeOfMeasurement(LocalTime.parse("12:00"));
        bloodSugar.setDateOfMeasurement(LocalDate.parse("2022-12-24"));
        BloodSugar returnValue = dao.createBloodSugar(1, bloodSugar);
        Assert.assertEquals(200, returnValue.getInputLevel());
        Assert.assertEquals("12:00", returnValue.getTimeOfMeasurement().toString());
        Assert.assertEquals("2022-12-24", returnValue.getDateOfMeasurement().toString());
    }

    @Test
    public void get_blood_sugar_list_returns_list() throws SQLException {
        List<BloodSugar> bloodSugarList = dao.getPreviousWeekBloodSugars(1);
        Assert.assertEquals(3, bloodSugarList.size());
    }

}
