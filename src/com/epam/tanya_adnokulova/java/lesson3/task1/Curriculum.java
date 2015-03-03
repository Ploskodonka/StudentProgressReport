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
	private int curriculumDuration;
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
		if (courseList.size() == 1) {
			
			//in case if ((course duration) mod 8) is less or equals an interval between the last "work hour" of a day
			//and an hour the course has started at, we DON'T have to skip over the night till the beginning of an work hour 
			//by adding extra 16 hours (which we get from finding how many hours we have between the end of a work day and the beginning
			//of a new work day (from 6 PM to 10 AM)
			
			if (courseList.get(0).getDuration() % 8 > (18 - startDate.get(Calendar.HOUR_OF_DAY))) {
				endDate.set(startDate.get(Calendar.DATE) + courseList.get(0).getDuration() / 8 + 1, startDate.get(Calendar.MONTH), startDate.get(Calendar.YEAR), 
						startDate.get(Calendar.HOUR_OF_DAY) + ((courseList.get(0).getDuration() % 8 - (18 - startDate.get(Calendar.HOUR_OF_DAY))) + 16 + (18 - startDate.get(Calendar.HOUR_OF_DAY))),
						startDate.get(Calendar.MINUTE));
			}
			else {
				endDate.set(startDate.get(Calendar.DATE) + courseList.get(0).getDuration() / 8, startDate.get(Calendar.MONTH), startDate.get(Calendar.YEAR), 
						startDate.get(Calendar.HOUR_OF_DAY) + ((courseList.get(0).getDuration() % 8 - (18 - startDate.get(Calendar.HOUR_OF_DAY))) + (18 - startDate.get(Calendar.HOUR_OF_DAY))),
						startDate.get(Calendar.MINUTE));
			}
			
			curriculumDuration = courseList.get(0).getDuration();
			
		}
		else {
			if (courseList.get(courseList.size()-1).getDuration() > (18 - endDate.get(Calendar.HOUR_OF_DAY))) {
				endDate.set(endDate.get(Calendar.DATE) + courseList.get(courseList.size()-1).getDuration() / 8, endDate.get(Calendar.MONTH), endDate.get(Calendar.YEAR), 
						endDate.get(Calendar.HOUR_OF_DAY) + ((courseList.get(courseList.size()-1).getDuration() % 8 - (18 - endDate.get(Calendar.HOUR_OF_DAY))) + 16 + (18 - endDate.get(Calendar.HOUR_OF_DAY))),
						endDate.get(Calendar.MINUTE));
			}
			else {
				endDate.set(endDate.get(Calendar.DATE) + courseList.get(courseList.size()-1).getDuration() / 8, endDate.get(Calendar.MONTH), endDate.get(Calendar.YEAR), 
						endDate.get(Calendar.HOUR_OF_DAY) + ((courseList.get(courseList.size()-1).getDuration() % 8 - (18 - endDate.get(Calendar.HOUR_OF_DAY))) + (18 - endDate.get(Calendar.HOUR_OF_DAY))),
						endDate.get(Calendar.MINUTE));
			}
			
			curriculumDuration += courseList.get(courseList.size()-1).getDuration();
		}
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
		return endDate;
	}
	
	public int getCurriculumDuration() {
		return curriculumDuration;
	}
	
	public String toString() {
		return "Curriculum: " + name + "\nCurriculum duration: " + curriculumDuration +" hours\nStart date: "
				+ startDate + "\nEnd Date: " + endDate;
	}
}
