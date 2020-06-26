package com.hari.dsal.strings.more;

/*
 * Write a program that outputs the string representation of numbers from 1 to n. 
 * But for multiples of three it should output "Fizz" and multiples of five should be "Buzz". 
 * For numbers multiples of both should be like "FizzBuss".
 * 
 */
public class FizzBuzz {
	
	private static void printFizzAndBuzz(int n) {
		
		for (int i = 1; i <= n; i++) {
			if(i%3 == 0 && i%5 == 0) {
				System.out.println("FIZZBUZZ");
				continue;
			}else if(i%3 == 0) {
				System.out.println("FIZZ");
				continue;
			}else if(i%5 == 0)
				System.out.println("BUZZ");
			else
				System.out.println(i);
		}
	}
	
	
	public static void main(String[] args) {
		printFizzAndBuzz(15);
	}

}
