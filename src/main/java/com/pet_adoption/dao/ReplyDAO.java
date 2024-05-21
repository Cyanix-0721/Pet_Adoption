package com.pet_adoption.dao;


import com.pet_adoption.entity.Reply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ReplyDAO")
public interface ReplyDAO {
    List<Reply> findAll();

    int insert(@Param("reply") Reply reply);

    int update(@Param("reply") Reply reply);

    int delete(@Param("id") Integer id);

    Reply findByReplyId(@Param("id") Integer id);

    List<Reply> findByReplyUserName(@Param("userName") String userName);
}
