package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Persona;

@Repository
public class PersonaRepository {
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
		
	  public PersonaRepository(JdbcTemplate jdbcTemplate) {
		  this.jdbcTemplate = jdbcTemplate;
	  }
	 
	  public List<Persona> findAll() {
	        String sql = "SELECT * from persona";
	        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
	                new Persona(
	                        resultSet.getInt("id"),
	                        resultSet.getString("nombres"),
	                        resultSet.getString("apellidos"),
	                        resultSet.getString("dni")
	                )
	        );
	    }
	 
	   public void save(Persona persona) {
	        String sql = "INSERT INTO persona (nombres, apellidos,dni) VALUES (?,?,?)";
	        jdbcTemplate.update(sql, persona.getNombres(), persona.getApellidos(),persona.getDni());
	    }
	 
	   
	   public void delete(int id) {
	        String sql = "DELETE FROM persona WHERE id = ?";
	        jdbcTemplate.update(sql, id);
	    }
	   
	   
	   public void update(Persona persona) {
	        String sql = "UPDATE persona  SET nombres = ?, apellidos = ?, dni= ?  WHERE id = ?";
	        jdbcTemplate.update(sql, persona.getNombres(), persona.getApellidos(), persona.getDni(),persona.getId());
	   }
	   
	   public Persona findById(int id) {
	        String sql = "SELECT * from persona  WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) ->
	                new Persona(
	                		resultSet.getInt("id"),
	                        resultSet.getString("nombres"),
	                        resultSet.getString("apellidos"),
	                        resultSet.getString("dni")
	                )
	        );
	    }
	   
}
