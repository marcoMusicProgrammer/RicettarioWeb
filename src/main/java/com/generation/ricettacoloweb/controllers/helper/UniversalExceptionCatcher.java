package com.generation.ricettacoloweb.controllers.helper;

import com.generation.ricettacoloweb.exceptions.AuthorException;
import com.generation.ricettacoloweb.exceptions.RecipeException;
import com.generation.ricettacoloweb.exceptions.RecipeTypologyException;
import com.generation.ricettacoloweb.exceptions.ShowAllRecipeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UniversalExceptionCatcher
{
	@ExceptionHandler(ShowAllRecipeException.class)
	public String invalidType(ShowAllRecipeException ex)
	{
		return "redirect:/showAll?invalidType=true";
	}

	@ExceptionHandler(RecipeException.class)
	public String invalidIngredients(RecipeException ex)
	{
		return "redirect:/recipesForIngredients?invalidIngredient=true";
	}

	@ExceptionHandler(AuthorException.class)
	public String invalidIngredients(AuthorException ex)
	{
		return "redirect:/recipeForAuthor?invalidAuthor=true";
	}

	@ExceptionHandler(RecipeTypologyException.class)
	public String invalidTypologyException(RecipeTypologyException ex)
	{
		return "redirect:/recipesByTypology?invalidTypology=true";
	}

}
