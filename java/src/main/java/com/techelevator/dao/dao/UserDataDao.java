package com.techelevator.dao.dao;

import com.techelevator.model.pojos.UserData;

import java.sql.SQLException;

public interface UserDataDao {

    public UserData getUserData(int userId) throws SQLException;

}
