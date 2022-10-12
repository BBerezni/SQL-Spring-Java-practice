package com.example.kitchen_vezba.repository;

import com.example.kitchen_vezba.model.Ingredient;
import com.example.kitchen_vezba.model.IngredientRowMapper;
import com.example.kitchen_vezba.repository.Interfaces.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SqlIngredientRepository implements IngredientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ingredient> getAllIngredients(){
        String query = "SELECT id, name, currentPrice FROM ingredient";;
        return jdbcTemplate.query(query, new IngredientRowMapper());
    }

    @Override
    public int insertIngredient(UUID id, Ingredient ingredient) {
        String insertIng = "INSERT INTO ingredient (id, name, currentPrice) values (?, ?, ?)";
        return jdbcTemplate.update(insertIng, ingredient.getId(), ingredient.getName(), ingredient.getCurrentPrice());
    }

    @Override
    public Optional<Ingredient> getIngredientById(UUID id) {
        String ingredientById =
                "SELECT id, name, currentPrice " +
                "FROM ingredient " +
                "WHERE id = ?;";
        return jdbcTemplate.query(ingredientById, new IngredientRowMapper(),id).stream().findFirst();
    }

    @Override
    public Optional<Ingredient> getIngredientIdByName(String name) {
        String ingredientIdByName =
                "SELECT id" +
                "FROM ingredient " +
                "WHERE name = ?;";
        return jdbcTemplate.query(ingredientIdByName, new IngredientRowMapper(),name).stream().findFirst();
    }

    @Override
    public int updateIngredientPrice(UUID id, Ingredient ingredient) {
        String updateIngredient =
                "UPDATE ingredient " +
                "SET currentPrice = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(updateIngredient, ingredient.getCurrentPrice(), id);
    }

    @Override
    public int updateIngredientName(UUID id, Ingredient ingredient) {
        String updateIngredient =
                "UPDATE ingredient " +
                "SET name = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(updateIngredient, ingredient.getName(), id);
    }

    @Override
    public Optional<Ingredient> getIngredientNameById(UUID id) {
        String IngredientNameById =
                "SELECT name as name " +
                        "FROM ingredient " +
                        "WHERE id = ?;";
        return jdbcTemplate.query(IngredientNameById, new IngredientRowMapper(),id).stream().findFirst();
    }

    @Override
    public int deleteIngredient(UUID id){
        String deleteIngredient = "DELETE FROM ingredient WHERE id = ? ";
        return jdbcTemplate.update(deleteIngredient, id);
    }

}
