package com.spproject.plantdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LightTypeRepository extends CrudRepository<LightType, Long> {
	List<LightType> findByName(String name);
}
