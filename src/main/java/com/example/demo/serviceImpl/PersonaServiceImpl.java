package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	
	@Autowired
	private PersonaRepository personarepository;

	@Override
	public List<Persona> readAll() {
		return personarepository.findAll();
	}

	@Override
	public void save(Persona persona) {
		 personarepository.save(persona);
	}

	@Override
	public void delete(int id) {
		personarepository.delete(id);		
	}

	@Override
	public void update(Persona persona) {
		personarepository.update(persona);
		
	}

	@Override
	public Persona findById(int id) {
		return personarepository.findById(id);
	}
	
}
