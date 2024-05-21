package com.pet_adoption.service.impl;


import com.pet_adoption.dao.ReplyDAO;
import com.pet_adoption.entity.Reply;
import com.pet_adoption.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReplyService")
class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDAO replyDAO;

    @Override
    public List<Reply> findAll() {
        return replyDAO.findAll();
    }

    @Override
    public boolean insert(Reply reply) {
        return replyDAO.insert(reply) == 1;
    }

    @Override
    public boolean update(Reply reply) {
        return replyDAO.update(reply) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return replyDAO.delete(id) == 1;
    }

    @Override
    public Reply findByReplyId(Integer id) {
        return replyDAO.findByReplyId(id);
    }

    @Override
    public List<Reply> findByReplyUserName(String userName) {
        return replyDAO.findByReplyUserName(userName);
    }

}
