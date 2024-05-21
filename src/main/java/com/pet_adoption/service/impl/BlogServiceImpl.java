package com.pet_adoption.service.impl;

import com.pet_adoption.dao.BlogDAO;
import com.pet_adoption.entity.Blog;
import com.pet_adoption.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("BlogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogDAO;

    @Override
    public List<Blog> findAll() {
        return blogDAO.findAll();
    }

    @Override
    public boolean insert(Blog blog) {
        return blogDAO.insert(blog) == 1;
    }

    @Override
    public boolean update(Blog blog) {
        return blogDAO.update(blog) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return blogDAO.delete(id) == 1;
    }

    @Override
    public Blog findByBlogId(Integer id) {
        return blogDAO.findByBlogId(id);
    }

    @Override
    public List<Blog> findByBlogName(String event) {
        return blogDAO.findByBlogName(event);
    }

    @Override
    public List<Blog> findByBlogDate(Date date) {
        return blogDAO.findByBlogDate(date);
    }
}
