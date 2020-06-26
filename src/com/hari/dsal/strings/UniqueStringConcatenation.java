package com.hari.dsal.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UniqueStringConcatenation {
	
	private String getBigUniqueString(String[] inputStr) {
		Map<Integer, String> resultsMap = new HashMap<>();
		
		for(int i=0;i<inputStr.length;i++) {
			if(isUniqueString(inputStr[i])) {
				resultsMap.put(inputStr[i].length(), inputStr[i]);
			}
		}
		if(resultsMap==null || resultsMap.size()==0)
			return null;
		
		TreeMap<Integer, String> lMap = new TreeMap<>(Collections.reverseOrder());
		lMap.putAll(resultsMap);
		
		List<Entry<Integer,String>> resList = lMap.entrySet()
										  .stream()										 
										  .limit(2)
										  .collect(Collectors.toList());
		
		return mapValues(resList);
	}
	
	
	private String mapValues(List<Entry<Integer,String>> lMap) {
		String res= "";
		
		for(Entry<Integer, String> val : lMap) {
			res+=val.getValue();
		}
		return res;
	}

	private boolean isUniqueString(String str) {
		// 3 ways
		// 1. Two loops comparing each character with remaining chars
		// 2. Sort the string and compare i with i-1 char
		// 3. boolean array with 26 length and update by each character
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		
		for(int i=1; i< charArr.length; i++) {
			if(charArr[i] == charArr[i-1])
				return false;
		}
		return true;
	}
	
	// SECOND Approch
	
	private int getMaxString(List<String> arr) {
		int[] result = new int[1];
		maxUnique(arr,0,"",result);
		
		return result[0];		
	}
	
	private void maxUnique(List<String> arr, int index, String current, int[] result) {
		
		if(index == arr.size() && uniqueCharCount(current) > result[0]) {
			result[0] = current.length();
			return;
		}
		if(index == arr.size()) {
			return;
		}
		maxUnique(arr, index+1, current, result);
		maxUnique(arr, index+1, current + arr.get(index), result);
	}


	private int uniqueCharCount(String s) {
		int[] counts = new int[26];
		for(char c:s.toCharArray()) {
			if(counts[c - 'a']++ >0) {
				return -1;
			}
		}		
		return s.length();
	}


	public static void main(String[] args) {
		String input[] = {"harii","venu","vinay","reddy","srini","abc"};
		UniqueStringConcatenation usc = new UniqueStringConcatenation();
		System.out.println(usc.getMaxString(Arrays.asList(input)));
		
	}
}
