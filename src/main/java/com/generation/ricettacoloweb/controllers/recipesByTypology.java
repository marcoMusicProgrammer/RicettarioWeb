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
@RequestMapping("/recipesByTypology")
public class recipesByTypology
{

    @Autowired
    private ControllerHelper helper;

    @GetMapping
    public String getRecipesByTypology(Model model, @RequestParam(defaultValue = "false", required = false) Boolean invalidTypology)
    {
        model.addAttribute("invalidTypology", invalidTypology);
        model.addAttribute("title", "Recipes By Typology");
        return "recipesByTypology";
    }

    @GetMapping("/findBy")
    public String findByTypology(Model model, @RequestParam String scelta,@RequestParam String recipe_typology)
    {
        List<Recipe> recipeList =  helper.getRecipeByTypology(recipe_typology, scelta);
        model.addAttribute("title", "Recipes By Typology");
        model.addAttribute("recipes", recipeList);
        return "recipesByTypology";
    }
}
