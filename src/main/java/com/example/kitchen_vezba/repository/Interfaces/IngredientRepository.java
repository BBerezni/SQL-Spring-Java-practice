package com.example.kitchen_vezba.repository.Interfaces;

import com.example.kitchen_vezba.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IngredientRepository {
    List<Ingredient> getAllIngredients();

    int insertIngredient(UUID id, Ingredient ingredient);

    default int insertIngredient(Ingredient ingredient){
        UUID id = UUID.randomUUID();
        return insertIngredient(id, ingredient);
    }

    Optional<Ingredient> getIngredientById(UUID id);

    Optional<Ingredient> getIngredientIdByName(String name);

    int updateIngredientPrice(UUID id, Ingredient ingredient);

    int updateIngredientName(UUID id, Ingredient ingredient);

    Optional<Ingredient> getIngredientNameById(UUID id);

    int deleteIngredient(UUID id);
}
