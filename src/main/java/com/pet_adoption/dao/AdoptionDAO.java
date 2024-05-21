package com.pet_adoption.dao;

import com.pet_adoption.entity.Adoption;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AdoptionDAO")
public interface AdoptionDAO {
    List<Adoption> findAll();

    int insert(@Param("adoption") Adoption adoption);

    int update(@Param("adoption") Adoption adoption);

    int delete(@Param("id") Integer id);

    Adoption findByAdoptionId(@Param("id") Integer id);

    List<Adoption> findByAdoptionUserId(@Param("userId") Integer userId);

    List<Adoption> findByAdoptionPetId(@Param("petId") Integer petId);
}
