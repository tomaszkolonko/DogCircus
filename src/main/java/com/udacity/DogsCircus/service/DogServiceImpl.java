/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package com.udacity.DogsCircus.service;

import com.udacity.DogsCircus.entity.Dog;
import com.udacity.DogsCircus.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreebById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.findAllBreed();
    }

    @Override
    public List<String> retrieveDogNamesGeneric() {
        List<Dog> myList = (List<Dog>) dogRepository.findAll();
        return myList.stream().map(dog -> dog.getName()).collect(Collectors.toList());
    }

    @Override
    public List<String> retrieveDogNamesCustom() {
        return dogRepository.findAllName();
    }
}
