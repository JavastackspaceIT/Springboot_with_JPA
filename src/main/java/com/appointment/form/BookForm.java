package com.appointment.form;

public class BookForm {

	private String name;
	private String qualification;
	private String bookName;
	private String title;

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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BookForm [name=" + name + ", qualification=" + qualification + ", bookName=" + bookName + ", title="
				+ title + "]";
	}

}
