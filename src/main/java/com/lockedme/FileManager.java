package com.lockedme;

import java.io.File;
import java.util.*;

public class FileManager {

	private String directoryPath = "src/main/resources/temp";
	private Set<String> listOfAllFiles = new TreeSet<>();
	
	public FileManager() {
		checkDirectory();
	}
	
	private void checkDirectory() {
		File checkFile = new File(directoryPath);
		if(!checkFile.exists()) {
			System.out.println("Creating a new directory ... \n");
			checkFile.mkdir();
		}
		
		String[] allFiles = checkFile.list();
		for(String fileName : allFiles) {
			listOfAllFiles.add(fileName);
		}
	}
	
	private String getFileName() {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		return userInput;
	}
	
	public void displayAllFiles() {
		if(listOfAllFiles.isEmpty()) {
			System.out.println("\nThe directory is empty ... \nAdd some files\n");
		} else {
			listOfAllFiles.forEach(fileName -> System.out.println(fileName));
		}
	}
	
	public void addFile() {
		System.out.print("Enter a new file name: ");
		String fileName = getFileName();
		File newFile = new File(directoryPath + "/" + fileName);
		try {
			System.out.println("\nCreating " + fileName + " ...\n");
			newFile.createNewFile();
		}catch (Exception e) {
			e.getStackTrace();
		} 
		checkDirectory();
	}
	
	public void removeFile() {
		System.out.print("Enter a file to remove: ");
		String fileName = getFileName();
		File fileToRemove = new File(directoryPath + "/" + fileName);
		if (fileToRemove.delete()) {
			System.out.println("\nRemoved file " + fileName + "\n");
			listOfAllFiles.remove(fileName);
		}else {
			System.out.println("\nFile " + fileName + " could not be removed. \nCheck the file name.");
		}
	}
	
	public void searchFile() {
		System.out.print("Enter a file to search for: ");
		String fileName = getFileName();
		boolean fileIsFound = false;
		
		for(String file:listOfAllFiles) {
			if(file.equals(fileName)) {
				fileIsFound = true;
				break;
			}
		}
		
		if(fileIsFound) {
			System.out.println("\nFile " + fileName + " was found!\n");
		} else {
			System.out.println("\nFile " + fileName + " could not be found. \nCheck the file name.\n");
		}
	}
	
}
