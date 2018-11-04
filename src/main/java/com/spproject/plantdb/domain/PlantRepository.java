package com.spproject.plantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
	
	List<Plant> findAllByOrderByEngNameAsc();
	List<Plant> findAllByOrderByLatNameAsc();
	List<Plant> findAllByOrderByFinNameAsc();
	List<Plant> findByEngNameIgnoreCaseContainingOrLatNameIgnoreCaseContainingOrFinNameIgnoreCaseContainingOrWtype_NameIgnoreCaseContainingOrLtype_NameIgnoreCaseContainingOrFtype_NameIgnoreCaseContaining(
			String searchterm, String searchterm2, String searchterm3, String searchterm4, String searchterm5, String searchterm6);
}
