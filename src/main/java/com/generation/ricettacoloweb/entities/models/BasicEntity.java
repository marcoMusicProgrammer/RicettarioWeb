package com.generation.ricettacoloweb.entities.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BasicEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
}
