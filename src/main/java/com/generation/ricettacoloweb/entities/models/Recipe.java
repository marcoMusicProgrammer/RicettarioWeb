package com.generation.ricettacoloweb.entities.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Recipe extends BasicEntity
{
	String name,author,type,image_url;
	Integer difficulty,time;

	@ManyToMany
	@JoinTable(
			name = "recipe_ingredient",
			joinColumns = @JoinColumn(name="recipe_id"),
			inverseJoinColumns = @JoinColumn(name="ingredient_id")
	)

	private List<Ingredient> ingredients;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getImage_url()
	{
		return image_url;
	}

	public void setImage_url(String image_url)
	{
		this.image_url = image_url;
	}

	public Integer getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty(Integer difficulty)
	{
		this.difficulty = difficulty;
	}

	public Integer getTime()
	{
		return time;
	}

	public void setTime(Integer time)
	{
		this.time = time;
	}

	public List<Ingredient> getIngredients()
	{
		List<Ingredient> newListIngredients = new ArrayList<Ingredient>(this.ingredients);
		return newListIngredients;
	}

	public void setIngredients(List<Ingredient> ingredients)
	{
		this.ingredients = ingredients;
	}
}
