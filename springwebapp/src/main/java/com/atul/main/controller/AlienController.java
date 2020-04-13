package com.atul.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.atul.main.entity.Alien;
import com.atul.main.service.AlienDAO;

@Controller
public class AlienController {
	
	
	@Autowired
	AlienDAO adao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		adao.save(alien);
		return "home";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mView = new ModelAndView();
		//inbuilt method of CrudRepository interface - findById()
		Alien alien101 = adao.findById(aid).orElse(new Alien());
		mView.setViewName("AlienList");
		mView.addObject("result", alien101);
		return mView;
	}
		
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAlliens() {
		
		System.out.println(adao.findByAidGreaterThan(102));
		
		System.out.println(adao.findByTechSorted("Drawing"));
		
		return adao.findAll();		
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAllien(@PathVariable("aid") int aid) {
		
		return adao.findById(aid);	
	}
	
}
