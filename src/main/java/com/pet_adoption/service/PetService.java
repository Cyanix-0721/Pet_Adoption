package com.pet_adoption.service;

import com.pet_adoption.entity.Pet;

import java.util.List;

public interface PetService {
    List<Pet> findAll();

    boolean insert(Pet pet);

    boolean update(Pet pet);

    boolean delete(Integer id);

    Pet findByPetId(Integer id);

    List<Pet> findByPetName(String petName);

    List<Pet> findByPetType(String petType);
}
