/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package com.udacity.DogsCircus.service;

import com.udacity.DogsCircus.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogBreed();
    List<String> retrieveDogNamesGeneric();
    List<String> retrieveDogNamesCustom();
}
