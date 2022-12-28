package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.nutritionapi.TotalNutrients;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class JdbcMealDao implements MealDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createNewMeal(int userId, Meal meal) throws SQLException {

        try {

            String sql = "INSERT INTO meals (serving_size, unit_of_measure, food_name, time_of_meal, date_of_meal) " +
                    "VALUES (?, ?, ?, ?, ?) RETURNING meal_id";

            int mealId = jdbcTemplate.queryForObject(sql, Integer.class, meal.getServingSize(), meal.getUnitOfMeasure(), meal.getFoodName(),
                    meal.getTimeOfMeal(), meal.getDateOfMeal());

            if (!(createMealUserJoinEntry(userId, mealId))) {
                throw new SQLException("Could not create meal join entry.");
            } else {
                return mealId;
            }

        } catch (SQLException e) {
            throw new SQLException("Could not create meal.");
        }

    }

    private boolean createMealUserJoinEntry(int mealId, int userId) throws SQLException {
        String sql = "INSERT INTO meal_user_data_join (meal_id, user_id) VALUES (?, ?);";
        int rowsAffected = jdbcTemplate.update(sql, mealId, userId);
        return rowsAffected == 1;
    }

    @Override
    public void saveMealInformation(int mealId, TotalNutrients totalNutrients) throws SQLException {

        String sql = "";

    }

    private double calculateGlycemicIndex() {
        return 0;
    }


}
