package com.generation.ricettacoloweb.controllers.helper;

import com.generation.ricettacoloweb.entities.models.Ingredient;
import com.generation.ricettacoloweb.entities.models.Recipe;

import java.util.List;

public interface Helper
{
	List<Recipe> getAllRecipes();
	List<Recipe> getRecipesByDifficulty();

	Ingredient getIngredientByName(String name);
	List<Recipe> getRecipeByIngredientsName(String name,String option);
}
