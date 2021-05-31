package com.web.model;

public class Author {
	private String id;
	private String name;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Author(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}
