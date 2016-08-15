package codingProblems;

public class PrimeFactors 
{
	public static void getPrimeFact(int n)
	{
		// Print the number of 2s that divide n
	    while (n%2 == 0)
	    {
	    	System.out.print(" "+2);
	        n = n/2;
	    }
	 
	    // n is odd 
	    for (int i = 3; i <= Math.sqrt(n); i = i+2)
	    {
	        // While i divides n, print i and divide n
	        while (n%i == 0)
	        {
	        	System.out.print(" "+i);
	            n = n/i;
	        }
	    }
	 
	    // This condition is to handle the case when n is a prime number > 2
	    if (n > 2)
	        System.out.print(" "+n);
	}
	public static void main(String args[])
	{
		int n = 315;
		getPrimeFact(n);
	}
}
