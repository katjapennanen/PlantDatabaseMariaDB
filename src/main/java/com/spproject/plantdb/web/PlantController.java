package com.spproject.plantdb.web;

import org.springframework.beans.factory.annotation.Autowired;
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

	boolean ascOrDesc = true;

	@Autowired
	private PlantRepository prepo;
	@Autowired
	private WaterTypeRepository wrepo;
	@Autowired
	private LightTypeRepository lrepo;
	@Autowired
	private FertilizerTypeRepository frepo;


	// Show all plants
	@RequestMapping(value = "/home")
	public String home(Model model) {
		model.addAttribute("plants", prepo.findAll());
		return "home";
	}

	// Cancel action
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel() {
		return "redirect:home";
	}

	// Cancel type edit
	@RequestMapping(value = "/canceledit", method = RequestMethod.GET)
	public String cancelEdit() {
		return "redirect:types";
	}

	// Sort by English name
	@RequestMapping(value = "/sorteng")
	public String sorteng(Model model) {
		if (ascOrDesc) {
			ascOrDesc = false;
			model.addAttribute("plants", prepo.findAllByOrderByEngnameAsc());
		} else {
			ascOrDesc = true;
			model.addAttribute("plants", prepo.findAllByOrderByEngnameDesc());
		}
		return "home";
	}

	// Sort by Latin name
	@RequestMapping(value = "/sortlat")
	public String sortlat(Model model) {
		if (ascOrDesc) {
			ascOrDesc = false;
			model.addAttribute("plants", prepo.findAllByOrderByLatnameAsc());
		} else {
			ascOrDesc = true;
			model.addAttribute("plants", prepo.findAllByOrderByLatnameDesc());
		}
		return "home";
	}

	// Sort by Finnish name
	@RequestMapping(value = "/sortfin")
	public String sortfin(Model model) {
		if (ascOrDesc) {
			ascOrDesc = false;
			model.addAttribute("plants", prepo.findAllByOrderByFinnameAsc());
		} else {
			ascOrDesc = true;
			model.addAttribute("plants", prepo.findAllByOrderByFinnameDesc());
		}
		return "home";
	}

	// Sort by water
	@RequestMapping(value = "/sortwater")
	public String sortwater(Model model) {
		if (ascOrDesc) {
			ascOrDesc = false;
			model.addAttribute("plants", prepo.findAllByOrderByLightid_NameAsc());
		} else {
			ascOrDesc = true;
			model.addAttribute("plants", prepo.findAllByOrderByWaterid_NameDesc());
		}
		return "home";
	}

	// Sort by fertilizer
	@RequestMapping(value = "/sortfertilizer")
	public String sortfertilizer(Model model) {
		if (ascOrDesc) {
			ascOrDesc = false;
			model.addAttribute("plants", prepo.findAllByOrderByFertilizerid_NameAsc());
		} else {
			ascOrDesc = true;
			model.addAttribute("plants", prepo.findAllByOrderByFertilizerid_NameDesc());
		}
		return "home";
	}

	// Sort by light
	@RequestMapping(value = "/sortlight")
	public String sortlight(Model model) {
		if (ascOrDesc) {
			ascOrDesc = false;
			model.addAttribute("plants", prepo.findAllByOrderByLightid_NameAsc());
		} else {
			ascOrDesc = true;
			model.addAttribute("plants", prepo.findAllByOrderByLatnameDesc());
		}
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
		String term7 = searchterm;
		model.addAttribute("plants", prepo
				.findByEngnameIgnoreCaseContainingOrLatnameIgnoreCaseContainingOrFinnameIgnoreCaseContainingOrWaterid_NameIgnoreCaseContainingOrLightid_NameIgnoreCaseContainingOrFertilizerid_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
						term1, term2, term3, term4, term5, term6, term7));
		return "home";
	}

	// Add a new plant
	@RequestMapping(value = "/addplant")
	public String addPlant(Model model) {
		model.addAttribute("plant", new Plant());
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "addplant";
	}

	// Edit a plant
	@RequestMapping(value = "/edit/{id}")
	public String editPlant(@PathVariable("id") Long plantId, Model model) {
		model.addAttribute("plant", prepo.findById(plantId));
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "editplant";
	}

	// Show all types
	@RequestMapping(value = "/types")
	public String types(Model model) {
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		model.addAttribute("wtype", new WaterType());
		model.addAttribute("ltype", new LightType());
		model.addAttribute("ftype", new FertilizerType());
		return "types";
	}

	// Edit types
	@RequestMapping(value = "/types/{id}")
	public String editTypes(@PathVariable("id") Long waterId, @PathVariable("id") Long lightId,
			@PathVariable("id") Long fertilizerId, Model model) {
		model.addAttribute("wtype", wrepo.findById(waterId));
		model.addAttribute("ltype", lrepo.findById(lightId));
		model.addAttribute("ftype", frepo.findById(fertilizerId));
		model.addAttribute("wtypes", wrepo.findAll());
		model.addAttribute("ltypes", lrepo.findAll());
		model.addAttribute("ftypes", frepo.findAll());
		return "types";
	}

	// Save a water type (and capitalize the first letter)
	@RequestMapping(value = "/savewater", method = RequestMethod.POST)
	public String savetype(WaterType wtype) {
		String name1 = "";
		String name2 = "";
		name1 = wtype.getName();
		name2 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
		wtype.setName(name2);
		wrepo.save(wtype);
		return "redirect:types";
	}

	// Save a light type (and capitalize the first letter)
	@RequestMapping(value = "/savelight", method = RequestMethod.POST)
	public String savetype(LightType ltype) {
		String name1 = "";
		String name2 = "";
		name1 = ltype.getName();
		name2 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
		ltype.setName(name2);
		lrepo.save(ltype);
		return "redirect:types";
	}

	// Save a fertilizer type (and capitalize the first letter)
	@RequestMapping(value = "/savefertilizer", method = RequestMethod.POST)
	public String savetype(FertilizerType ftype) {

		String name1 = "";
		String name2 = "";
		name1 = ftype.getName();
		name2 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
		ftype.setName(name2);
		frepo.save(ftype);
		return "redirect:types";
	}

	// Delete a plant
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePlant(@PathVariable("id") Long plantId, Model model) {
		prepo.deleteById(plantId);
		return "redirect:../home";
	}

	// Save a plant (and capitalize the first letter)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Plant plant) {
		String name1 = "";
		String name2 = "";
		name1 = plant.getEngname();
		name2 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
		plant.setEngname(name2);
		name1 = plant.getLatname();
		name2 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
		plant.setLatname(name2);
		name1 = plant.getFinname();
		name2 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
		plant.setFinname(name2);
		prepo.save(plant);
		return "redirect:home";
	}
}
