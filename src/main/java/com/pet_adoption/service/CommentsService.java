package com.pet_adoption.service;


import com.pet_adoption.entity.Comments;

import java.util.List;

public interface CommentsService {
    List<Comments> findAll();

    boolean insert(Comments comments);

    boolean update(Comments comments);

    boolean delete(Integer id);

    Comments findByCommentsId(Integer id);

    List<Comments> findByCommentsUserName(String userName);
}
