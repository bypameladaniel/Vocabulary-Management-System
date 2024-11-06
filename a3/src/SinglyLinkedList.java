//Pamela Daniel 
//COMP249
//Assignment#3
//Due date: Monday April 15th 2024

//Link of words

import java.util.ArrayList;

public class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int counter;
	/**
	 * Default constructor
	 */
	public SinglyLinkedList() {
        head = null;
        counter = 0;
    }

    // Add to head
	/**
	 * Adds value at head
	 * @param value
	 */
    public void addAtHead(String value) {
        head = new Node(value, head);
        counter++;
    }

    //Add at the end
    /**
     * Adds value at tail
     * @param value
     */
    public void addAtEnd(String value) {
        if (head == null) {
            addAtHead(value);
        } else {
            Node position = head;
            while (position.next != null) {
                position = position.next;
            }

            Node n = new Node(value, null);
            position.next = n;

            counter++;
        }
    }
    //Checks if node is there already
    /**
     * Checks if a word is already present in the list
     * @param value
     * @return
     */
    public boolean isAlreadyThere(String value) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    /**
     * Changes a value thats in the list for another sting value
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean updateValue(String oldValue, String newValue) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(oldValue)) {
                current.value = newValue;
                return true; // Value updated successfully
            }
            current = current.next;
        }
        return false; // Value not found
    }


 // Add after a value
    /**
     * Adds value after a specific value
     * @param referenceValue
     * @param value
     */
    public void addAfter(String referenceValue, String value) {

        Node position = head;

        // Handle the case when referenceValue does not exist
        while (position != null && !position.value.equals(referenceValue)) {
            position = position.next;
        }

        if (position == null) { // value does not exist
            return;
        } else {
            Node n = new Node(value, position.next);
            position.next = n;
            counter++;
        }

    }

    // Add before a value. WE ONLY ADD IF THE REFERENCEVALUE exists
    /**
     * Adds a value before a specific value
     * @param referenceValue
     * @param newValue
     */
    public void addBefore(String referenceValue, String newValue) {
        if (head == null) {
            return;
        }
        if (head.value == referenceValue) {
            addAtHead(newValue);
        } else {
            Node position = head;

            while (position.next != null && !position.next.value.equals(referenceValue)) {
                position = position.next;
            }

            if (position.next != null && position.next.value.equals(referenceValue)) {
                position.next = new Node(newValue, position.next);
                counter++;
            }
        }
    }

    // Remove head
    /**
     * Removes the head of the list
     * @return
     */
    public String removeHead() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            counter--;
            temp.next = null;
            return temp.value;
        }
        return "no"; // Or throw an Exception
    }

    // Remove tail/last one
    /**
     * Removes the tail of the list
     * @return
     */
    public String removeLast() {
        if (head == null) {
            return "no";
        } else if (head.next == null) {
            return removeHead();
        } else {
            Node position = head;
            while (position.next.next != null) {
                position = position.next;
            }
            Node temp = position.next;
            position.next = null;
            counter--;
            return temp.value;
        }
    }

// Remove a value
    /**
     * Removes a specific value in the linked list
     * @param value
     * @return
     */
    public String removeValue(String value) {
        if (head == null) {
            return "This is an empty list.";
        }
        if (head.value == value) {
            return removeHead();
        } else {
            Node position = head;

            while (position.next != null && !(position.next.value.equals(value))) {
                position = position.next;
            }
            if (position.next != null && position.next.value.equals(value)) {
                Node temp = position.next;
                position.next = position.next.next;
                counter--;
                return temp.value;
            }else {
            	System.out.println("Sorry, there is no word: " + value);
            }
        }
        return "no";
    }

// Remove after a value
    /**
     * Removes a value after the specified value
     * @param value
     * @return
     */
    public String removeAfter(String value) {
        if (head == null) {
            return "no";
        } else {
            Node position = head;
            while (position != null && !position.value.equals(value)) {
                position = position.next;
            }
            if (position != null && position.next != null) {
                Node temp = position.next;
                position.next = position.next.next;
                return temp.value;
            }
        }
        return "no";
    }

// get size
    /**
     * Returns the size of the single linked list
     * @return
     */
    public int getSize() {
        return counter;
    }

    // Display
    /**
     * Displays the single linked list
     */
    public void display() {
        if (head == null) {
            System.out.println("Your list is empty.");
        } else {
            int index =0;
            Node position = head;
            while (position != null) {
            	index++;
                System.out.printf("%-30s", index +": " + position.value);
                position = position.next;

            }
        }
    }
    /**
     * Displays the linked lists 
     * @return
     */
    public ArrayList<String> displayOption9() {
    	Node position = head;
    	ArrayList<String> display = new ArrayList<String>();
		while (position != null) {
			display.add(position.value);
			position = position.next;
        }
		return display;
    }
    /**
     * Displays the linked list starting with a specific letter
     */
    public ArrayList<String> letterWord(String letter) {
    	Node position = head;
    	ArrayList<String> allWords = new ArrayList<String>();
		while (position != null) {
			if(position.value.startsWith(letter)) {
				allWords.add(position.value);
			}
            position = position.next;
        }
		return allWords;
	}
/**
 * Inner private class of nodes that all have a value and a reference for the node ater them
 */
	 private class Node {

	        // Data
	        private String value;
	        // Link
	        private Node next;
	        
	        /**
	         * Parameterized constructor for nodes
	         * @param value
	         * @param next
	         */
	        public Node(String value, Node next) {
	            this.value = value;
	            this.next = next;
	        }
	    }

	
}
