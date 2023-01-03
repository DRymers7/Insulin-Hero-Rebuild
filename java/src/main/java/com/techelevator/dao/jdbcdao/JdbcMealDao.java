package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.nutritionapi.wrappers.TotalNutrients;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> getUserOneDayMeals(int userId) {

            List<Meal> dailyMeals = new ArrayList<>();

            String sql = "SELECT m.meal_id, serving_size, unit_of_measure, food_name, time_of_meal, date_of_meal " +
                    "FROM meals m " +
                    "JOIN meals_user_join mj ON m.meal_id = mj.meal_id " +
                    "JOIN user_data ud ON ud.user_id = mj.user_id " +
                    "WHERE ud.user_id = ? AND m.date_of_meal = date_trunc('day', current_date)";

            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

            while (rowSet.next()) {
                dailyMeals.add(mapRowToMealObject(rowSet));
            }
            return dailyMeals;

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
    public void saveMealInformation(int mealId, TotalNutrients totalNutrients, Meal meal) throws SQLException {



        String sql = "INSERT INTO public.meal_information( " +
                "meal_id, glycemic_load, calories_g, total_fats_g, saturated_fats_g, trans_fats_g, fatty_acids_monosaturated_g, fatty_acids_polyunsaturated_g, " +
                "carbs_by_difference_g, total_carbs_g, fiber_g, sugars_g, added_sugars_g, protein_g, cholesterol_mg, sodium_mg, calcium_mg, magnesium_mg, potassium_mg, " +
                "iron_mg, zinc_mg, phosphorous_mg, vit_a_rae_micg, vit_c_mg, thiamin_mg, riboflavin_mg, niacin_mg, vit_b6_mg, folate_dfe_micg, folate_food_micg, folic_acid_micg, " +
                "vit_b12_micg, vit_d_micg, vit_e_micg, vit_k_micg, water_g) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";



    }

    private Meal mapRowToMealObject(SqlRowSet rowSet) {
        Meal meal = new Meal();
        meal.setMealId(rowSet.getInt("meal_id"));
        meal.setServingSize(rowSet.getDouble("serving_size"));
        meal.setUnitOfMeasure(rowSet.getString("unit_of_measure"));
        meal.setFoodName(rowSet.getString("food_name"));
        meal.setTimeOfMeal(rowSet.getTime("time_of_meal").toLocalTime());
        meal.setDateOfMeal(rowSet.getDate("date_of_meal").toLocalDate());
        return meal;
    }


}
