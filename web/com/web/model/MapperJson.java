package com.web.model;

public class MapperJson {
	private String bookId; 
	private String authId;
	public MapperJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MapperJson(String bookId, String authId) {
		super();
		this.bookId = bookId;
		this.authId = authId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	@Override
	public String toString() {
		return "MapperJson [bookId=" + bookId + ", authId=" + authId + "]";
	} 
}
