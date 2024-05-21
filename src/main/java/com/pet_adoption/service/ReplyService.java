package com.pet_adoption.service;


import com.pet_adoption.entity.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> findAll();

    boolean insert(Reply reply);

    boolean update(Reply reply);

    boolean delete(Integer id);

    Reply findByReplyId(Integer id);

    List<Reply> findByReplyUserName(String userName);

}
