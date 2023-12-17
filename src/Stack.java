class StackException extends RuntimeException{    
		public StackException(String err) {
			super(err);
		}
}

public class Stack implements StackADT {
	
	private class Node{
		int element;
		Node next;
		
		public Node(int e, Node n){
			element = e;
			next = n;
		}
		
		public int getValue() {
			return element;
		}
		
		public Node getNext() {
			return next;
		}
	}
	
	// this is a reference to the head node of the linked list
	private Node top;
	
	// keep track of the number of elements in the stack
	private int size;
	
	public Stack(){
		top = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int size(){
		return size; 
	}
	
	// part 3: complete
	/** Adds a new element to the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(1)
	 * 
	 * @param o the integer to add to the top of the stack
	 */
	public void push(int o){
		// Checks if there is an element in the stack
		if (top == null)
		{
			// If there isn't add one and set the next value to null
			top = new Node(o, null);
		}
		else
		{
			// If there is one set newLowerNode to the current top value
			Node newLowerNode = top;
			// Make top the new Node and set the next node to newLowerNode
			top = new Node(o, newLowerNode);
		}
		size++;
	}
	
	// part 3: complete
	/** Removes an element from the top of the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(1)
	 *
	 * @return the integer that was at the top of the stack
	 * @throws StackException if the stack is empty
	 */
	public int pop() throws StackException{
		// If the stack is empty throw an exception
		if (top==null)
			throw new StackException("List is empty");
		else
		{
			// Assigns what top is to tempNode
			Node tempNode = top;
			// Make top the next node
			top = top.getNext();
			// Reduces the size of the stack since an element was removed
			size--;
			return tempNode.getValue();
		}
	}
	
	// part 3: complete
	/** Returns the integer at the top of the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(1)
	 * 
	 * @return the integer at the top of the stack
	 * @throws StackException is the stack is empty
	 */
	public int top() throws StackException{
		// If the stack is empty throw an exception
		if (isEmpty())
		{
			throw new StackException("List is empty");
		}
		// If the stack isn't empty returns the value of the top element
		return top.getValue();
	}
}
