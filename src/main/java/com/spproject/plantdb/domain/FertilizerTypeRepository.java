package com.spproject.plantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FertilizerTypeRepository extends CrudRepository<FertilizerType, Long> {
	List<FertilizerType> findByName(String name);
}
