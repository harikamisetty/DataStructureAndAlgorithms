package com.hari.dsal.strings.more;

public class ExcelNunberFromAGivenColumnName {
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("CDA"));
	}



	static int titleToNumber(String s) 
	{ 
	    // This process is similar to  
	    // binary-to-decimal conversion 
	    int result = 0; 
	    for (int i = 0; i < s.length(); i++) 
	    { 
	        result *= 26; 
	        result += s.charAt(i) - 'A' + 1; 
	    } 
	    return result; 
	} 
}
