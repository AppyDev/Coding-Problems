
import java.util.Scanner;

public class LCS {
	public static void main(String[] args)
	{
		Scanner reader=new Scanner(System.in);
		System.out.println("Enter First string");
		String x = reader.next();
		System.out.println("Enter Second string");
		String y = reader.next();
		
		int xLen= x.length();
		int yLen=y.length();
		int i,j;
		
		 int[][] lcs = new int[xLen+1][yLen+1];	// Array to store subproblem length from dynamic programming
		 
		 // to calculate length using dynamic programming
		 for( i=0;i<=xLen;i++)
		 {
			 lcs[i][0]=0;		// first row elements to be 0
		 }
		 for(j=1;j<=yLen;j++)
		 {
			 lcs[0][j]=0;		// first column elements to be 0
		 }
		 for(i=0;i<yLen;i++)
		 {
			 System.out.print("\t"+ y.charAt(i));
		 }
		 System.out.println();
		 for (i=1;i<=xLen;i++)
		 {
			 System.out.print( x.charAt(i-1));
			 for(j=1;j<=yLen;j++)
			 {
				 if(x.charAt(i-1)==y.charAt(j-1))		// matching for the same character
					 lcs[i][j]=lcs[i-1][j-1]+1;			// if same character found increase the  length by 1
				 // find max( lcs[i-1][j],lcs[i][j-1])				 
				 else
					 lcs[i][j]= Math.max(lcs[i][j-1], lcs[i-1][j]);
				 System.out.print("\t"+lcs[i][j] );
			 }
			 System.out.println("");
		 }
		 System.out.println("Max length of lcs -> "+ lcs[xLen][yLen]);
		// int count=0;
		 //find the substring
		 String result="";
		 StringBuilder finalResult = new StringBuilder();
		  
		 for (i=xLen;i>0;i--)
		 {
			 for(j=yLen;j>0;j--)
			 {
				 if(lcs[i][j]>lcs[i][j-1] && lcs[i][j] > lcs[i-1][j])		// finding the largest count and from that character index
				 { 
					result=result+x.charAt(i-1);
					//after mach found going to lcs[i-1][j-1]					
				 	if(j>0)
				 		yLen=--j;
				 	break;
				 }
				 //changing to lcs[i-1][j]
				 else if(lcs[i-1][j]>=lcs[i][j-1])
				 { 
					//System.out.print("\tLCS["+i+"]["+j+"]elseif");
					 break;
				 }
				 //changing to lcs[i][j-1] if lcs[i-1][j]<lcs[i][j-1]
				 else
				 {
					 yLen=j;
						 
				 }
				 
					// lcs[i][j]=lcs[i][j-1];
				 //count++;
			 }
			 //System.out.println("");
		 }
		 
		 finalResult.append(result);
	 System.out.println("result -> " + finalResult.reverse());
		
	}

}
