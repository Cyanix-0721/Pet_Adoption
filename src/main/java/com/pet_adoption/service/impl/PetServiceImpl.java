package com.pet_adoption.service.impl;

import com.pet_adoption.dao.PetDAO;
import com.pet_adoption.entity.Pet;
import com.pet_adoption.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PetService")
public class PetServiceImpl implements PetService {
    @Autowired
    private PetDAO petDAO;

    @Override
    public List<Pet> findAll() {
        return petDAO.findAll();
    }

    @Override
    public boolean insert(Pet pet) {
        return petDAO.insert(pet) == 1;
    }

    @Override
    public boolean update(Pet pet) {
        return petDAO.update(pet) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return petDAO.delete(id) == 1;
    }

    @Override
    public Pet findByPetId(Integer id) {
        return petDAO.findByPetId(id);
    }

    @Override
    public List<Pet> findByPetName(String petName) {
        return petDAO.findByPetName(petName);
    }

    @Override
    public List<Pet> findByPetType(String petType) {
        return petDAO.findByPetType(petType);
    }
}
