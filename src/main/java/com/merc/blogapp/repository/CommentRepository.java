package com.merc.blogapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merc.blogapp.model.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

	List<Comment> findByBlogId(Integer blogid);

}
