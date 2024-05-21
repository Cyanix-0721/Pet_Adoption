package com.pet_adoption.service.impl;

import com.pet_adoption.dao.AdoptionDAO;
import com.pet_adoption.entity.Adoption;
import com.pet_adoption.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdoptionService")
public class AdoptionServiceImpl implements AdoptionService {
    @Autowired
    private AdoptionDAO adoptionDAO;


    @Override
    public List<Adoption> findAll() {
        return adoptionDAO.findAll();
    }

    @Override
    public boolean insert(Adoption adoption) {
        return adoptionDAO.insert(adoption) == 1;
    }

    @Override
    public boolean update(Adoption adoption) {
        return adoptionDAO.update(adoption) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return adoptionDAO.delete(id) == 1;
    }

    @Override
    public Adoption findByAdoptionId(Integer id) {
        return adoptionDAO.findByAdoptionId(id);
    }

    @Override
    public List<Adoption> findByAdoptionUserId(Integer userId) {
        return adoptionDAO.findByAdoptionUserId(userId);
    }

    @Override
    public List<Adoption> findByAdoptionPetId(Integer petId) {
        return adoptionDAO.findByAdoptionPetId(petId);
    }

}
