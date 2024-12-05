package com.generation.ricettacoloweb.entities.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Ingredient extends BasicEntity
{
	String name;

	@ManyToMany (mappedBy = "ingredients")
	private List<Recipe> recipeList = new ArrayList<>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Recipe> getRecipeList()
	{
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList)
	{
		this.recipeList = recipeList;
	}
}
