package com.example.pojo;

import com.example.entity.Comment;

public class CommentCustom extends Comment{
	private Page page;

	public CommentCustom() {
		// TODO Auto-generated constructor stub
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}