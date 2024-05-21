package com.pet_adoption.dao;


import com.pet_adoption.entity.Pet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PetDAO")
public interface PetDAO {
    List<Pet> findAll();

    int insert(@Param("pet") Pet pet);

    int update(@Param("pet") Pet pet);

    int delete(@Param("id") Integer id);

    Pet findByPetId(@Param("id") Integer id);

    List<Pet> findByPetName(@Param("petName") String petName);

    List<Pet> findByPetType(@Param("petType") String petType);
}
