package org.spring.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.spring.italy.demo.pojo.TravelPlace;
import org.spring.italy.demo.serv.TravelPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping()
public class MainController {

	@Autowired
	private TravelPlaceService tpServ;
	
	
	@GetMapping("/")
	public String getIndex(Model model) {
		
		List<TravelPlace> tps = tpServ.findAll();
		model.addAttribute("tps", tps);
		
		return "travel-places";
	}
	
	@GetMapping("/travel-place/{id}")
	public String getTravelPlaceById(@PathVariable("id") int id, Model model) {
		
		Optional<TravelPlace> tpOpt = tpServ.getTpById(id);
		if(tpOpt.isEmpty()) {
			
			System.out.println("No travel place with the following id: " + id);
		}
		
		TravelPlace tp = tpOpt.get();
		model.addAttribute("tp", tp);
		
		return "travel-place";
	}
	

	@GetMapping("/travel-place/create")
	public String createTravelPlace(Model model) {
		
		TravelPlace tp = new TravelPlace();
		model.addAttribute("tp", tp);
		
		return "create-travel-place";
	}
	
	@PostMapping("/travel-place/create")
	public String storeTravelPlace(TravelPlace tp) {
		
		tpServ.save(tp);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/travel-place/update/{id}")
	public String editTravelPlace(@PathVariable("id") int id, Model model) {
		
		Optional<TravelPlace> tpOpt = tpServ.getTpById(id);
		TravelPlace tp = tpOpt.get();
		
		model.addAttribute("tp", tp);
		
		return "update-travel-place";
	}
	
	@PostMapping("/travel-place/store")
	public String updateTravelPlace(@Valid TravelPlace tp) {
		
		tpServ.save(tp);
		
		return "redirect:/";
	}
	
	@GetMapping("/travel-place/delete/{id}")
	public String deleteTravelPlace(@PathVariable("id") int id) {
		
		Optional<TravelPlace> tpOpt = tpServ.getTpById(id);
		TravelPlace tp = tpOpt.get();
		
		tpServ.delete(tp);
		
		return "redirect:/";
	}
	
}
