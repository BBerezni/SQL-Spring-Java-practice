package com.example.kitchen_vezba.controllers;

import com.example.kitchen_vezba.model.Ingredient;
import com.example.kitchen_vezba.repository.Interfaces.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class IngredientsActionController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientsActionController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @PostMapping("/api/ingredients/insert")
    public void insertIngredient(@RequestBody Ingredient ingredient){
        ingredientRepository.insertIngredient(ingredient);
    }

    @PatchMapping("/api/ingredients/{id}/price")
    public int updateIngredientPrice(@Valid @RequestBody Ingredient ingredient, @PathVariable("id") UUID id){
        return ingredientRepository.updateIngredientPrice(id, ingredient);
    }

    @PutMapping("/api/ingredients/{id}/name")
    public int updateIngredientName(@Valid @RequestBody Ingredient ingredient, @PathVariable("id") UUID id){
        return ingredientRepository.updateIngredientName(id, ingredient);
    }

    @DeleteMapping("/api/ingredients/delete/{id}")
    public void deleteIngredient(@PathVariable("id") UUID id){
        ingredientRepository.deleteIngredient(id);
    }
}
