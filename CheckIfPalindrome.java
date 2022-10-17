import java.util.*;
public class CheckIfPalindrome {
	public static void main(String args[]){
		System.out.println("Enter String:");
		Scanner obj=new Scanner(System.in);
		if(isPalindrome(obj.nextLine())) {
        	System.out.println("True");
        }
        else {
        	System.out.println("False");
        }
		obj.close();
        

	}
   public static boolean isPalindrome(String st) {
	   //remove case sensitivity
	   st=st.toLowerCase();
	   //terminate condition
	   if(st.length()==1) {
			return true;
		}
	   else if(st.length()>1) {
		   char[] array=st.toCharArray();
		   if(array[0]==array[st.length()-1] ) {
			   isPalindrome(st.substring(1, st.length()-1));
		   
			   
		   }
		   else {
			   return false;
		   }
		
	   }
	   
	   return true;
	   
   }

	   
}
