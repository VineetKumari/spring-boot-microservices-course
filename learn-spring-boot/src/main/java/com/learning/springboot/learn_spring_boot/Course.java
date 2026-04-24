package com.learning.springboot.learn_spring_boot;

public class Course {
	private Long id;
	private String name;
	private String author;
	public Course(Long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	

}
