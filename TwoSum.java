import java.util.*;
public class TwoSum {
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
        System.out.println("Enter target sum:");
        int target=s.nextInt();
        int[] output=twoSum(nums, target);
        System.out.print("Position: ");
        for(int i=0;i<output.length;i++) {
        	System.out.print(output[i]+" ");
        }
        s.close();
		
        

	}
	public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i!=j){
                    
                    return (new int[]{i,j});
                    
                }
            }
        }
        return (new int[]{0,0});
	}
	   
}
