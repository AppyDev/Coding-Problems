import java.util.List;
import java.util.ArrayList;

public class listOfList {
    public List<Integer> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        for(int i=1; i<=numRows+1; i++){
            List<Integer> pascalRow = new ArrayList<Integer>();
            for(int j=1; j<=i;j++){
                if(j==1 || j==i){
                    pascalRow.add(1);
                }
                else{
                	//System.out.println(pascalTriangle.get(i-2).size());
                	for(int k=j-2; k < j-1; k++)
        			{
        				pascalRow.add((pascalTriangle.get(i-2).get(k)+
        				pascalTriangle.get(i-2).get(k+1)));
        			}  
                }
            }
            pascalTriangle.add(pascalRow);
        }        
        return pascalTriangle.get(numRows);
    }
    public static void main(String args[]){
    	listOfList l = new listOfList();
    	List<Integer> pascalTriangle = new ArrayList<Integer>();
    	pascalTriangle = l.generate(3);
    	System.out.print(pascalTriangle.get(0));
    	for(int i=1; i < pascalTriangle.size(); i++)
		{
			System.out.print("," + pascalTriangle.get(i));
		}
    		
    }	
}
