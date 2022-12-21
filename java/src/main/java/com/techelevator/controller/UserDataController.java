package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.dao.UserDataDao;
import com.techelevator.model.pojos.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class UserDataController {

    private UserDataDao userDataDao;
    private UserDao userDao;

    public UserDataController(UserDataDao userDataDao, UserDao userDao) {
        this.userDataDao = userDataDao;
        this.userDao = userDao;
    }

    @GetMapping("/userdata")
    public UserData getUserData(Principal principal) {
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return userDataDao.getUserData(userId);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
