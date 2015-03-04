package com.epam.tanya_adnokulova.java.lesson3.task1;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.TimeZone;
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

	//Calculates the difference between 2 dates in working days, hours and minutes
	public String timeRemains(Calendar endDate, Calendar currentDate) {
		int timeRemains = 0; //total hours without taking working hours in consideration
		String status = "\nFinished course. Passed time: ";
		boolean flag = true;
		
		if (endDate.after(currentDate)) {
			Calendar temp = endDate;
			endDate = currentDate;
			currentDate = temp;
			status = "\nHasn't finished course. Remains: ";
			flag = false;
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
		
		if (flag) {
			return status + timeRemains / 8 + "days " + timeRemains % 8 + "h " + deltaMin + "min\n";
		}
		else {
			return status + timeRemains / 8 + "days " + (timeRemains % 8 + 1) + "h " + deltaMin + "min\n";
		}
	}
	
	private  int getDaysInMonth(int year, int month) {
		return new GregorianCalendar(year, month, 0).getActualMaximum(Calendar.DAY_OF_MONTH); 
	}
	
	//Prints student's status report
	public void printCurrentLearningStatus(String version) {
		//List<Courses> courses = curriculum.getCourseList();

		Calendar currentDate = Calendar.getInstance();
		currentDate.setTimeZone(TimeZone.getTimeZone("Europe/Samara"));
		
		Formatter formatStartDate = new Formatter();
		Formatter formatEndDate = new Formatter();
		Formatter formatCurrent = new Formatter();
		formatStartDate.format("%td.%tm.%tY %tR", curriculum.getStartDate(), curriculum.getStartDate(), curriculum.getStartDate(), curriculum.getStartDate());
		formatEndDate.format("%td.%tm.%tY %tR", curriculum.getEndDate(), curriculum.getEndDate(), curriculum.getEndDate(), curriculum.getEndDate());
		formatCurrent.format("%td.%tm.%tY %tR", currentDate, currentDate, currentDate, currentDate);

		switch (version) {
			case "short":
				System.out.println(name + " (" + curriculum.getName() + ")" + timeRemains(curriculum.getEndDate(), currentDate));
				formatStartDate.close();
				formatEndDate.close();
				break;
			case "long":
				System.out.println(name + "\nWorking Time: from 10AM to 6PM\nCurriculum: " + curriculum.getName() + "\nCurriculum duration: " 
						+ curriculum.getCurriculumDuration() + "\nStart date: " + formatStartDate + "\nEnd date: " + formatEndDate 
						+ timeRemains(curriculum.getEndDate(), currentDate) + "\nCurrent date: " + formatCurrent + "\n");
				formatStartDate.close();
				formatEndDate.close();
				formatCurrent.close();
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
