package com.hari.dsal.Google;

import java.util.Stack;


/*
 * Use java.util.stack to store only opening brackets
 */
public class ValidParentheses_20 {
	
	public static boolean isValid(String s) { 
        Stack<Character> stack = new Stack<Character>(); 
        boolean isValid = false; 
         
        for (int i = 0; i < s.length(); i++) { 
            char ch = s.charAt(i); 
            if (ch == '(' || ch == '{' || ch == '[') { 
                stack.push(ch); 
            } else { 
                if (!stack.isEmpty() && isPair(stack.peek(), ch)) { 
                    stack.pop(); 
                } else { 
                    return false; 
                } 
            } 
        } 
         
        return stack.isEmpty(); 
    } 
 
    private static boolean isPair(char c1, char c2) { 
        return (c1 == '(' && c2 == ')')  
            || (c1 == '{' && c2 == '}') 
            || (c1 == '[' && c2 == ']'); 
    }
	
	public static void main(String[] args) {		
		System.out.println(isValid("{{{}}}"));		
	}
}
