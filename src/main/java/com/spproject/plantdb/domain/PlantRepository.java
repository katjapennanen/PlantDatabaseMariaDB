package com.spproject.plantdb.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends MongoRepository<Plant, String> {}
