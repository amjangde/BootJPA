package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

//@Controller

// To config a controller specific to REST services
@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	/*
	 * @RequestMapping("/addAlien") public String addAlien(Alien alien) {
	 * repo.save(alien); return "home.jsp"; }
	 */
	
//	@RequestMapping("/getAlien")
//	public ModelAndView addAlien(@RequestParam int aId)
//	{
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Alien alien = repo.findById(aId).orElse(new Alien());
//		
//		//Find by custom method or query
////		System.out.println(repo.findByaTech("Java"));
////		System.out.println(repo.findByaIdGreaterThan(100));
////		System.out.println(repo.findByaTechSorted("Java"));
//		
////		List<Alien> alien2 = repo.findByaTech("Java");
//		
//		mv.addObject(alien);
//		return mv;
//	}
	
	//REST API
	
	@PostMapping(path="/alien", consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aId}")
	public String deleteAlien(@PathVariable int aId)
	{
		Alien alien = repo.getOne(aId);
		repo.delete(alien);
		return "Deleted";
	}
	
	@PutMapping(path="/alien")
	public Alien putAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
//	@RequestMapping(path="/aliens", produces= {"application/xml"})
	@RequestMapping(path="/aliens")
//	@ResponseBody - No need to use this for RestController
	public List<Alien> getAliens()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{aId}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aId")int aId)
	{
		return repo.findById(aId);
	}
}
