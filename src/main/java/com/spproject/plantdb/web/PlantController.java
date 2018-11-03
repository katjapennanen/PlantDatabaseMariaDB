package com.spproject.plantdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spproject.plantdb.domain.FertilizerTypeRepository;
import com.spproject.plantdb.domain.LightTypeRepository;
import com.spproject.plantdb.domain.Plant;
import com.spproject.plantdb.domain.PlantRepository;
import com.spproject.plantdb.domain.WaterTypeRepository;

@Controller
public class PlantController {
	
	@Autowired
	private PlantRepository prepo;
	@Autowired
	private WaterTypeRepository wrepo;
	@Autowired
	private LightTypeRepository lrepo;
	@Autowired
	private FertilizerTypeRepository frepo;
	
	// Login page listener
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }

	// Show all plants
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("plants", prepo.findAll());
		return "home";
	}

	// Add new plant
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addplant")
	public String addPlant(Model model) {
		model.addAttribute("plant", new Plant());
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "addplant";
	}

	// Edit a plant
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}")
	public String editPlant(@PathVariable("id") Long plantId, Model model) {
		model.addAttribute("plant", prepo.findById(plantId));
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "editplant";
	}

	// Delete a plant
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePlant(@PathVariable("id") Long plantId, Model model) {
		prepo.deleteById(plantId);
		return "redirect:../home";
	}

	// Save a plant
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Plant plant) {
		prepo.save(plant);
		return "redirect:home";
	}
}

