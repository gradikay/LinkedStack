package stacks;

import java.util.EmptyStackException;
/**
 * This Generic Java program checks if a given string
 * is a palindrome containing only numbers and letters.
 * @author Gradi Kayamba
 * @version 6/11/24
 */
public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
	
	public LinkedStack()
	{
		topNode = null;
	} // end default constructor
	
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
//    topNode = new Node(newEntry, topNode); // Alternate code
	} // end push

	public T peek()
	{
		if (isEmpty())
			throw new EmptyStackException();
		else
         return topNode.getData();
	} // end peek

	public T pop()
	{
	   T top = peek();  // Might throw EmptyStackException
   // Assertion: topNode != null
      topNode = topNode.getNextNode();

	   return top;
	} // end pop

	public boolean isEmpty()
	{
		return topNode == null;
	} // end isEmpty
	
	public void clear()
	{
		topNode = null;  // Causes deallocation of nodes in the chain
	} // end clear

	private class Node
	{
      private T    data; // Entry in stack
      private Node next; // Link to next node

      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor

      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;	
      } // end constructor

      private T getData()
      {
         return data;
      } // end getData

      private void setData(T newData)
      {
         data = newData;
      } // end setData

      private Node getNextNode()
      {
         return next;
      } // end getNextNode

      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
	
	/**
	 * This method checks if a string is a palindrome.
	 * @param string the string to check
	 * @return true if the string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(String string) {
		
		String str = string.toLowerCase(); // Change the string to lowercase
		LinkedStack<Character> stack = new LinkedStack<>(); // Create a new stack
		
		// Add each character to the stack
		for(int i = 0; i < str.length(); i++) {
			
			if(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
				stack.push(str.charAt(i));
			}
			
		}
		
		// Pop each character from the stack and compare it with the original string
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
				if(str.charAt(i) != stack.pop())  {
					return false;
				}
			}
			
		}
		
		return true;
		
	}
	
	public static void main(String []args) {
		String testStr = "r4adAj4r";
        System.out.println("Is \"" + testStr + "\" a palindrome? " + isPalindrome(testStr));
		
	}
} // end LinkedStack
