package com.hari.dsal.strings.more;

public class PalindromeNumber {
	
	 public boolean solve(int num) {
	     int sum = 0;
	     int orgnum = num;
	     while (num !=0){
	         sum = (sum *10) + num % 10;
	         num= num /10;
	     }
	     return orgnum ==sum;   
	    }
	
	public static void main(String[] args) {
		
		int num = 232;
		int res = 0;
		int orgNumber = num;

		while(num != 0){		
			res = res * 10 + num % 10;
			num = num / 10;
		}
		
		System.out.println("res ..........."+res);
		if(res== orgNumber) {
			System.out.println(" Same Number........");
		} else {
			System.out.println("Different Number ..........");
		}
		
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.solve(121));
	}

}
