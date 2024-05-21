package com.pet_adoption.service;

import com.pet_adoption.entity.Apply;

import java.util.Date;
import java.util.List;

public interface ApplyService {
    List<Apply> findAll();

    boolean insert(Apply apply);

    boolean update(Apply apply);

    boolean delete(Integer id);

    Apply findByApplyId(Integer id);

    List<Apply> findByApplyName(String name);

    List<Apply> findByApplyTime(Date applyTime);

    List<Apply> findByApplyState(Integer state);
}
