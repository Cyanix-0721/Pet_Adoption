package com.pet_adoption.service.impl;

import com.pet_adoption.dao.ApplyDAO;
import com.pet_adoption.entity.Apply;
import com.pet_adoption.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("ApplyService")
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyDAO applyDAO;


    @Override
    public List<Apply> findAll() {
        return applyDAO.findAll();
    }

    @Override
    public boolean insert(Apply apply) {
        return applyDAO.insert(apply) == 1;
    }

    @Override
    public boolean update(Apply apply) {
        return applyDAO.update(apply) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return applyDAO.delete(id) == 1;
    }

    @Override
    public Apply findByApplyId(Integer id) {
        return applyDAO.findByApplyId(id);
    }

    @Override
    public List<Apply> findByApplyName(String name) {
        return applyDAO.findByApplyName(name);
    }

    @Override
    public List<Apply> findByApplyTime(Date applyTime) {
        return applyDAO.findByApplyTime(applyTime);
    }

    @Override
    public List<Apply> findByApplyState(Integer state) {
        return applyDAO.findByApplyState(state);
    }
}
