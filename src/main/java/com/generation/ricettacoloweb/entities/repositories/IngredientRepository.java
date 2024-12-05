package com.generation.ricettacoloweb.entities.repositories;

import com.generation.ricettacoloweb.entities.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>
{
	Ingredient getIngredientsByName(String name);
}
