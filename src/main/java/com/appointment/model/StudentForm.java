package com.appointment.model;

public class StudentForm {

	private String name;
	private String profession;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentForm [name=" + name + ", profession=" + profession + ", age=" + age + "]";
	}

}
