package com.hari.dsal.strings.more;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		
		int num = 232;
		int res = 0;
		int orgNumber = num;

		while(num != 0){
			int temp = num % 10;
			res = res * 10 + temp;
			num = num / 10;
		}
		
		System.out.println("res ..........."+res);
		if(res== orgNumber) {
			System.out.println(" Same Number........");
		} else {
			System.out.println("Different Number ..........");
		}
	}

}
