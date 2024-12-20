package com.generation.ricettacoloweb.controllers;

import com.generation.ricettacoloweb.controllers.helper.ControllerHelper;
import com.generation.ricettacoloweb.entities.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/allRecipes")
public class AllRecipes
{
	@Autowired
	ControllerHelper helper;

	@GetMapping
	public String allRecipes(Model model)
	{
		List<Recipe> recipeList = helper.getAllRecipes();
		model.addAttribute("recipes", recipeList);
		model.addAttribute("title", "All Recipes");
		return "showAllRecipes";
	}

	@GetMapping("/findBy")
	public String allRecipes(Model model, @RequestParam String scelta)
	{
		List<Recipe> recipeList = helper.getRecipesByOptions(scelta);
		model.addAttribute("title", "All Recipes");
		model.addAttribute("recipes", recipeList);
		return "showAllRecipes";
	}

}
