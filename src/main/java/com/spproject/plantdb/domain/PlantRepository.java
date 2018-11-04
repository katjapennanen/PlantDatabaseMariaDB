package com.spproject.plantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {

	List<Plant> findByEngNameIgnoreCaseContainingOrLatNameIgnoreCaseContainingOrFinNameIgnoreCaseContaining(String searchterm, String searchterm2, String searchterm3);
}
