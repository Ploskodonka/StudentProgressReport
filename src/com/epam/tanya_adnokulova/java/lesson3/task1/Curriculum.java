package com.epam.tanya_adnokulova.java.lesson3.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Curriculum {
	private String name;
	private Calendar startDate = Calendar.getInstance();
	private Calendar endDate = Calendar.getInstance();
	private int curriculumDuration = 0;
	private List<Courses> courseList = new ArrayList<Courses>();
	
	public Curriculum(String name, String startDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		
		try {
			this.startDate.setTime(sdf.parse(startDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
			e.printStackTrace();
		}
		
		this.name = name;
	}
	
	public void addCourse(Courses course) {
		courseList.add(course);
	}
	
	public List<Courses> getCourseList() {
		return courseList;
	}
	
	public String getName() {
		return name;
	}
	
	public Calendar getStartDate() {
		return startDate;
	}
	
	public Calendar getEndDate() {
		endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH),  startDate.get(Calendar.DATE) + getCurriculumDuration() / 8, 
				startDate.get(Calendar.HOUR_OF_DAY) + getCurriculumDuration() % 8, startDate.get(Calendar.MINUTE));
		
		if (endDate.get(Calendar.HOUR_OF_DAY) >= 18) {
			endDate.set(endDate.get(Calendar.HOUR_OF_DAY), endDate.get(Calendar.HOUR_OF_DAY) - 18);
			endDate.set(endDate.get(Calendar.DATE), endDate.get(Calendar.DATE) + 1);
		}
		
		return endDate;
	}
	
	public int getCurriculumDuration() {
		curriculumDuration = getDuration();
		return curriculumDuration;
	}
	
	public int getDuration() {
		int duration = 0;
		for (int i = 0; i < courseList.size(); i++) {
			duration += courseList.get(i).getDuration();
		}
		
		return duration;
	}
//	public int getCurriculumDuration() {
//		return curriculumDuration;
//	}
}
