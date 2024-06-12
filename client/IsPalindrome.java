/**
 * This Java program checks if a given string
 * is a palindrome containing only numbers and letters.
 * @author Gradi Kayamba
 * @version 6/11/24
 */
public class IsPalindrome {
    /**
     * This method will check if a string is a palindrome.
     * @param string the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String string) {
    	if(string.length() == 0) return false;
        String str = string.toLowerCase(); // Change the string to lowercase
        LinkedStack<Character> stack = new LinkedStack<>(); // Create a new stack

        // Add each character to the stack
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
                stack.push(str.charAt(i));
            }
        }

        // Pop each character from the stack and compare it with the original string
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) != stack.pop()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String testStr = "r84adA48r";
        System.out.println("Is \"" + testStr + "\" a palindrome? " + isPalindrome(testStr));
    }
}
