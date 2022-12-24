package com.techelevator.dao;

import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.dao.jdbcdao.JdbcBloodSugarDao;
import com.techelevator.model.pojos.BloodSugar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

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
        Assert.assertEquals("12:00:00", bloodSugar.getTimeOfMeasurement().toString());
        Assert.assertEquals("2022-12-24", bloodSugar.getDateOfMeasurement().toString());
    }

}
