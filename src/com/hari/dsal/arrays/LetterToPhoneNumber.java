package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterToPhoneNumber {
	public static List<String> letterCombinations(String digits) {
	    HashMap<Character, String> map = new HashMap<>();
	    map.put('2', "abc");
	    map.put('3', "def");
	    map.put('4', "ghi");
	    map.put('5', "jkl");
	    map.put('6', "mno");
	    map.put('7', "pqrs");
	    map.put('8', "tuv");
	    map.put('9', "wxyz");
	 
	    List<String> l = new ArrayList<>();
	    if (digits == null || digits.length() == 0) {
	        return l;
	    }
	 
	    l.add("");
	 
	    for (int i = 0; i < digits.length(); i++) {
	        ArrayList<String> temp = new ArrayList<>();
	        String option = map.get(digits.charAt(i));
	 
	        for (int j = 0; j < l.size(); j++) {
	            for (int p = 0; p < option.length(); p++) {
	                temp.add(new StringBuilder(l.get(j)).append(option.charAt(p)).toString());
	            }
	        }
	 
	        l.clear();
	        l.addAll(temp);
	    }
	 
	    return l;
	}
	
	public static List<String> letterCombinations1(String digits) {
	    HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
	    dict.put('2',new char[]{'a','b','c'});
	    dict.put('3',new char[]{'d','e','f'});
	    dict.put('4',new char[]{'g','h','i'});
	    dict.put('5',new char[]{'j','k','l'});
	    dict.put('6',new char[]{'m','n','o'});
	    dict.put('7',new char[]{'p','q','r','s'});
	    dict.put('8',new char[]{'t','u','v'});
	    dict.put('9',new char[]{'w','x','y','z'});
	 
	    List<String> result = new ArrayList<String>();
	    if(digits==null||digits.length()==0){
	        return result;
	    }
	 
	    char[] arr = new char[digits.length()];
	    helper(digits, 0, dict, result, arr);
	 
	    return result;
	}
	 
	private static void helper(String digits, int index, HashMap<Character, char[]> dict, 
	                        List<String> result, char[] arr){
	    if(index==digits.length()){
	        result.add(new String(arr));
	        return;
	    }
	 
	    char number = digits.charAt(index);
	    char[] candidates = dict.get(number);
	    for(int i=0; i<candidates.length; i++){
	        arr[index]=candidates[i];
	        helper(digits, index+1, dict, result, arr);
	    }
	}
	
	// -------------- BRST SOLUTION -------------
	public static ArrayList<String> letterCombinations2(String digits) {
        ArrayList<String> result = new ArrayList<String>();
         
        if (digits == null) return result;
         
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
         
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, 0, sb, dict, result);
         
        return result;
    }
     
    private static void letterCombinationsHelper(String digits, int start, StringBuilder temp, String[] dict, ArrayList<String> result) {
        if (start >= digits.length()) {
            result.add(temp.toString());
            return;
        }
         
        // char to int
        int num = digits.charAt(start) - '0';
        for (int i = 0; i < dict[num].length(); i++) {
            temp.append(dict[num].charAt(i));
            letterCombinationsHelper(digits, start + 1, temp, dict, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
	
	public static void main(String[] args) {
		
		List<String> letterList1 = letterCombinations2("47");
		letterList1.forEach(str -> {
			System.out.println(str);
		});
	}
}


