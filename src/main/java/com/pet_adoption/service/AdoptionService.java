package com.pet_adoption.service;

import com.pet_adoption.entity.Adoption;

import java.util.List;

public interface AdoptionService {
    List<Adoption> findAll();

    boolean insert(Adoption adoption);

    boolean update(Adoption adoption);

    boolean delete(Integer id);

    Adoption findByAdoptionId(Integer id);

    List<Adoption> findByAdoptionUserId(Integer userId);

    List<Adoption> findByAdoptionPetId(Integer petId);
}
