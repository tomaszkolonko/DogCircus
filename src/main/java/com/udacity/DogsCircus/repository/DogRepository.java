/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package com.udacity.DogsCircus.repository;

import com.udacity.DogsCircus.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Note that instead of taking this approach, you could alternatively use the built-in queries from
 * CrudRepository within the DogService to get all dogs or get a dog by ID,
 * then process the resulting object as well.
 */
public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("SELECT d.id, d.breed FROM Dog d WHERE d.id=:id")
    String findBreebById(Long id);

    @Query("SELECT d.id, d.breed FROM Dog d")
    List<String> findAllBreed();

    @Query("SELECT d.id, d.name FROM Dog d")
    List<String> findAllName();
}
