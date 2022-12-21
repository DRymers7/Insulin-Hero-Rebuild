package com.techelevator.dao;

import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.dao.jdbcdao.JdbcUserDataDao;
import com.techelevator.model.pojos.UserData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class UserDataDaoTests extends BaseDaoTests {

    private UserDataDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcUserDataDao(jdbcTemplate);
    }

    @Test
    public void getUserData_returns_user_data() throws SQLException {
        UserData userData = dao.getUserData(1);
        Assert.assertEquals(1, userData.getUserId());
        Assert.assertEquals("rymersd@gmail.com", userData.getEmergencyContact1());
        Assert.assertEquals("mdelafay497@gmail.com", userData.getEmergencyContact2());
        Assert.assertFalse(userData.isPreDiabetic());
        Assert.assertEquals(2, userData.getDiabetesType());
    }
}
