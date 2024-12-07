package com.generation.ricettacoloweb.controllers.helper;

import com.generation.ricettacoloweb.entities.models.Ingredient;
import com.generation.ricettacoloweb.entities.models.Recipe;
import com.generation.ricettacoloweb.entities.repositories.IngredientRepository;
import com.generation.ricettacoloweb.entities.repositories.RecipeRepository;
import com.generation.ricettacoloweb.exceptions.AuthorException;
import com.generation.ricettacoloweb.exceptions.RecipeException;
import com.generation.ricettacoloweb.exceptions.RecipeTypologyException;
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
        return recipeRepository.findAllByOrderByDifficultyAsc();
	}

	public List<Recipe> getRecipesByTime()
	{
        return recipeRepository.findAllByOrderByTimeAsc();
	}

	public String getRecipeByAuthor(String author)
	{
        List<Recipe> recipes = new ArrayList<>(recipeRepository.findByAuthor(author));

        return recipes.getFirst().getAuthor();
	}

	public Ingredient getIngredientByName(String name)
	{
        return ingredientRepository.getIngredientsByName(name);
	}

	@Override
	public List<Recipe> getRecipeByIngredientsName(String name, String option)
	{
		Ingredient ingredient = null;
		try
		{
			ingredient = ingredientRepository.getIngredientsByName(name);
		} catch (Exception e)
		{
			System.out.println("erroe");
			throw new RecipeException();
		}
		List<Recipe> recipeByIngredientsName = new ArrayList<>();

		switch(option) {
			case "blank" -> {
				for (Recipe r : getAllRecipes()) {
					if (r.getIngredients().contains(ingredient))
						recipeByIngredientsName.add(r);
				}
			}
			case "difficulty" -> {
				for (Recipe r : getRecipesByDifficulty()) {
					if (r.getIngredients().contains(ingredient))
						recipeByIngredientsName.add(r);
				}
			}
			case "time" -> {
				for (Recipe r : getRecipesByTime()) {
					if (r.getIngredients().contains(ingredient))
						recipeByIngredientsName.add(r);
				}
			}
		}

		if(recipeByIngredientsName.isEmpty())
			throw new RecipeException();

		return recipeByIngredientsName;
	}

	public List<Recipe> getRecipeByAuthorsName(String name, String option)
	{
		List<Recipe> recipe = null;
		try
		{
			recipe = recipeRepository.getRecipeByAuthor(name);

		} catch (Exception e)
		{
			throw new AuthorException();
		}

		List<Recipe> recipeByAuthorsName = new ArrayList<>();

		switch(option) {
			case "blank" -> {
				for (Recipe r : getAllRecipes()) {
					try {
						if (r.getAuthor().equals(recipe.getFirst().getAuthor()))
							recipeByAuthorsName.add(r);
					} catch (Exception e)
					{
						throw new AuthorException();
					}
				}
			}
			case "difficulty" -> {
				try
				{
					for (Recipe r : getRecipesByDifficulty()) {
						if (r.getAuthor().equals(recipe.getFirst().getAuthor()))
							recipeByAuthorsName.add(r);
					}
				} catch (Exception e)
				{
					throw new AuthorException();
				}
			}
			case "time" -> {
				try
				{
					for (Recipe r : getRecipesByTime()) {
						if (r.getAuthor().equals(recipe.getFirst().getAuthor()))
							recipeByAuthorsName.add(r);
					}
				} catch (Exception e)
				{
					throw new AuthorException();
				}
			}
		}


		if(recipeByAuthorsName.isEmpty())
			throw new AuthorException();

		return recipeByAuthorsName;
	}

	public List<Recipe> getRecipeByTypology(String typology, String option)
	{
		List<Recipe> recipe = null;

		try
		{
			recipe = recipeRepository.getRecipeByType(typology);
		} catch (Exception e) {
			throw new RecipeTypologyException();
		}

		List<Recipe> recipeByTypology = new ArrayList<>();

		switch(option)
		{
			case "blank" -> {
				try {
					for (Recipe r : getAllRecipes()) {
						if (r.getType().equals(recipe.getFirst().getType()))
							recipeByTypology.add(r);
					}
				} catch (Exception e)
				{
					throw new RecipeTypologyException();
				}
			}
			case "difficulty" -> {
				try
				{
					for (Recipe r : getRecipesByDifficulty()) {
						if(r.getType().equals(recipe.getFirst().getType()))
							recipeByTypology.add(r);
					}
				} catch (Exception e)
				{
					throw new RecipeTypologyException();
				}
			}
			case "time" -> {
				try
				{
					for (Recipe r : getRecipesByTime()) {
						if(r.getType().equals(recipe.getFirst().getType()))
							recipeByTypology.add(r);
					}
				} catch (Exception e)
				{
					throw new RecipeTypologyException();
				}
			}
		}

		return recipeByTypology;
	}

	public List<Recipe> getRecipesByOptions(String option)
	{
		List<Recipe> recipeList = new ArrayList<>();

		switch(option)
		{
			case "blank" -> {
				for (Recipe r : getAllRecipes())
					recipeList.add(r);
			}
			case "difficulty" -> {
				for(Recipe r : getRecipesByDifficulty())
					recipeList.add(r);
			}
			case "time" -> {
				for (Recipe r : getRecipesByTime())
					recipeList.add(r);
			}

		}
		if(recipeList.isEmpty())
			throw new RecipeException();

		return recipeList;

	}


}














