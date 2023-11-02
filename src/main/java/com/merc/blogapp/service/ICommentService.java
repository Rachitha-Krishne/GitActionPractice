package com.merc.blogapp.service;

import java.util.List;

import com.merc.blogapp.model.Comment;


public interface ICommentService {

	public abstract List<Comment> getCommentByBlogId(Integer eid);

	public abstract Comment addComment(Comment com);

}
