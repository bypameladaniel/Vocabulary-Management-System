//Pamela Daniel 
//COMP249
//Assignment#3
//Due date: Monday April 15th 2024
import java.util.ArrayList;

public class Vocab {
	private String topic;
	
	private SinglyLinkedList words;
	
	public Vocab() {
		this.topic = null;
		this.words = null;
	}
	/**
	 * Parametrized constructor
	 * @param topic
	 */
	public Vocab(String topic) {
		this.topic = topic;
		this.words = new SinglyLinkedList();
	}
	/**
	 * method that gets the words
	 * @return
	 */
	public SinglyLinkedList getWords() {
		return this.words;
	}
	/**
	 * Getter that returns the topic
	 * @return topic
	 */
	public String getTopic() {
		return this.topic;
	}
	/**
	 * Adds a specific word to the linked list
	 * @param word
	 */
	public void addWords(String word) {
		words.addAtEnd(word);
	}
	/**
	 * Removes a specific word to the linked list
	 * @param word
	 */
	public void removeWords(String word) {
		words.removeValue(word);
	}
	/**
	 * Returns if the word is in the list or not
	 * @param word
	 * @return true is its there
	 */
	public boolean isThere(String word) {
		return words.isAlreadyThere(word);
	}
	/**
	 * Method that modifies the words
	 * @param oldWord
	 * @param newWord
	 */
	public void modifyWords(String oldWord, String newWord) {
		words.updateValue(oldWord, newWord);
	}
	/**
	 * Displays the words
	 */
	public void displayWords() {
		words.display();
		
	}
	/**
	 * Displays an array of words
	 * @return array of words
	 */
	public ArrayList<String> displayWordsOption9() {
		return words.displayOption9();
	}
	/**
	 * Displays an array of words starting with the same letter
	 * @param letter
	 * @return array of words with same letter
	 */
	public ArrayList<String> getLetterWord(String letter) {
		return words.letterWord(letter);
	}
}
