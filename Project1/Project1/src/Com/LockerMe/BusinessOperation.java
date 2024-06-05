package Com.LockerMe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BusinessOperation {
	
	// create method for listing file 
		public static void listOfFile() {
			//using file object 
			 File fileDirectory = new File("C:\\Users\\ARUN KUMAR\\eclipse-workspace\\Project1");
			  
			  if(fileDirectory.isDirectory()) {
			List <String> listFile = Arrays.asList(fileDirectory.list());
			
			Collections.sort(listFile);
			
			System.out.println("Sorting by filename in asscending order");
			
			for(String f : listFile) {
				
				System.out.println(f);
			}
		  }
			  else {
				  System.out.println(fileDirectory.getAbsolutePath() +" is not a directory");
			  }
			  BusinessOperation.mainMenu();
		}
	// create method for the createfile using file object 
	  public static void createFile() {
		  
		  Scanner scn = new Scanner(System.in); 
		  System.out.println("Enter the file name :");
		  String name = scn.nextLine();
		  //the name variable to store the file name
		  File file = new File("C:\\Users\\ARUN KUMAR\\eclipse-workspace\\Project1\\"+name);
		  
		  try {
			   if(file.createNewFile()) {
				   System.out.println("File was Created :");
				   BusinessOperation.fileMenuOperations();
			   }
			   else {
				   System.out.println("File is already exist:");
				   BusinessOperation.fileMenuOperations();
			   }
			   }catch(Exception e) {
				   System.out.println(e);
			   }
		  }
		  
	  //create method for the delete file 
	    public static void deleteFile() {
	    	String filename;
	    	Scanner sc = new Scanner(System.in);
	    	
	    	System.out.println("Enter the name of file to delete :");
	    	
	    	filename=sc.nextLine();
	    	File file=new File("C:\\Users\\ARUN KUMAR\\eclipse-workspace\\Project1\\"+filename);
	    	if(file.delete()) {
	    		System.out.println("File is deleted successfully");
	    		BusinessOperation.fileMenuOperations();
	    	}
	    	else {
	    		System.out.println("Ops !! File not found . please try again");
	    		BusinessOperation.fileMenuOperations();
	    	}
	    }
	    //create method for the search file
	    public static void searchFile() {
	    	System.out.println("Enter the file name for the search file");
	    	Scanner s1 = new Scanner(System.in);
	    	String folderName=s1.next();
	    	
	    	File file = new File("C:\\Users\\ARUN KUMAR\\eclipse-workspace\\Project1\\"+folderName);
	    	if(file.exists()) {
	    		System.out.println("File is Found");
	    		
	    		System.out.println(file.getAbsolutePath());
	    		BusinessOperation.fileMenuOperations();
	    	}
	    	else {
	    		System.out.println("File is not here (File Not Found)");
	    	}
	    	try {
	    		//creating printwriter class 
	    		PrintWriter pw = new PrintWriter(file);
	    		pw.println("saved");
	    		pw.close();
	    	}catch(FileNotFoundException e) {
	    		System.out.println(e);
	    	}
	    }
	    public static void mainMenu() {
	    	System.out.println("Please select the one of the following");
	    	System.out.println("1:List Down Files");
	    	System.out.println("2: Business Operation");
	    	System.out.println("3: Close Application");
	    }
	    
	    public static void fileMenuOperations() {
	    	
	    	System.out.println("Choose the following one of the options");
	    	System.out.println("1:Create a File");
	    	System.out.println("2:Search a File");
	    	System.out.println("3:Delete a File");
	    	System.out.println("4:Move to main menu");
	    	
	    	Scanner sc1 = new Scanner(System.in);
	    	try {
	    		int choice=sc1.nextInt();
	    		
	    		switch(choice) {
	    		case 1:
	    			System.out.println("You have selected to create a file");
	    			createFile();
	    			break;
	    			
	    		case 2:
	    			System.out.println("You have to selected for the search a file");
	    			searchFile();
	    			break;
	    			
	    		case 3:
	    			
	    			System.out.println("You have to selected for the delete a file");
	    			deleteFile();
	    			break;
	    			
	    		case 4:
	    			System.out.println("You have to selected for: Going to main menu");
	    			BusinessOperation.mainMenu();
	    			break;
	    	}
	    	
	    }catch(Exception e ) {
	    	System.out.println("Please enter valid number");
	    	BusinessOperation.fileMenuOperations();
	    }
	  }
	    public static void main(String[] args) {
	    	
	    	System.out.println("Welcome to Lockers Pvt.Ltd :");
	    	System.out.println("-----------------------------------------------------------");
	    	System.out.println("Developed by Arun Kumar");
	    	System.out.println("-----------------------------------------------------------");
	    	
	    	Scanner sc2 = new Scanner(System.in);
	    	
	    	BusinessOperation.mainMenu();
	    	while(true) {
	    		try {
	    			int choice=sc2.nextInt();
	    			
	    			switch(choice) {
	    			case 1:
	    				System.out.println("The files in ascending order");
	    				listOfFile();
	    				break;
	    			case 2:
	    				BusinessOperation.fileMenuOperations();
	    				break;
	    				
	    			case 3:
	    				System.out.println("Application closed");
	    				System.exit(choice);
	    				break;
	    			default:
	    				System.out.println("Please enter the valid number for the operations");
	    				break;
	    			
	    			}
	    		}catch(Exception e) {
	    			System.out.println("Please enter the valid number");
	    			BusinessOperation.main(args);
	    		}
	    	}
	    }

	}
	  


