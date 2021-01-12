package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {
	
	private List<String> mainOptions = new ArrayList<>();
	private List<String> fileOptions = new ArrayList<>();
	private FileManager fileManager;
	
	public Display(){
		addMainOptions();
		addFileOptions();
		this.fileManager = new FileManager();
		displayMainOptions();
	}
	
	private void addMainOptions() {
		mainOptions.add("Select an option from  below: ");
		mainOptions.add("(1) Display all files");
		mainOptions.add("(2) File management options");
		mainOptions.add("(3) Exit program");
	}
	
	private void addFileOptions() {
		fileOptions.add("File management options are listed below:");
		fileOptions.add("(1) Add a file");
		fileOptions.add("(2) Delete a file");
		fileOptions.add("(3) Search for a file");
		fileOptions.add("(4) Back to main menu");
	}
	
	private int getUserInput(int choice) {
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}
	
	private void displayMainOptions() {
		int choice = -1;
		while (choice != 3) {
			// to print out all main options
			for (String option : mainOptions) {
				System.out.println(option);
			}
			
			choice = getUserInput(choice);
			switch (choice) {
			case 1: { // Display all files
				break;
			}
			case 2: { // Display file management options
				displayFileManagement();
				break;
			}
			case 3: { // Close program
				System.out.println("Closing program...\nThanks");
				System.exit(0);
			}
			default: // if user inputs invalid input
				System.out.println("Invalid input... \nPlease try again\n");
			} // end of switch statement
		} // end of while loop
	} // end of displayMain()
	
	private void displayFileManagement() {
		int choice = -1;
		while (choice != 4) {
			for (String option : fileOptions) {
				System.out.println(option);
			}
			choice = getUserInput(choice);
			switch (choice) {
			case 1: { // add a file
				this.fileManager.addFile();
				break;
			}
			case 2: { // delete a file
				break;
			}
			case 3: { // search for a file
				break;
			}
			case 4: { // return to menu page
				System.out.println("Changing back to the main menu ... ");
				break;
			}
			default:
				System.out.println("Invalid input... \nPlease try again\n");
			} // end of switch statement
		} // end of while loop
	} // end of displayFileManagement();
	
}
