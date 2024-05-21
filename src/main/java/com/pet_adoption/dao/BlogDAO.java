package com.pet_adoption.dao;

import com.pet_adoption.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("BlogDAO")
public interface BlogDAO {
    List<Blog> findAll();

    int insert(@Param("blog") Blog blog);

    int update(@Param("blog") Blog blog);

    int delete(@Param("id") Integer id);

    Blog findByBlogId(@Param("id") Integer id);

    List<Blog> findByBlogName(@Param("event") String event);

    List<Blog> findByBlogDate(@Param("date") Date date);
}
