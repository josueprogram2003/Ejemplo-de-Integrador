package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	                        resultSet.getString("dni"),
	                        resultSet.getInt("idescuela")
	                		)
	        );
	    }
	  
	  
	  public List<Map<String, Object>> findALLID() {
	        String query = "select p.id, p.nombres,p.apellidos, e.nombre as escuela from persona p join escuela e ON p.idescuela = e.id where e.id = 3;";
	       //   List<Map<String, Object>> lista = new ArrayList<>();
	        return jdbcTemplate.query(query, (resultSet, rowNum) -> {
	            Map<String, Object> mapa = new HashMap<>();
	            mapa.put("id", resultSet.getInt("id"));
	            mapa.put("nombres", resultSet.getString("nombres"));
	            mapa.put("apellidos", resultSet.getString("apellidos"));
	            mapa.put("escuela", resultSet.getString("escuela"));
	            return mapa;
	        });
	    }
	 
	   public void save(Persona persona) {
	        String sql = "INSERT INTO persona (nombres, apellidos,dni,idescuela) VALUES (?,?,?,?)";
	        jdbcTemplate.update(sql, persona.getNombres(), persona.getApellidos(),persona.getDni(),persona.getIdescuela());
	    }
	 
	   
	   public void delete(int id) {
	        String sql = "DELETE FROM persona WHERE id = ?";
	        jdbcTemplate.update(sql, id);
	    }
	   
	   
	   public void update(Persona persona) {
	        String sql = "UPDATE persona  SET nombres = ?, apellidos = ?, dni= ?, idescuela = ?  WHERE id = ?";
	        jdbcTemplate.update(sql, persona.getNombres(), persona.getApellidos(), persona.getDni(),persona.getId(),persona.getIdescuela());
	   }
	   
	   public Persona findById(int id) {
	        String sql = "SELECT * from persona  WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) ->
	                new Persona(
	                		resultSet.getInt("id"),
	                        resultSet.getString("nombres"),
	                        resultSet.getString("apellidos"),
	                        resultSet.getString("dni"),
	                        resultSet.getInt("idescuela")
	                )
	        );
	    }
	   
}
