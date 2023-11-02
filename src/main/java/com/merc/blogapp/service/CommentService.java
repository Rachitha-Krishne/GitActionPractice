package com.merc.blogapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merc.blogapp.model.Comment;
import com.merc.blogapp.repository.CommentRepository;


@Service
public class CommentService implements ICommentService{

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<Comment> getCommentByBlogId(Integer blogid) {
		
		return commentRepository.findByBlogId(blogid);
		
		
	}

	@Override
	public Comment addComment(Comment com) {
		
		return commentRepository.save(com);
		
	}
	
	
	
	
}
