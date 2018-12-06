package com.spproject.plantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
	
	List<Plant> findAllByOrderByEngNameAsc();
	List<Plant> findAllByOrderByEngNameDesc();
	
	List<Plant> findAllByOrderByLatNameAsc();
	List<Plant> findAllByOrderByLatNameDesc();
	
	List<Plant> findAllByOrderByFinNameAsc();
	List<Plant> findAllByOrderByFinNameDesc();
	
	List<Plant> findAllByOrderByWtype_NameAsc();
	List<Plant> findAllByOrderByWtype_NameDesc();
	
	List<Plant> findAllByOrderByFtype_NameAsc();
	List<Plant> findAllByOrderByFtype_NameDesc();
	
	List<Plant> findAllByOrderByLtype_NameAsc();
	List<Plant> findAllByOrderByLtype_NameDesc();
	
	// Monsterous searching query
	List<Plant> findByEngNameIgnoreCaseContainingOrLatNameIgnoreCaseContainingOrFinNameIgnoreCaseContainingOrWtype_NameIgnoreCaseContainingOrLtype_NameIgnoreCaseContainingOrFtype_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
			String searchterm, String searchterm2, String searchterm3, String searchterm4, String searchterm5, String searchterm6, String searchterm7);
}
