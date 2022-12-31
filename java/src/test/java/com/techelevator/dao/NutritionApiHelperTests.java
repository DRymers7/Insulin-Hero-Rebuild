package com.techelevator.dao;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.dao.jdbcdao.JdbcMealDao;
import com.techelevator.helperclasses.NutritionApiHelper;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.nutritionapi.NutritionInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class NutritionApiHelperTests extends BaseDaoTests {

    private NutritionApiHelper nutritionApiHelper;
    private MealDao mealDao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        mealDao = new JdbcMealDao(jdbcTemplate);
        this.nutritionApiHelper = new NutritionApiHelper();
    }




}
