package com.hari.dsal.math;

public class POW {
	
	 public double myPow(double x, int n) {
	        if(x == 1.0)
	            return 1.0;
	        if(n <= Integer.MIN_VALUE )
	            return -1.0;
	        if(n >= Integer.MAX_VALUE)
	        	return 0.0;
	        if(n == 0)
	        	return 1;
	           
	        if(n < 0)
	          return 1/ myPow(x,-n);
	        
	        double v = myPow(x,n/2);
	        
	        if(n %2 ==0)
	            return v*v;
	        else 
	            return v *v* x;
	       
	    }
	 
	 public static void main(String[] args) {
		POW pw = new POW();
		System.out.println(pw.myPow(2.0000, -2147483648));
		
	}

}
