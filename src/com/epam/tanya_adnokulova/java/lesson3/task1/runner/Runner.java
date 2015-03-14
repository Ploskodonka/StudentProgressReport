package com.epam.tanya_adnokulova.java.lesson3.task1.runner;


/**
 * 
 * @author Tanya Adnokulova
 * lesson 3 task 1
 *
 */

public class Runner {

	public static void main(String[] args) {
		if (args.length > 1)
			throw new  ArrayIndexOutOfBoundsException("Wrong number of arguments!\nEnter 0 for brief info, other value for full info!");
		
		ShowProgress run = new ShowProgress();	
		if (args.length == 0) {
			run.studentProgress("0");
		}
		else {
		run.studentProgress(args[0]);
		}
	}

}
