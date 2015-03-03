package com.epam.tanya_adnokulova.java.lesson3.task1;

public class Courses {
	private String courseName;
	private int duration;
	
	public Courses(String courseName, int duration) {
		this.courseName = courseName;
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public String getCourseName() {
		return courseName;
	}
}
