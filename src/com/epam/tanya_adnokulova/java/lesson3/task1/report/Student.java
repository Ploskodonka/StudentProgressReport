package com.epam.tanya_adnokulova.java.lesson3.task1.report;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.TimeZone;
//import java.util.List;


import com.epam.tanya_adnokulova.java.lesson3.task1.helper.Curriculum;

public class Student {
	private String name;
	private Curriculum curriculum;

	public Student(String name) {
		this.name = name;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	//Calculates the difference between 2 dates in working days, hours and minutes
	public String timeRemains(Calendar endDate, Calendar currentDate) {
		int timeRemains = 0; //total hours without taking working hours in consideration
		String status = "\nFinished course. Passed time: ";
		boolean flag = true;
		
		currentDate.clear(Calendar.MILLISECOND);
		endDate.clear(Calendar.MILLISECOND);
		
		if (currentDate.equals(endDate)) 
			return status + "0days 0h\n";
		
		if (endDate.after(currentDate)) {
			Calendar temp = endDate;
			endDate = currentDate; 
			currentDate = temp;
			status = "\nHasn't finished course. Time Remains: ";
			flag = false;
		}

		int deltaHour = 0; 
		int deltaDay = currentDate.get(Calendar.DATE)
				- endDate.get(Calendar.DATE);
		int deltaMonth = currentDate.get(Calendar.MONTH) - endDate.get(Calendar.MONTH);
		int deltaYear = currentDate.get(Calendar.YEAR) - endDate.get(Calendar.YEAR);

		if (deltaDay < 0) {
			deltaDay += getDaysInMonth(currentDate.get(Calendar.YEAR),
					currentDate.get(Calendar.MONTH)); 
			deltaMonth--;
		}

		if (deltaMonth < 0) {
			deltaMonth += 12;
			deltaYear--;
		}
		
		deltaMonth += deltaYear*12; // total months
		deltaDay += deltaMonth*30; // total days
		
		if(!flag) {
			Calendar temp = endDate;
			endDate = currentDate; 
			currentDate = temp;
		}
		
		if (currentDate.get(Calendar.HOUR_OF_DAY) <= 18 && currentDate.get(Calendar.HOUR_OF_DAY) >= 10) {
			if (currentDate.get(Calendar.HOUR_OF_DAY) >= endDate.get(Calendar.HOUR_OF_DAY)) {
				if (flag)
					deltaHour = currentDate.get(Calendar.HOUR_OF_DAY) - endDate.get(Calendar.HOUR_OF_DAY);
				else {
					deltaHour = (18 - currentDate.get(Calendar.HOUR_OF_DAY)) + (endDate.get(Calendar.HOUR_OF_DAY) - 10);
					deltaDay--;
				}
			}
			else {
				if (!flag)
					deltaHour = endDate.get(Calendar.HOUR_OF_DAY) - currentDate.get(Calendar.HOUR_OF_DAY);
				else {
					deltaHour = endDate.get(Calendar.HOUR_OF_DAY) - currentDate.get(Calendar.HOUR_OF_DAY);
					deltaDay--;
				}
			}
		}
		else {
			if (flag)
				deltaHour = 18 - endDate.get(Calendar.HOUR_OF_DAY);
			else {
				deltaHour = endDate.get(Calendar.HOUR_OF_DAY) - 10;
				deltaDay--;
			}
		}
		
		deltaDay = (deltaDay < 0) ? 0 : deltaDay;
		timeRemains = (deltaDay*24 + deltaHour) - (16 * deltaDay);
		return status + timeRemains / 8 + "days " + timeRemains % 8 + "h\n";
	}
	
	private  int getDaysInMonth(int year, int month) {
		return new GregorianCalendar(year, month, 0).getActualMaximum(Calendar.DATE); 
	}
	
	//Prints student's status report
	public void printCurrentLearningStatus(String version) {
		Calendar currentDate = Calendar.getInstance();
		//currentDate.setTimeZone(TimeZone.getTimeZone("Europe/Samara"));
		
		//To test current date: uncomment previous line and comment next line
		currentDate.set(2015, 02, 5, 16, 00); 
		
		curriculum.calculateEndDate();
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
						+ "\nCurrent date: " + formatCurrent + timeRemains(curriculum.getEndDate(), currentDate));
				formatStartDate.close();
				formatEndDate.close();
				formatCurrent.close();
				break;
			default:
				break;
		}
	}
}
