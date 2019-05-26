package com.appointment.model;

public class Author {

	//this is id
	private int id;
	private String name;
	private String qualification;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", qualification=" + qualification + "]";
	}
	
	
}
