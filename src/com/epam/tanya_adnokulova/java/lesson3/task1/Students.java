package com.epam.tanya_adnokulova.java.lesson3.task1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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
		String status = "Finished course. Passed time: ";
		
		if (endDate.after(currentDate)) {
			Calendar temp = endDate;
			endDate = currentDate;
			currentDate = temp;
			status = "Hasn't finished course. Remains: ";
		}

		//int deltaSec = currentDate.get(Calendar.SECOND) - endDate.get(Calendar.SECOND);
		int deltaMin = currentDate.get(Calendar.MINUTE) - endDate.get(Calendar.MINUTE);
		int deltaHour = currentDate.get(Calendar.HOUR) - endDate.get(Calendar.HOUR);
		int deltaDay = currentDate.get(Calendar.DAY_OF_MONTH)
				- endDate.get(Calendar.DAY_OF_MONTH);
		int deltaMonth = currentDate.get(Calendar.MONTH) - endDate.get(Calendar.MONTH);
		int deltaYear = currentDate.get(Calendar.YEAR) - endDate.get(Calendar.YEAR);

//		if (deltaSec < 0) {
//			deltaSec += 60;
//			deltaMin--;
//		}

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

		return String.format("The difference between dates:  %d year(s), %d month(s), %d day(s), %d hour(s), %d minute(s), %d second(s)%n",
						deltaYear, deltaMonth, deltaDay, deltaHour, deltaMin);
	}
	
	private  int getDaysInMonth(int year, int month) {
		   return new GregorianCalendar(year, month, 0).getActualMaximum(Calendar.DAY_OF_MONTH); 
		}

	public void printCurrentLearningStatus(String version) {
		List<Courses> courses = curriculum.getCourseList();
		// Calendar timeRemains;
		String status = "Hasn't finished course. Remains: ";

		Calendar currentDate = Calendar.getInstance();
		if (currentDate.get(Calendar.DATE) >= curriculum.getEndDate().get(
				Calendar.DATE)
				&& currentDate.get(Calendar.MONTH) >= curriculum.getEndDate()
						.get(Calendar.MONTH)
				&& currentDate.get(Calendar.YEAR) >= curriculum.getEndDate()
						.get(Calendar.YEAR)
				&& currentDate.get(Calendar.HOUR_OF_DAY) >= curriculum
						.getEndDate().get(Calendar.HOUR_OF_DAY)
				&& currentDate.get(Calendar.MINUTE) >= curriculum.getEndDate()
						.get(Calendar.MINUTE))
			status = "Finished course. Passed time: ";

		switch (version) {
		case "short":
			System.out.println(name
					+ " ("
					+ curriculum.getName()
					+ ") - "
					+ status
					+ (currentDate.get(Calendar.YEAR) - curriculum.getEndDate()
							.get(Calendar.YEAR))
					+ "years "
					+ (currentDate.get(Calendar.MONTH) - curriculum
							.getEndDate().get(Calendar.MONTH))
					+ "months "
					+ (currentDate.get(Calendar.DATE) - curriculum.getEndDate()
							.get(Calendar.DATE)));

			break;
		case "long":

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
