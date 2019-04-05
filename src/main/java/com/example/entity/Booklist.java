package com.example.entity;

public class Booklist {

	private Integer booklist_id;
    private String booklist_name;
    private String booklist_intro;
    private String booklist_cover;

    public void setBooklist_Id(Integer booklist_id){
    	this.booklist_id = booklist_id; 
    	}
    
    public int getBooklist_Id(){ 
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
    
    
    public void setBooklist_cover(String booklist_cover){
    	this.booklist_cover = booklist_cover; 
    	}
    
    public String getBooklist_cover() {
    	return booklist_cover;
    }

}
