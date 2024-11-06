//Pamela Daniel 
//COMP249
//Assignment#3
//Due date: Monday April 15th 2024

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileOutputStream;

/**
 * Driver class for the Vocabulary Control Center program.
 * This class provides a menu-driven interface for users to manage vocabulary topics and words.
 */
public class Driver {
	
	static Scanner keyboard = new Scanner(System.in);
	static DoublyLinkedList topics = new DoublyLinkedList();

	/**
     * Main method to run the Vocabulary Control Center program.
     * Displays the main menu and handles user input to execute various operations.
     *
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
        boolean exit = false;
        while (!exit) {
            System.out.println("----------------------------");
            System.out.println("Vocabulary Control Center");
            System.out.println("----------------------------");
            System.out.println("1  browse a topic");
            System.out.println("2  insert a new topic before another one");
            System.out.println("3  insert a new topic after another one");
            System.out.println("4  remove a topic");
            System.out.println("5  modify a topic");
            System.out.println("6  search topics for a word");
            System.out.println("7  load from a file");
            System.out.println("8  show all words starting with a given letter");
            System.out.println("9  save to file");
            System.out.println("0  exit");
            System.out.println("----------------------------");
            System.out.println("Enter Your Choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    browseTopic();
                    break;
                case 2:
                    insertTopicBeforeOne();
                    break;
                case 3:
                    insertTopicAfterOne();
                    break;
                case 4:
                    removeTopic();
                    break;
                case 5:
                    modifyTopic();
                    break;
                case 6:
                    searchTopicFromWord();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 8:
                    showAllWordFromLetter();
                    break;
                case 9:
                    saveFile();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("option out of range.try again.");
                    break;
            }
        }
        System.out.println("Exiting Vocabulary Control Center. Goodbye!");
        scanner.close();
        
    }
	/**
     * Allows the user to browse a chosen topic.
     * Displays a list of available topics and allows the user to select one to browse its words.
     */
	private static void browseTopic() {
	    boolean exit = false;
	    while (!exit) {
	        System.out.println("----------------------------");
	        System.out.println("        Pick a topic        ");
	        System.out.println("----------------------------");
	        topics.displayOption1(); // Display available topics
	        System.out.println("0 Exit");
	        System.out.println("----------------------------");
	        System.out.println("Enter Your Choice:");
	        int choice = keyboard.nextInt(); // Get user input
	        keyboard.nextLine(); // Consume newline

	        if (choice == 0) {
	            exit = true; // Exit if the user chooses 0
	        } else {
	            Vocab chosenTopic = topics.findTopicByNumber(choice); // Find the topic by its number
	            if (chosenTopic != null) {
	                System.out.println("----------------------------");
	                System.out.println("Topic: " + chosenTopic.getTopic()); // Display topic
	                chosenTopic.displayWords(); // Assuming you have a displayWords() method in your Vocab class
	            } else {
	                System.out.println("Invalid choice. Please choose a valid topic."); // Display error message if topic is not found
	            }
	        }
	    }
	}
	 /**
     * Allows the user to insert a new topic before an existing topic.
     * Prompts the user to select an existing topic and enter a new topic name and its words.
     */
	private static void insertTopicBeforeOne() {
		boolean exit = false;
		while(!exit) {
			System.out.println("----------------------------");
			System.out.println("        Pick a topic        ");
			System.out.println("----------------------------");
			topics.displayOption1(); // Display available topics
	        System.out.println("0 Exit");
	        System.out.println("----------------------------");
	        System.out.println("Enter Your Choice:");
	        int choice = keyboard.nextInt(); // Get user input
	        keyboard.nextLine(); // Consume newline
	        if (choice ==0) {
	        	exit = true;

			}else {
				 Vocab chosenTopic = topics.findTopicByNumber(choice);
				 System.out.println("Enter a topic name: ");
				 String newTempTopic = keyboard.next();
				 Vocab newTopic = new Vocab(newTempTopic);
				 topics.addBefore(chosenTopic, newTopic);
				 System.out.println("Enter a word - to quit press Enter:");
				 String answer;
				 do {
					 answer = keyboard.next();
					 if(!answer.equals("-"))
					 newTopic.addWords(answer);
				 }while(!answer.equals("-")); 
				 
			}
		}
	}
	/**
     * Allows the user to insert a new topic after an existing topic.
     * Prompts the user to select an existing topic and enter a new topic name and its words.
     */
	private static void insertTopicAfterOne() {
		boolean exit = false;
		while(!exit) {
			System.out.println("----------------------------");
			System.out.println("        Pick a topic        ");
			System.out.println("----------------------------");
			topics.displayOption1(); // Display available topics
	        System.out.println("0 Exit");
	        System.out.println("----------------------------");
	        System.out.println("Enter Your Choice:");
	        int choice = keyboard.nextInt(); // Get user input
	        keyboard.nextLine(); // Consume newline
	        if (choice ==0) {
	        	exit = true;

			}else {
				 Vocab chosenTopic = topics.findTopicByNumber(choice);
				 System.out.println("Enter a topic name: ");
				 String newTempTopic = keyboard.next();
				 Vocab newTopic = new Vocab(newTempTopic);
				 topics.addAfter(chosenTopic, newTopic);
				 System.out.println("Enter a word - to quit press Enter:");
				 String answer;
				 do {
					 answer = keyboard.next();
					 if(!answer.equals("-"))
					 newTopic.addWords(answer);
				 }while(!answer.equals("-")); 
				 
			}
		}
	}
	/**
     * Allows the user to remove an existing topic.
     * Prompts the user to select a topic to remove from the list of available topics.
     */
	private static void removeTopic() {
		boolean exit = false;
		while(!exit) {
			System.out.println("----------------------------");
			System.out.println("        Pick a topic        ");
			System.out.println("----------------------------");
			topics.displayOption1();
	        System.out.println("0 Exit");
	        System.out.println("----------------------------");
	        System.out.println("Enter Your Choice:");
	        int choice = keyboard.nextInt(); 
	        keyboard.nextLine(); 
	        if (choice ==0) {
	        	exit = true;

			}else {
				 Vocab chosenTopic = topics.findTopicByNumber(choice);
				 topics.removeValue(chosenTopic);
			}
		}
	}
	/**
     * Allows the user to modify an existing topic by adding, removing, or changing its words.
     * Prompts the user to select a topic and choose an operation to perform on its words.
     */
	private static void modifyTopic() {
		boolean exit = false;
		while(!exit) {
			System.out.println("----------------------------");
			System.out.println("        Pick a topic        ");
			System.out.println("----------------------------");
			topics.displayOption1();
	        System.out.println("0 Exit");
	        System.out.println("----------------------------");
	        System.out.println("Enter Your Choice:");
	        int choice = keyboard.nextInt(); 
	        keyboard.nextLine(); 
	        if (choice ==0) {
	        	exit = true;

			}else {
				 Vocab chosenTopic = topics.findTopicByNumber(choice);
				 System.out.println("----------------------------");
				 System.out.println("     Modify Topics Menu     ");
				 System.out.println("----------------------------");
				 System.out.println("  a add a word              ");
				 System.out.println("  r remove a word           ");
				 System.out.println("  c change a word           ");
				 System.out.println("  0 Exit                    ");
				 System.out.println("----------------------------");
				 System.out.println("Enter Your Choice:");
				 String answer = keyboard.next();
				 if(answer.equals("0")) {
					 exit = true;
				 }else {
					 switch (answer) {
					 case "a":
						 System.out.println("Type a word and press Enter, or press Enter to end input: ");
						 String addedWord = keyboard.next();
						 if(chosenTopic.isThere(addedWord)) {
							 System.out.println("Sorry, the word \"" + addedWord + "\" is already listed.");
						 }else {
							 chosenTopic.addWords(addedWord);
						 }
						 break;
					 case "r":
						 System.out.println("Type a word and press Enter, or press Enter to end input: ");
						 String removedWord = keyboard.next();
						 chosenTopic.removeWords(removedWord);
						 break;
					 case "c":
						 System.out.println("Type the word you'd like to change: ");
						 String oldWord = keyboard.next();
						 System.out.println("Type the new word you'd like to replace it with: ");
						 String newWord = keyboard.next();
						 if(!(chosenTopic.isThere(oldWord))) {
							 System.out.println("Sorry, the word \"" + oldWord + "\" is NOT listed.");
						 }else {
							 chosenTopic.modifyWords(oldWord, newWord);
						 }
						 break;
					 }
				 }
					
			}
		}
	}
	 /**
     * Allows the user to search for a word across all topics.
     * Prompts the user to enter a word and displays the topic(s) that contain the word.
     */
	private static void searchTopicFromWord() {
		boolean exit = false;
		while(!exit) {
			System.out.println("----------------------------");
			System.out.println(" Enter the word:            ");
	        String word = keyboard.next(); 
	        keyboard.nextLine(); 
	        boolean wordExist=false;
	        
	        for(int i = 1; i<=topics.getSize(); i++) {
	        	Vocab currentTopic = topics.findTopicByNumber(i);
	        	if(currentTopic.isThere(word)) {
	        		System.out.println("The word \"" + word + "\" is part of the topic \"" + currentTopic.getTopic() + "\" ");
	        		wordExist= true;
	        		break;
	        	}
	        }if(!(wordExist)) {
	        	System.out.println("That word is not listed yet.");
	        }
	        System.out.println("Do you want to search another word? (yes/no)");
	        String response = keyboard.next();
	        if (!response.equalsIgnoreCase("yes")) {
	            exit = true;
	        }
		}
	}
	 /**
     * Displays all words starting with a given letter across all topics.
     * Prompts the user to enter a letter and displays all words from all topics that start with the given letter.
     */
	private static void showAllWordFromLetter() {
		boolean exit = false;
		while(!exit) {
			System.out.println("----------------------------");
			System.out.println(" Enter the first letter:    ");
	        String letter = keyboard.next(); 
	        keyboard.nextLine(); 
	        ArrayList<String> allWords = new ArrayList<String>();
	        for(int i = 1; i<=topics.getSize(); i++) {
	        	Vocab currentTopic = topics.findTopicByNumber(i);
	        	for(String s : currentTopic.getLetterWord(letter)) {
	        		allWords.add(s);
	        	}
	        }
	        Collections.sort(allWords);
	        for(String s: allWords) {
	        	System.out.println(s);
	        }
	        System.out.println("----------------------------");
			System.out.println(" Another letter? (yes/no):  ");
			String response = keyboard.next();
	        if (!response.equalsIgnoreCase("yes")) {
	            exit = true;
	        }
		}
	
		
	}
	 /**
     * Loads topics and words from a file into the program.
     * Prompts the user to enter the name of the input file and reads topics and words from it.
     */
	private static void loadFromFile() {
		String path;
		BufferedReader reader = null;
		System.out.println("Enter the name of the input file: ");
		path = keyboard.next();
		try {
			
			reader = new BufferedReader(new FileReader(path));
			String line;
			Vocab currentTopic = new Vocab();
			while((line = reader.readLine())!= null) {
				if(line.startsWith("#")) {
					currentTopic = new Vocab(line.substring(1));

					topics.addAtTail(currentTopic);
				}else if(!line.isEmpty()) {
					currentTopic.addWords(line);
					
				}
			}
			System.out.println("Done loading.");
		}catch(FileNotFoundException e) {
			System.out.println(path + " was not found.");
		}catch(IOException e) {
			System.out.println("Error loading "+ path);
		}
	}
	/**
     * Saves topics and words to a file from the program.
     * Writes topics and words to an output file named "output_file.txt".
     */
	private static void saveFile() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream ("output_file.txt"));
			for(int i = 1; i<=topics.getSize(); i++) {
	        	Vocab currentTopic = topics.findTopicByNumber(i);
	        	writer.println("#" + currentTopic.getTopic());
	        	for(String s : currentTopic.displayWordsOption9()) {
	        		writer.println(s);
	        	}
	        	writer.println();
	        }
		}catch(FileNotFoundException e) {
			System.out.println("output_file.txt file was NOT found.");
		}finally {
			writer.close();
		}
	}

}
