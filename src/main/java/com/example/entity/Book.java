package com.example.entity;

public class Book {

	private int bookid;//书籍id
	private String book_cover;//书籍封面
	private int book_grade;//书籍评分
	private int booklist_number;//书籍所属书单数
	private int collect;//书籍收藏数
	private int recommend;//书籍推荐数
	private String book_name;//书籍名称
	private String auther;//书籍作者
	private String book_intro;//书籍简介
	
	public void setBookid(int bookid) {
		this.bookid=bookid;
	}
	
	public int getBookid() {
		return bookid;
	}
	
	public void setBook_cover(String book_cover) {
		this.book_cover=book_cover;
	}
	
	public String getBook_cover(String book_cover) {
		return book_cover;
	}
	
	public void setBook_grade(int book_grade) {
		this.book_grade=book_grade;
	}
	
	public int getBook_grade() {
		return book_grade;
	}
	
	public void setBooklist_number(int booklist_number) {
		this.booklist_number=booklist_number;
	}
	
	public int getBooklist_number() {
		return booklist_number;
	}
	
	public void setCollect(int collect) {
		this.collect=collect;
	}
	
	public int getCollect() {
		return collect;
	}
	
	public void setRecommend(int recommend) {
		this.recommend=recommend;
	}
	
	public int getRecommend() {
		return recommend;
	}
	
	public void setBook_name(String book_name) {
		this.book_name=book_name;
	}
	
	public String getBook_name() {
		return book_name;
	}
	
	public void setAuther(String auther) {
		this.auther=auther;
	}
	
	public String getAuther() {
		return auther;
	}
	
	public void setBook_intro(String book_intro) {
		this.book_intro=book_intro;
	}
	
	public String getBook_intro() {
		return book_intro;
	}
	
	
}
