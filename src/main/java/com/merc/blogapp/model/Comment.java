package com.merc.blogapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comments_table")
public class Comment {
	
	public Comment() {
	    
	}

	@Id
	@Column(name = "Comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	
	
	@Column(name = "blog_id")
	private Integer blogId;
	
	@Column(name = "comment_body")
	private String commentBody;

	public Comment(Integer commentId, Integer blogId, String commentBody) {
		super();
		this.commentId = commentId;
		this.blogId = blogId;
		this.commentBody = commentBody;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	
	
	
	
}
