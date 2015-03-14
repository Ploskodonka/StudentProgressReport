package com.epam.tanya_adnokulova.java.lesson3.task1.runner;

import com.epam.tanya_adnokulova.java.lesson3.task1.helper.Course;
import com.epam.tanya_adnokulova.java.lesson3.task1.helper.Curriculum;
import com.epam.tanya_adnokulova.java.lesson3.task1.report.Student;

public class ShowProgress {
	
	public void studentProgress(String param) {
		Student ivanov = new Student("Ivanov Ivan");
		Curriculum j2eeDeveloper = new Curriculum("J2EE Developer", "01.03.2015 17:00");
		Course javaServlets = new Course(16);
		Course strutsFramework = new Course(24);
		j2eeDeveloper.addCourse(javaServlets);
		j2eeDeveloper.addCourse(strutsFramework);
		ivanov.setCurriculum(j2eeDeveloper);
	
		Student petrov = new Student("Petrov Petr");
		Curriculum javaDeveloper = new Curriculum("Java Developer", "01.03.2015 17:00");
		Course javaTechnologiesReview =  new Course(8);
		Course jfcLibrary = new Course(16);
		Course jdbcTechnology = new Course(16);
		javaDeveloper.addCourse(javaTechnologiesReview);
		javaDeveloper.addCourse(jfcLibrary);
		javaDeveloper.addCourse(jdbcTechnology);
		petrov.setCurriculum(javaDeveloper);
		
		if (param.equals("0")) {
			ivanov.printCurrentLearningStatus("short");
			petrov.printCurrentLearningStatus("short");
		}
		else {
			ivanov.printCurrentLearningStatus("long");
			petrov.printCurrentLearningStatus("long");
		}
	}
}
