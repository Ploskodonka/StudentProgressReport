package com.epam.tanya_adnokulova.java.lesson3.task1;

public class Runner {

	public static void main(String[] args) {
		if (args.length != 1)
			System.out.println("Wrong number of arguments!");
		
		ShowProgress run = new ShowProgress();
		run.studentProgress(args[0]);
	}

}
