package com.lockedme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {

	private List<String> mainOptions = new ArrayList<>();
	private List<String> fileOptions = new ArrayList<>();
	private FileManager fileManager;

	public Display() throws IOException {
		addMainOptions();
		addFileOptions();
		this.fileManager = new FileManager();
		showWelcomeScreen();
		displayMainOptions();
	}

	private static void showWelcomeScreen() {
		System.out.println("---------------------------");
		System.out.println(" -- WELCOME -- ");
		System.out.println("Application: LockedMe.com");
		System.out.println("Developer: Connor");
		System.out.println("---------------------------");
	}

	private void addMainOptions() {
		mainOptions.add(" -- MAIN MENU -- ");
		mainOptions.add("Select an option from  below: ");
		mainOptions.add("(1) Display all files");
		mainOptions.add("(2) File management options");
		mainOptions.add("(3) Exit program");
	}

	private void addFileOptions() {
		fileOptions.add(" -- FILE OPTIONS MENU -- ");
		fileOptions.add("File management options are listed below:");
		fileOptions.add("(1) Add a file");
		fileOptions.add("(2) Delete a file");
		fileOptions.add("(3) Search for a file");
		fileOptions.add("(4) Back to main menu");
	}
	
	
	private String getUserInput() {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		return userInput;
	}

	private void displayMainOptions() throws IOException {

		// to print out all main options
		for (String option : mainOptions) {
			System.out.println(option);
		}

		String choice = getUserInput();
		switch (choice) {
		case "1": { // Display all files
			this.fileManager.displayAllFiles();
			break;
		}
		case "2": { // Display file management options
			displayFileManagement();
			break;
		}
		case "3": { // Close program
			System.out.println("Closing program...\nThanks");
			System.exit(0);
		}
		default: // if user inputs invalid input
			System.out.println("Invalid input... \nPlease try again\n");
		} // end of switch statement
		displayMainOptions();
	} // end of displayMain()

	private void displayFileManagement() throws IOException {

		for (String option : fileOptions) {
			System.out.println(option);
		}

		String choice = getUserInput();

		switch (choice) {
		case "1": { // add a file
			this.fileManager.addFile();
			break;
		}
		case "2": { // delete a file
			this.fileManager.removeFile();
			break;
		}
		case "3": { // search for a file
			this.fileManager.searchFile();
			break;
		}
		case "4": { // return to menu page
			System.out.println("Changing back to the main menu ... \n");
			displayMainOptions();
			break;
		}
		default:
			System.out.println("Invalid input... \nPlease try again");
		} // end of switch statement

		displayFileManagement();

	} // end of displayFileManagement();

}
