package com.example.book.rest.model;

public class CreateBookRequest {
	private String name;

	public CreateBookRequest(long id, String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
