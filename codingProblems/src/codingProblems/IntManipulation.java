package codingProblems;
import java.util.*;

public class IntManipulation {
	 public static boolean isPrimeNumber(int number) {
	        if (number == 2 || number == 3) {
	            return true;
	        }
	        if (number % 2 == 0) {
	            return false;
	        }
	        int sqrt = (int) Math.sqrt(number) + 1;
	        for (int i = 3; i < sqrt; i += 2) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	 public static void main(String args[]){
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter a number to check prime:");
		 int n=in.nextInt();
		 System.out.println(n+" is Prime:"+isPrimeNumber(n));
		 in.close();
	 }
}
