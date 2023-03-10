package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.dao.BloodSugarDao;
import com.techelevator.helperclasses.BloodSugarHelper;
import com.techelevator.model.pojos.BloodSugar;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class BloodSugarController {

    private BloodSugarDao bloodSugarDao;
    private UserDao userDao;

    private BloodSugarHelper bloodSugarHelper;

    public BloodSugarController(BloodSugarDao bloodSugarDao, UserDao userDao) {
        this.bloodSugarDao = bloodSugarDao;
        this.userDao = userDao;
        this.bloodSugarHelper = new BloodSugarHelper(bloodSugarDao);
    }

    @GetMapping("/bloodsugars")
    public BloodSugar getBloodSugar(Principal principal) {
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return bloodSugarDao.getBloodSugar(userId);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/bloodsugars")
    public BloodSugar createBloodSugar(@RequestBody BloodSugar bloodSugar, Principal principal) {
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return bloodSugarDao.createBloodSugar(userId, bloodSugar);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/bloodsugars/history")
    public Map<String, List<BloodSugar>> getPreviousWeekBloodSugars(Principal principal) {
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            return bloodSugarHelper.getBloodSugarHistory(userId);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
