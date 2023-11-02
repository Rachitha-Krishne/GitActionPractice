package com.merc.blogapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.merc.blogapp.model.Comment;
import com.merc.blogapp.service.CommentService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/comments")
public class CommentsController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("get-comment-by-blogid/{blogid}")
	public List<Comment> getCommentByBlogId(@PathVariable(name = "blogid") Integer blogid) {

		return commentService.getCommentByBlogId(blogid);
	}
	
//	@PostMapping("add-comment/")
//	@RequestMapping(path = "add-comment", method =RequestMethod.POST,consumes = "application/json", produces = "application/json" )
	@RequestMapping(path = "add-comment/{blogid}", method =RequestMethod.POST,consumes = "application/json", produces = "application/json" )
	public ResponseEntity<Comment> addComment(@RequestBody Comment com, @PathVariable("blogid") Integer blogId) {
		
		com.setBlogId(blogId);
		com.setCommentBody(com.getCommentBody());
		Comment comObj = commentService.addComment(com);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Employee created successfully");
		ResponseEntity<Comment> response = new ResponseEntity<Comment>(comObj,headers,status);
		return response;
		
	}

}
