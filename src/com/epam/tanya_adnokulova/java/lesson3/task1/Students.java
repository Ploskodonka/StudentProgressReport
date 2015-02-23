package com.epam.tanya_adnokulova.java.lesson3.task1;

import java.util.List;

public class Students {
	private String name;
	private Curriculum curriculum;
	
	public Students(String name) {
		this.name = name;
	}
	
	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	public void printCurrentLearningStatus() {
		List<Courses> courses = curriculum.getCourseList();
		
		if (courses != null && courses.size() != 0) {
			System.out.println(name + " is learning " + courses.size() + " courses");
		}
	}
}
