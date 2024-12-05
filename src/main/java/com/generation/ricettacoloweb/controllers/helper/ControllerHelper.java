package com.generation.ricettacoloweb.controllers.helper;

import com.generation.ricettacoloweb.entities.models.Ingredient;
import com.generation.ricettacoloweb.entities.models.Recipe;
import com.generation.ricettacoloweb.entities.repositories.IngredientRepository;
import com.generation.ricettacoloweb.entities.repositories.RecipeRepository;
import com.generation.ricettacoloweb.exceptions.RecipeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ControllerHelper implements Helper
{
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private RecipeRepository recipeRepository;

	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	@Override
	public List<Recipe> getRecipesByDifficulty()
	{
		List<Recipe> recipeAsc = recipeRepository.findAllByOrderByDifficultyAsc();
		return recipeAsc;
	}

	public Ingredient getIngredientByName(String name)
	{
		Ingredient ingredient = ingredientRepository.getIngredientsByName(name);
		return ingredient;
	}

	public List<Recipe> getRecipeByIngredientsName(String name)
	{
		Ingredient ingredient = null;
		try
		{
			ingredient = ingredientRepository.getIngredientsByName(name);
		} catch (Exception e)
		{
			throw new RecipeException();
		}
		List<Recipe> recipeByIngredientsName = new ArrayList<>();

		for(Recipe r : getAllRecipes())
		{
			if(r.getIngredients().contains(ingredient))
				recipeByIngredientsName.add(r);

		}

		if(recipeByIngredientsName.isEmpty())
			throw new RecipeException();

		return recipeByIngredientsName;
	}



}
