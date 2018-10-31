package com.spproject.plantdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spproject.plantdb.domain.Names;
import com.spproject.plantdb.domain.Needs;
import com.spproject.plantdb.domain.Plant;
import com.spproject.plantdb.domain.PlantRepository;

@Controller
@RequestMapping("/")
public class PlantController {
	@Autowired
	private PlantRepository prepo;

	public PlantController(PlantRepository prepo) {
		this.prepo = prepo;
	}

	// Show all plants
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("plantList", prepo.findAll());
		return "home";
	}

	// Add new plant
	@RequestMapping(value = "/addplant")
	public String addBook(Model model) {
		model.addAttribute("plant", new Plant());
		model.addAttribute("names", prepo.findAll());
		model.addAttribute("needs", prepo.findAll());
		return "addplant";
	}

	// Not in use
	@RequestMapping(value = "/addplantaaaaa", method = RequestMethod.POST)
	public String addPlant(Names names, Needs needs, String repotDate) {
		prepo.save(new Plant(names, needs, repotDate));
		return "redirect:home";
	}

	// Edit a plant
	@RequestMapping(value = "/edit/{id}")
	public String editPlant(@PathVariable("id") String Id, Model model) {
		model.addAttribute("plant", prepo.findById(Id));
		model.addAttribute("names", prepo.findById(Id));
		model.addAttribute("needs", prepo.findById(Id));
		return "editplant";
	}

	// Delete a plant
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePlant(@PathVariable("id") String Id, Model model) {
		prepo.deleteById(Id);
		return "redirect:../home";
	}

	// Save a plant
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Plant plant) {
		prepo.save(plant);
		return "redirect:home";
	}
}

