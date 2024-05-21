package com.pet_adoption.dao;

import com.pet_adoption.entity.Apply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("ApplyDAO")
public interface ApplyDAO {
    List<Apply> findAll();

    int insert(@Param("apply") Apply apply);

    int update(@Param("apply") Apply apply);

    int delete(@Param("id") Integer id);

    Apply findByApplyId(@Param("id") Integer id);

    List<Apply> findByApplyName(@Param("name") String name);

    List<Apply> findByApplyTime(@Param("applyTime") Date applyTime);

    List<Apply> findByApplyState(@Param("state") Integer state);
}
