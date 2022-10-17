package hello;
import java.util.*;
public class LargestNum {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array:");
        int  n = s.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < n; i++)
        {
            nums[i] = s.nextInt();
        }
        
		largestNum(nums);
        

	}
	public static void largestNum(int[] nums) {
		ArrayList<Integer> InttoChar=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            
               
              for(char c:Integer.toString(nums[i]).toCharArray())   {
            	  InttoChar.add(Character. getNumericValue(c));
              }
                
            
        }
       Collections.sort(InttoChar);
       String output=InttoChar.get(InttoChar.size()-1).toString();
        for(int i=InttoChar.size()-2;i>=0;i--) {
        	output=output+InttoChar.get(i).toString();
        }
        System.out.println("Largest Possible Num: "+output);
        
	}
	   
}
