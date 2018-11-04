package com.spproject.plantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WaterTypeRepository extends CrudRepository<WaterType, Long> {
	List<WaterType> findByName(String name);
}
