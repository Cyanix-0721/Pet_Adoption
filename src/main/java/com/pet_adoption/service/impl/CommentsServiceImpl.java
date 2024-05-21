package com.pet_adoption.service.impl;

import com.pet_adoption.dao.CommentsDAO;
import com.pet_adoption.entity.Comments;
import com.pet_adoption.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentsService")
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsDAO commentsDAO;

    @Override
    public List<Comments> findAll() {
        return commentsDAO.findAll();
    }

    @Override
    public boolean insert(Comments comments) {
        return commentsDAO.insert(comments) == 1;
    }

    @Override
    public boolean update(Comments comments) {
        return commentsDAO.update(comments) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return commentsDAO.delete(id) == 1;
    }

    @Override
    public Comments findByCommentsId(Integer id) {
        return commentsDAO.findByCommentsId(id);
    }

    @Override
    public List<Comments> findByCommentsUserName(String userName) {
        return commentsDAO.findByCommentsUserName(userName);
    }

}
