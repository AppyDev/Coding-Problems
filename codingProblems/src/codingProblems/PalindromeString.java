package codingProblems;

public class PalindromeString {
	public static boolean isPalin(String text){
	       String reverse = reverse(text);
	       if(text.equalsIgnoreCase(reverse)){
	           return true;
	       }     
	       return false;
	    }
	    public static String reverse(String input){
	        if(input == null || input.isEmpty()){
	            return input;
	        }       
	        return input.charAt(input.length()-1)+reverse(input.substring(0, input.length()-1));
	    }
	public static void main(String args[]) {
        System.out.println("abba:" + isPalin("abba"));
        System.out.println("abcd:" + isPalin("abcd")); 
    }	
}
