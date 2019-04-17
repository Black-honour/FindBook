package com.example.entity;

public class Ad {

	 private Integer id;

	 private String img;

	 private String url;

	 public Integer getId() {
	     return id;
	 }

	 public void setId(Integer id) {
	     this.id = id;
	 }

	 public String getImg() {
	      return img;
	 }

	 public void setImg(String img) {
	    this.img = img == null ? null : img.trim();
	 }

	 public String getUrl() {
	     return url;
	 }

	 public void setUrl(String url) {
	    this.url = url == null ? null : url.trim();
	 }

}
