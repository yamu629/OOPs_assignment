package hello;
import java.util.*;

public class Power {
	
		public static void main(String args[]){
			Scanner s = new Scanner(System.in);
	        System.out.print("Enter x:");
	        double  x = s.nextDouble();
	        System.out.print("Enter n:");
	        int  n = s.nextInt();
	        if(n<0) {
				x=1/x;
				n=-n;
	        }
			System.out.println(CalculatePow(x,n));
	        
	        

		}
		public static double CalculatePow(double x, int n) {
			//int pow_half=CalculatePow(x,n/2);
			if(n==0) {
				return 1;
			}
			
			if(n%2==0) {
				return (double)CalculatePow(x,n/2)*CalculatePow(x,n/2);
			}
			else  {
				return (double)CalculatePow(x,n/2)*CalculatePow(x,n/2)*x;
			}
			
		}
		   
	}



