package com.pet_adoption.dao;

import com.pet_adoption.entity.Comments;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CommentsDAO")
public interface CommentsDAO {
    List<Comments> findAll();

    int insert(@Param("comments") Comments comments);

    int update(@Param("comments") Comments comments);

    int delete(@Param("id") Integer id);

    Comments findByCommentsId(@Param("id") Integer id);

    List<Comments> findByCommentsUserName(@Param("userName") String userName);
}
