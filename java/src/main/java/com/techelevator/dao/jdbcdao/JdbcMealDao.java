package com.techelevator.dao.jdbcdao;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.nutritionapi.wrappers.TotalNutrients;
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
    public void saveMealInformation(int mealId, TotalNutrients totalNutrients, Meal meal) throws SQLException {



        String sql = "INSERT INTO public.meal_information( " +
                "meal_id, glycemic_load, calories_g, total_fats_g, saturated_fats_g, trans_fats_g, fatty_acids_monosaturated_g, fatty_acids_polyunsaturated_g, " +
                "carbs_by_difference_g, total_carbs_g, fiber_g, sugars_g, added_sugars_g, protein_g, cholesterol_mg, sodium_mg, calcium_mg, magnesium_mg, potassium_mg, " +
                "iron_mg, zinc_mg, phosphorous_mg, vit_a_rae_micg, vit_c_mg, thiamin_mg, riboflavin_mg, niacin_mg, vit_b6_mg, folate_dfe_micg, folate_food_micg, folic_acid_micg, " +
                "vit_b12_micg, vit_d_micg, vit_e_micg, vit_k_micg, water_g) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";



    }

    private double calculateGlycemicLoad(TotalNutrients totalNutrients, Meal meal) {
        return 0;
    }


}
