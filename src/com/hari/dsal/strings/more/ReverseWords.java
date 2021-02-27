package com.hari.dsal.strings.more;

import java.util.regex.Pattern;

public class ReverseWords {
	
	// Method to reverse words of a String 
		static String reverseWords(String str) 
		{ 

			// Specifying the pattern to be searched 
			Pattern pattern = Pattern.compile("\\s"); 

			// splitting String str with a pattern 
			// (i.e )splitting the string whenever their 
			// is whitespace and store in temp array. 
			String[] temp = pattern.split(str); 
			String result = ""; 

			// Iterate over the temp array and store 
			// the string in reverse order. 
			for (int i = 0; i < temp.length; i++) { 
				if (i == temp.length - 1) 
					result = temp[i] + result; 
				else
					result = " " + temp[i] + result;  // Adding Reversely the content.
			} 
			return result; 
		} 
		
		 public String solve(String sentence) {

		        if(sentence == null)
		            return null;

		        String[] sarr = sentence.split("\\s+");

		        int i =0, j=sarr.length -1;

		        while(i<j){
		            String temp = sarr[i];
		            sarr[i] = sarr[j];
		            sarr[j] = temp;
		            i++;j--;
		        }
		        return convertObjectArrayToString(sarr," ");
		    }
		 
		 private String convertObjectArrayToString(Object[] arr, String delimiter) {
				StringBuilder sb = new StringBuilder();
				for (Object obj : arr)
					sb.append(obj.toString()).append(delimiter);
				return sb.substring(0, sb.length() - 1);

			}

		// Driver methods to test above method 
		public static void main(String[] args) 
		{ 
			String s1 = "Welcome to geeksforgeeks"; 
			System.out.println(reverseWords(s1)); 

			String s2 = "I love Java Programming"; 
			System.out.println(reverseWords(s2)); 
			
			ReverseWords rw = new ReverseWords();
			System.out.println(rw.solve(s2));
		} 


}
