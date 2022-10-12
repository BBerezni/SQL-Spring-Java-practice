package com.example.kitchen_vezba.controllers;

import com.example.kitchen_vezba.model.Ingredient;
import com.example.kitchen_vezba.repository.Interfaces.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class IngredientQueryController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientQueryController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/api/ingredients/all")
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.getAllIngredients();
    }

    @GetMapping("/api/ingredients/{id}")
    public Ingredient getIngredientById(@PathVariable ("id") UUID id){
        return ingredientRepository.getIngredientById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    @GetMapping("/api/ingredients/{name}/id")
    public Ingredient getIngredientIdByName(@PathVariable ("name") String name){
        return ingredientRepository.getIngredientIdByName(name)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    @GetMapping("/api/ingredients/{id}/name")
    public Ingredient getIngredientNameById(@PathVariable ("id") UUID id){
        return ingredientRepository.getIngredientNameById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

}
