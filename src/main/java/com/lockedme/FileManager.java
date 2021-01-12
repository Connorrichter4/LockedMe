package com.lockedme;

import java.io.File;
import java.util.Scanner;

public class FileManager {

	private String directoryPath = "src/main/resources/temp";
	
	public FileManager() {
		checkDirectory();
	}
	
	private void checkDirectory() {
		File checkFile = new File(directoryPath);
		if(!checkFile.exists()) {
			System.out.println("Creating a new directory ... \n");
			checkFile.mkdir();
		}
	}
	
	private String getFileName() {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		return userInput;
	}
	
	public void addFile() {
		System.out.print("Enter a new file name: ");
		String fileName = getFileName();
		File newFile = new File(directoryPath + "/" + fileName);
		System.out.println(directoryPath + "/" + fileName);
		try {
			System.out.println("Creating " + fileName + " ...\n");
			newFile.createNewFile();
		}catch (Exception e) {
			e.getStackTrace();
		} 
	}
	
}
