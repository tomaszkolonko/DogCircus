/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package com.udacity.DogsCircus.web;

import com.udacity.DogsCircus.entity.Dog;
import com.udacity.DogsCircus.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    private DogService dogService;

    @Autowired
    public WebController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedById(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/c_name/")
    public ResponseEntity<List<String>> getDogNamesCustom() {
        List<String> list = dogService.retrieveDogNamesCustom();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/g_name/")
    public ResponseEntity<List<String>> getDogNamesGeneric() {
        List<String> list = dogService.retrieveDogNamesGeneric();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
