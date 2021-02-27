package com.hari.dsal.strings;

import java.util.Arrays;

public class AnagramStrings {
    public boolean solve(String s0, String s1) {
        char[] ch1 = s0.toCharArray();
        char[] ch2 = s1.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

         String t1 = String.valueOf(ch1);
         String t2 = String.valueOf(ch2);

        return t1.equals(t2);
        
    }
    
    public static void main(String[] args) {
    	AnagramStrings as = new AnagramStrings();
    	System.out.println(as.solve("listen", "silent"));
	}
}
