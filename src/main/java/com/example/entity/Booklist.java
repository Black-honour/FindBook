package com.example.entity;

public class Booklist {
	private Integer booklist_id;
    private String booklist_name;
    private String booklist_intro;
    private String booklist_cover;
    private String booklist_author;
    private Integer booklist_userid;

    public void setBooklist_id(Integer booklist_id){
    	this.booklist_id = booklist_id; 
    	}
    
    public Integer getBooklist_id(){ 
    	return booklist_id;
    	}
    
    public void setBooklist_name(String booklist_name){
    	this.booklist_name = booklist_name;
    	}
    
    
    public String getBooklist_name(){
    	return booklist_name; 
    	}
    
    public void setBooklist_intro(String booklist_intro){ 
    	this.booklist_intro = booklist_intro; 
    	}
    
    
    public String getBooklist_intro(){
    	return booklist_intro;
    	}
    
    
    public void setBooklist_author(String booklist_author){
    	this.booklist_author = booklist_author; 
    	}
    
    public String getBooklist_author() {
    	return booklist_author;
    }
    
    
    public void setBooklist_cover(String booklist_cover){
    	this.booklist_cover = booklist_cover; 
    	}
    
    public String getBooklist_cover() {
    	return booklist_cover;
    }
    
    public void setBooklist_userid(Integer booklist_userid){
    	this.booklist_userid = booklist_userid; 
    	}
    
    public Integer getBooklist_userid() {
    	return booklist_userid;
    }

}
