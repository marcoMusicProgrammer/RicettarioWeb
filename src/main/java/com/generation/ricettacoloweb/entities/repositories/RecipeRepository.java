package com.generation.ricettacoloweb.entities.repositories;

import com.generation.ricettacoloweb.entities.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long>
{
	//    findAllByOrderBy[NOME_CAMPO][Asc/Desc]
	List<Recipe> findAllByOrderByDifficultyAsc();
	List<Recipe> findAllByOrderByDifficultyDesc();

	List<Recipe> findAllByOrderByTimeAsc();
	List<Recipe> findAllByOrderByTimeDesc();

	List<Recipe> getRecipeByAuthor(String name);

	List <Recipe> findByAuthor(String author);
	List<Recipe> getRecipeByType(String typology);
}
