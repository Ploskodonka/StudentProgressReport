package com.epam.tanya_adnokulova.java.lesson3.task1;

import java.util.Calendar;

public class Courses {
	private String courseName;
	private int duration;
	private Calendar startDate;
	private Calendar endDate;
	
	public Courses(String courseName, int duration) {
		this.courseName = courseName;
		this.duration = duration;
	}
}
