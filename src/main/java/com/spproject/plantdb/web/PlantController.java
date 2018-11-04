package com.spproject.plantdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spproject.plantdb.domain.FertilizerType;
import com.spproject.plantdb.domain.FertilizerTypeRepository;
import com.spproject.plantdb.domain.LightType;
import com.spproject.plantdb.domain.LightTypeRepository;
import com.spproject.plantdb.domain.Plant;
import com.spproject.plantdb.domain.PlantRepository;
import com.spproject.plantdb.domain.WaterType;
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

	// Login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Show all plants
	@RequestMapping(value = "/home")
	public String home(Model model) {
		model.addAttribute("plants", prepo.findAll());
		return "home";
	}

	// Sort by English name
	@RequestMapping(value = "/sorteng")
	public String sorteng(Model model) {
		model.addAttribute("plants", prepo.findAllByOrderByEngNameAsc());
		return "home";
	}

	// Sort by Latin name
	@RequestMapping(value = "/sortlat")
	public String sortlat(Model model) {
		model.addAttribute("plants", prepo.findAllByOrderByLatNameAsc());
		return "home";
	}

	// Sort By Finnish name
	@RequestMapping(value = "/sortfin")
	public String sortfin(Model model) {
		model.addAttribute("plants", prepo.findAllByOrderByFinNameAsc());
		return "home";
	}

	// Search plants by any attribute except repotDate
	@GetMapping(value = "/search")
	public String searchName(@RequestParam(name = "searchterm") String searchterm, Model model) {
		String term1 = searchterm;
		String term2 = searchterm;
		String term3 = searchterm;
		String term4 = searchterm;
		String term5 = searchterm;
		String term6 = searchterm;
		model.addAttribute("plants", prepo
				.findByEngNameIgnoreCaseContainingOrLatNameIgnoreCaseContainingOrFinNameIgnoreCaseContainingOrWtype_NameIgnoreCaseContainingOrLtype_NameIgnoreCaseContainingOrFtype_NameIgnoreCaseContaining(
						term1, term2, term3, term4, term5, term6));
		return "home";
	}

	// Add new plant
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addplant")
	public String addPlant(Model model) {
		model.addAttribute("plant", new Plant());
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "addplant";
	}

	// Edit a plant
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}")
	public String editPlant(@PathVariable("id") Long plantId, Model model) {
		model.addAttribute("plant", prepo.findById(plantId));
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "editplant";
	}

	// Show all types
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/types")
	public String types(Model model) {
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "types";
	}

	// Edit types
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edittypes/{id}")
	public String editTypes(@PathVariable("id") Long waterId, @PathVariable("id") Long lightId,
			@PathVariable("id") Long fertilizerId, Model model) {
		model.addAttribute("wtype", wrepo.findById(waterId));
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltype", lrepo.findById(lightId));
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftype", frepo.findById(fertilizerId));
		model.addAttribute("ftypes", frepo.findAll());
		return "edittypes";
	}

	// Add new type
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addtypes")
	public String addType(Model model) {
		model.addAttribute("wtype", new WaterType());
		model.addAttribute("ltype", new LightType());
		model.addAttribute("ftype", new FertilizerType());
		return "addtypes";
	}

	// Save a water type
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/savewater", method = RequestMethod.POST)
	public String savetype(WaterType wtype) {
		wrepo.save(wtype);
		return "redirect:home";
	}

	// Save a light type
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/savelight", method = RequestMethod.POST)
	public String savetype(LightType ltype) {
		lrepo.save(ltype);
		return "redirect:home";
	}

	// Save a fertilizer type
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/savefertilizer", method = RequestMethod.POST)
	public String savetype(FertilizerType ftype) {
		frepo.save(ftype);
		return "redirect:home";
	}

	// Delete a plant
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePlant(@PathVariable("id") Long plantId, Model model) {
		prepo.deleteById(plantId);
		return "redirect:../home";
	}

	// Save a plant
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Plant plant) {

		String engName = plant.getEngName();
		String engName2 = engName.substring(0, 1).toUpperCase() + engName.substring(1);
		plant.setEngName(engName2);

		String latName = plant.getLatName();
		String latName2 = latName.substring(0, 1).toUpperCase() + latName.substring(1);
		plant.setLatName(latName2);

		String finName = plant.getFinName();
		String finName2 = finName.substring(0, 1).toUpperCase() + finName.substring(1);
		plant.setFinName(finName2);

		prepo.save(plant);
		return "redirect:home";
	}
}
