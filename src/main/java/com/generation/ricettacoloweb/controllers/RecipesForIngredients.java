package com.generation.ricettacoloweb.controllers;

import com.generation.ricettacoloweb.controllers.helper.ControllerHelper;
import com.generation.ricettacoloweb.entities.models.Recipe;
import com.generation.ricettacoloweb.entities.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/recipesForIngredients")
public class RecipesForIngredients
{
	@Autowired
	ControllerHelper helper;

	@GetMapping
	public String recipeForIngredient(Model model, @RequestParam(defaultValue = "false",required = false) boolean invalidIngredient)
	{
		model.addAttribute("invalidIngredient", invalidIngredient);
		model.addAttribute("title","Recipes for Ingredients");
		return "recipesForIngredient";
	}

	@GetMapping("/findBy")
	public String recipesForIngredients(@RequestParam String ingredient_value, Model model)
	{
		List<Recipe> recipeList = helper.getRecipeByIngredientsName(ingredient_value);
		model.addAttribute("recipes", recipeList);
		model.addAttribute("title","Recipes for Ingredients");

		return "recipesForIngredient";
	}
}
