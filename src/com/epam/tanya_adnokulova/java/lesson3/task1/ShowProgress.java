package com.epam.tanya_adnokulova.java.lesson3.task1;

public class ShowProgress {
	
//	public void studentProgress(String param) {
//	Students ivanov = new Students("Ivanov Ivan");
//	Curriculum j2eeDeveloper = new Curriculum("J2EE Developer", "15.02.2015 10:00");
//	Courses javaServlets = new Courses("Java Servlets Technology", 16);
//	Courses strutsFramework = new Courses("Struts Framework" , 24);
//	j2eeDeveloper.addCourse(javaServlets);
//	j2eeDeveloper.addCourse(strutsFramework);
//	ivanov.setCurriculum(j2eeDeveloper);
//	
//	Students petrov = new Students("Petrov Petr");
//	Curriculum javaDeveloper = new Curriculum("Java Developer", "20.02.2015 10:00");
//	Courses javaTechnologiesReview =  new Courses("Java Technologies Review", 8);
//	Courses jfcLibrary = new Courses("JFC/Swing Library", 16);
//	Courses jdbcTechnology = new Courses("JDBC Technology", 16);
//	javaDeveloper.addCourse(javaTechnologiesReview);
//	javaDeveloper.addCourse(jfcLibrary);
//	javaDeveloper.addCourse(jdbcTechnology);
//	petrov.setCurriculum(javaDeveloper);
//	
//	ivanov.printCurrentLearningStatus("short");
//	petrov.printCurrentLearningStatus("short");
		
		
//		if (param.equals("0")) {
//			ivanov.printCurrentLearningStatus("short");
//			petrov.printCurrentLearningStatus("short");
//		}
//		else {
//			ivanov.printCurrentLearningStatus("long");
//			petrov.printCurrentLearningStatus("long");
//		}
	//}

	public void studentProgress() {
		// TODO Auto-generated method stub
		Students ivanov = new Students("Ivanov Ivan");
		Curriculum j2eeDeveloper = new Curriculum("J2EE Developer", "01.03.2015 10:00");
		Courses javaServlets = new Courses("Java Servlets Technology", 16);
		Courses strutsFramework = new Courses("Struts Framework" , 24);
		j2eeDeveloper.addCourse(javaServlets);
		j2eeDeveloper.addCourse(strutsFramework);
		ivanov.setCurriculum(j2eeDeveloper);
		
		Students petrov = new Students("Petrov Petr");
		Curriculum javaDeveloper = new Curriculum("Java Developer", "01.03.2015 10:00");
		Courses javaTechnologiesReview =  new Courses("Java Technologies Review", 8);
		Courses jfcLibrary = new Courses("JFC/Swing Library", 16);
		Courses jdbcTechnology = new Courses("JDBC Technology", 16);
		javaDeveloper.addCourse(javaTechnologiesReview);
		javaDeveloper.addCourse(jfcLibrary);
		javaDeveloper.addCourse(jdbcTechnology);
		petrov.setCurriculum(javaDeveloper);
		
		ivanov.printCurrentLearningStatus("short");
		petrov.printCurrentLearningStatus("short");
		
		ivanov.printCurrentLearningStatus("long");
		petrov.printCurrentLearningStatus("long");
	}
}
