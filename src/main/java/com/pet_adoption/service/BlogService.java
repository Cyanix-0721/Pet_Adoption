package com.pet_adoption.service;


import com.pet_adoption.entity.Blog;

import java.util.Date;
import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    boolean insert(Blog blog);

    boolean update(Blog blog);

    boolean delete(Integer id);

    Blog findByBlogId(Integer id);

    List<Blog> findByBlogName(String event);

    List<Blog> findByBlogDate(Date date);
}
