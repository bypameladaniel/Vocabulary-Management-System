//Pamela Daniel 
//COMP249
//Assignment#3
//Due date: Monday April 15th 2024

//Link of Topics
/**
 * This class handles the Double Linked List of topics. Such as adding a topic, removing, changing,displaying,etc.
 */
public class DoublyLinkedList {
	/**
	 * All the attributes of this class
	 */
	private Node head;
    private Node tail;
    private int counter;
   
    /**
     * Default constructor for creating a Doubly linked list with default values.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }
    
    /**
     * Finds the topics by number
     * @param number
     * @return
     */
    public Vocab findTopicByNumber(int number) {
        Node current = head;
        int count = 1;
        while (current != null) {
            if (count == number) {
                return current.value;
            }
            current = current.after;
            count++;
        }
        return null; // Return null if topic number is not found
    }

    // Add at head
    /**
     * Adds a value at the head of the list
     * @param value
     */
    public void addAtHead(Vocab value) {
    	Node newNode = new Node(value, null, head);
        
        if (head != null) {
            head.before = newNode;
        }
        
        head = newNode;
        counter++;
    }

    // Add at tail
    /**
     * Adds a value at the tail of the list
     * @param value
     */
    public void addAtTail(Vocab value) {
        Node temp = tail;
        tail = new Node(value, tail, null);
        if (head == null) {
            head = tail;
        } else {
            temp.after = tail;
        }

        counter++;
    }

    // Add after (while going from the head to tail)
    /**
     * Adds a value after a specific value
     * @param referenceValue
     * @param newValue
     */
    public void addAfter(Vocab referenceValue, Vocab newValue) {
        Node position = head;
        while (position != null && !position.value.equals(referenceValue)) {
            position = position.after;
        }
        if (position != null && position.value.equals(referenceValue)) {
            // if the ref value is the last element
            if (position.after == null) {
                addAtTail(newValue);
            } else {
                Node n = new Node(newValue, null, null); //HERE
                n.after = position.after;
                n.before = position;
                position.after.before = n;
                position.after = n;
                counter++;
            }
        }
    }
    /**
     * Adds a value before a specific value
     * @param referenceValue
     * @param newValue
     */
    public void addBefore(Vocab referenceValue, Vocab newValue) {
    	Node position = head;
    	if(head.value.equals(referenceValue)) {
    		addAtHead(newValue);
    		return;
    	}
    	while(position!=null && !position.after.value.equals(referenceValue)) {
    		position = position.after;
    	}
    	if(position !=null && position.after.value.equals(referenceValue) ) {
    		Node temp = position.after;
    		Node n = new Node(newValue, null, null);
    		position.after= n;
    		n.before = position;
    		n.after = temp;
    		temp.before = n;
    		counter++;
    	}
    }
    // Remove head
    /**
     * Removes the value at the head of the list
     * @return
     */
    public Vocab removeHead() {
        if (head == null) {
            return null ;
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            counter--;
            return temp.value;
        } else {
            Node temp = head;
            head = head.after;
            head.before = null;
            counter--;
            return null;
        }
    }

    // Remove tail
    /**
     * Removes the value at the tail of the list
     * @return
     */
    public Vocab removeTail() {
        if (tail == null) {
            return null;
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            counter--;
            return temp.value;
        } else {
            Node temp = tail;
            tail = tail.before;
            tail.after = null;
            counter--;
            return temp.value;
        }
    }
    // Remove value
    /**
     * Removes a specific value
     * @param value
     * @return
     */
    public Vocab removeValue(Vocab value) {

        if (head == null) {
            return null;
        } else if (head.value == value) {
            return removeHead();
        } else if (tail.value == value) {
            return removeTail();
        } else {
            Node position = head;
            while (position != null && !position.value.equals(value)) {
                position = position.after;
            }
            if (position != null) {
                position.before.after = position.after;
                position.after.before = position.before;

                position.before = null;
                position.after = null;

                counter--;
                return position.value;
            }
        }
        return null;
    }

    /**
     * Returns the size of the linked list
     * @return
     */
    public int getSize() {
    	return counter;
    }
    
    // Display
    /**
     * Displays the topics from head to tail
     */
    public void displayFromHeadToTail() {
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            System.out.println(counter);
            Node position = head;

            while (position != null) {
                System.out.println(position.value.getTopic());
                position = position.after;
            }
        }
    }
    /**
     * Display for option1
     */
    public void displayOption1() {
    	if (head == null) {
            System.out.println("The list is empty");
        } else {
            Node position = head;
            int count=0;
            while (position != null && count <= counter) {
            	count++;
                System.out.println( count + " " + position.value.getTopic());
                position = position.after;
            }
        }
    }
    /**
     * Display the topics from tail to head
     */
    public void displayFromTailToHead() {
        if (tail == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Displaying from Tail to Head " + counter + " element(s).");
            Node position = tail;
            while (position != null) {
                System.out.println(position.value);
                position = position.before;
            }
        }
    }
    /**
     * Displays the topic and its value
     * @param topic
     */
    public void displayWordsForTopic(String topic) {
        // Start traversing from the head
        Node current = head;
        
        // Traverse until either we find the topic or reach the end of the list
        while (current != null && !current.value.equals(topic)) {
            current = current.after;
        }
        
        // If current is null, the topic was not found in the list
        if (current == null) {
            System.out.println("Topic not found.");
        } else {
            // Display the associated words for the found topic
            System.out.println("Words associated with topic '" + topic + "':");
            current.words.display();
        }
    }
  /**
   * Private Inner class of the linked list class
   * Each topic is a node with a value, a previous reference and an after reference
   */
	private class Node {
		// Data
        private Vocab value;
        // Links
        private Node after;
        private Node before;
 
        
        // Singly linked list for associated words
        private SinglyLinkedList words; 
        
        /**
         * Parameterized constructor for nodes
         * @param value
         * @param before
         * @param after
         */
        public Node(Vocab value, Node before, Node after) {
            this.value = value;
            this.before = before;
            this.after = after;
            this.words = new SinglyLinkedList(); // Initialize the singly linked list for words
        }
        
    }
}
