package com.epam.tanya_adnokulova.java.lesson3.task1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;

public class Curriculum {
	private String name;
	private Calendar startDate;
	private List<Courses> courseList = new ArrayList<Courses>();
	
	public Curriculum(String name, Calendar startDate) {
		Formatter f = new Formatter();
		f.format("%tF %tT", startDate);
		this.startDate.setTime(f);
		this.name = name;
		
	}
	
	public List<Courses> getCourseList() {
		return courseList;
	}
	
	public void addCourse(Courses course) {
		courseList.add(course);
	}
}
