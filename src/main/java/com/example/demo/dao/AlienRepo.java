package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

//public interface AlienRepo extends CrudRepository<Alien, Integer> {
//JPA Repo for JSON
public interface AlienRepo extends JpaRepository<Alien, Integer> {

//	List<Alien> findByaTech(String tech);
//	
//	List<Alien> findByaIdGreaterThan(int id);
//	
//	@Query("from Alien where aTech=?1 order by aName desc")
//	List<Alien> findByaTechSorted(String tech);
}
