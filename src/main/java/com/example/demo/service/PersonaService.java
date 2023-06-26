package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Persona;

public interface PersonaService {
	
	public List<Persona> readAll();
	public Persona findById(int id);
	public void save(Persona persona);
	public void delete(int id);
	public void update(Persona persona);
}
