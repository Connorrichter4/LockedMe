package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

	final private String directoryPath = "src/main/resources/temp";
	private Set<String> listOfAllFiles = new TreeSet<>();
	
	public FileManager() {
		checkDirectory();
		
	}
	
	private void checkDirectory() {
		File checkFile = new File(directoryPath);
		
		try {
			File[] allFiles = checkFile.listFiles();
			for(File fileName : allFiles) {
				if(!fileName.isFile()) {
					continue;
				}
				listOfAllFiles.add(fileName.getName());
			}
			
		} catch (Exception e) {
			if(!checkFile.exists()) {
				System.out.println("Creating a new directory ... \n");
				checkFile.mkdir();
			}
		}
		
	}
	
	private String getUserInput() {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		return userInput;
	}
	
	public void displayAllFiles() {
		if(listOfAllFiles.isEmpty()) {
			System.out.println("\nThe directory is empty ... \nAdd some files\n");
		} else {
			listOfAllFiles.forEach(fileName -> System.out.println(fileName));
			System.out.print("\n");
		}
	}
	
	public void addFile() {
		System.out.print("Enter an existing file path: ");
		String filePath = getUserInput();
		Path path;
		Path newFileName;
		
		try { // to check for invalid file paths
			path = Paths.get(filePath);
			newFileName = path.getFileName();
		} catch (Exception e) {
			System.out.println("Invalid file path ...\n");
			return;
		}
		
		if(!path.toFile().exists()) { // to check if the file exists
			System.out.println("File does not exist ... \n");
			return;
		}
		
		String newFilePath = directoryPath + "/" + newFileName;
		int inc = 0;
		while(Files.exists(Paths.get(newFilePath))) {
			inc++;
			newFilePath = directoryPath + "/" + newFileName + " (" + inc + ")"; 
		}
		
		Path newPath = Paths.get(newFilePath);
		Path newPathFileName = newPath.getFileName();
		
		try {
			Files.copy(path, Paths.get(newFilePath));
			System.out.println("Adding file " + newPathFileName + " ... \n");
		} catch(Exception e) {
			System.out.println("Unable to copy file to " + newFilePath);
		}
		
		checkDirectory();
	}
	
	public void removeFile() throws IOException {
		System.out.print("Enter a file to remove: ");
		String fileName = getUserInput();
		
		Path file = Paths.get(directoryPath + "/" + fileName);
		if (Files.deleteIfExists(file)) {
			System.out.println("\nRemoved file " + fileName + "\n");
			listOfAllFiles.remove(fileName);
		}else {
			System.out.println("\nFile " + fileName + " could not be removed. \nCheck the file name.");
		}
	}
	
	public void searchFile() {
		System.out.print("Enter a file name to search for: ");
		String regex = getUserInput();
		List<String> searchedList = new ArrayList<>();
		try {			
			Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			
			for (String fileName : listOfAllFiles) {
				Matcher matcher = pattern.matcher(fileName);
				if(!matcher.find()) {
					continue;
				}
				searchedList.add(fileName);
			}
			
			if(!searchedList.isEmpty()) {
				System.out.print("\n");
				searchedList.forEach(file -> System.out.println("File " + file + " was found!"));			
				System.out.print("\n");
			} else {
				System.out.println("\nFile " + regex + " could not be found. \nCheck the file name.\n");
			}
			
		} catch (Exception e) {
			System.out.println("\nFile " + regex + " could not be found. \nCheck the search query.\n");
		}
		
	}
	
}
