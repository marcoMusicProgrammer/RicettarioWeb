package com.generation.ricettacoloweb.controllers.helper;

import com.generation.ricettacoloweb.exceptions.RecipeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UniversalExceptionCatcher
{
	@ExceptionHandler(RecipeException.class)
	public String invalidIngredients(RecipeException ex)
	{
		return "redirect:/recipesForIngredients?invalidIngredient=true";
	}
}