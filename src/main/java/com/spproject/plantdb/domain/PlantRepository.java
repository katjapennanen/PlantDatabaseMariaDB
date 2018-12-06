package com.spproject.plantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
	
	List<Plant> findAllByOrderByEngnameAsc();
	List<Plant> findAllByOrderByEngnameDesc();
	
	List<Plant> findAllByOrderByLatnameAsc();
	List<Plant> findAllByOrderByLatnameDesc();
	
	List<Plant> findAllByOrderByFinnameAsc();
	List<Plant> findAllByOrderByFinnameDesc();
	
	List<Plant> findAllByOrderByWaterid_NameAsc();
	List<Plant> findAllByOrderByWaterid_NameDesc();
	
	List<Plant> findAllByOrderByFertilizerid_NameAsc();
	List<Plant> findAllByOrderByFertilizerid_NameDesc();
	
	List<Plant> findAllByOrderByLightid_NameAsc();
	List<Plant> findAllByOrderByLightid_NameDesc();
	
	// Monsterous searching query
	List<Plant> findByEngnameIgnoreCaseContainingOrLatnameIgnoreCaseContainingOrFinnameIgnoreCaseContainingOrWaterid_NameIgnoreCaseContainingOrLightid_NameIgnoreCaseContainingOrFertilizerid_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
			String searchterm, String searchterm2, String searchterm3, String searchterm4, String searchterm5, String searchterm6, String searchterm7);
}
