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
@RequestMapping("/recipeForAuthor")
public class RecipeForAuthor
{
    @Autowired
    private ControllerHelper helper;

    @GetMapping
    public String recipeForAuthor(Model model, @RequestParam (defaultValue = "false",required = false) Boolean invalidIngredient)
    {
        model.addAttribute("invalidIngredient", invalidIngredient);
        model.addAttribute("title", "Recipe for Author");
        return "recipeForAuthor";
    }

    @GetMapping("/findBy")
    public String recipeForAuthor(Model model, @RequestParam String author_value)
    {
        List<Recipe> recipeList= helper.getRecipeByAuthorsName(author_value);
        model.addAttribute("recipes", recipeList);
        model.addAttribute("title", "Recipe for Author");
        return "recipeForAuthor";
    }
}
