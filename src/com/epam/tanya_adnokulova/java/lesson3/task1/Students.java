package com.epam.tanya_adnokulova.java.lesson3.task1;

import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.util.List;

public class Students {
	private String name;
	private Curriculum curriculum;

	public Students(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public String timeRemains(Calendar endDate, Calendar currentDate) {
		int timeRemains = 0; //total hours without taking working hours in consideration
		String status = "Finished course. Passed time: ";
		
		if (endDate.after(currentDate)) {
			Calendar temp = endDate;
			endDate = currentDate;
			currentDate = temp;
			status = "Hasn't finished course. Remains: ";
		}

		int deltaMin = currentDate.get(Calendar.MINUTE) - endDate.get(Calendar.MINUTE);
		int deltaHour = currentDate.get(Calendar.HOUR) - endDate.get(Calendar.HOUR);
		int deltaDay = currentDate.get(Calendar.DAY_OF_MONTH)
				- endDate.get(Calendar.DAY_OF_MONTH);
		int deltaMonth = currentDate.get(Calendar.MONTH) - endDate.get(Calendar.MONTH);
		int deltaYear = currentDate.get(Calendar.YEAR) - endDate.get(Calendar.YEAR);

		if (deltaMin < 0) {
			deltaMin += 60;
			deltaHour--;
		}

		if (deltaHour < 0) {
			deltaHour += 24;
			deltaDay--;
		}

		if (deltaDay < 0) {
			deltaDay += getDaysInMonth(currentDate.get(Calendar.YEAR),
					currentDate.get(Calendar.DAY_OF_MONTH) - 1); 
			deltaMonth--;
		}

		if (deltaMonth < 0) {
			deltaMonth += 12;
			deltaYear--;
		}
		
		deltaMonth += deltaYear*12; // total months
		deltaDay += deltaMonth*30; // total days
		
		if (deltaHour >= 16) {
			timeRemains = (deltaDay*24 + (deltaHour - 16)) - (16 * deltaDay);
		}
		else {
			if (deltaHour >= (18 - endDate.get(Calendar.HOUR))) {
				deltaHour = 17 - endDate.get(Calendar.HOUR);
				deltaMin = endDate.get(Calendar.MINUTE);
			}
			
			timeRemains = (deltaDay*24 + deltaHour) - (16 * deltaDay);
		} 
		
		return status + timeRemains / 8 + "days " + timeRemains % 8 + "hours " + deltaMin + "minutes";
	}
	
	private  int getDaysInMonth(int year, int month) {
		   return new GregorianCalendar(year, month, 0).getActualMaximum(Calendar.DAY_OF_MONTH); 
		}

	public void printCurrentLearningStatus(String version) {
		//List<Courses> courses = curriculum.getCourseList();

		Calendar currentDate = Calendar.getInstance();

		switch (version) {
		case "short":
			System.out.println(name + " (" + curriculum.getName() + ") - " + timeRemains(curriculum.getEndDate(), currentDate));
			break;
		case "long":
			System.out.println(name + "\nWorking Time: from 10AM to 6PM\nCurriculum: " + curriculum.getName() + "\nCurriculum duration: " 
					+ curriculum.getCurriculumDuration() + "\nStart date: " + curriculum.getStartDate() + "\nEnd date: " + curriculum.getEndDate()
					+ timeRemains(curriculum.getEndDate(), currentDate));
			break;
		default:
			break;
		}

		// if (courses != null && courses.size() != 0) {
		// System.out.println(name + " is learning " + courses.size() +
		// " courses");
		// }
	}
}
