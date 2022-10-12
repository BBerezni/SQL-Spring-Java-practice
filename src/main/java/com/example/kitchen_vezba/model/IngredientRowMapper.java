package com.example.kitchen_vezba.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientRowMapper implements RowMapper<Ingredient> {

    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getObject("id", java.util.UUID.class),
                rs.getString("name"),
                rs.getDouble("currentPrice"));
    }
}
