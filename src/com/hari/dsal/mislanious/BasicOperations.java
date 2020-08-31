package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BasicOperations {
	public static void main(String[] args) {

		// String to Char array
		String str = "haribabu";
		char[] charArr = str.toCharArray();

		for (char ch : charArr) {
			System.out.print(ch + " ");
		}
		// Char array to String
		String str1 = String.valueOf(charArr);
		System.out.println(str1);

		// Array to List #1
		int A[] = { 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> list = Arrays.stream(A)
								   .boxed()
								   .collect(Collectors.toList());
		for(int pInt: list) {
			System.out.print(pInt + " ");
		}
		//#2
		List<Integer> arrayList = new ArrayList<>();
		for (int val : A) {
			arrayList.add(val);
		}
		//#3
		List<Integer> integerList = Arrays.asList(6,3,8,9,2,45,76);
		Collections.reverse(integerList);
		// List to Array		
		int[] intArr =  integerList.stream()
									.mapToInt(Integer::intValue)
									.toArray();
	
		// Sort List asending Order		
		Arrays.sort(A);
		Arrays.parallelSort(A); // Java 8
		Collections.sort(integerList);
		
		//Sort List in Decending Order
		Arrays.sort(A);
		Collections.sort(integerList);
		
		// String Array
	    String[] stringArray = 
	       new String[] { "FF", "PP", "AA", "OO", "DD" };

	    // Sorting String Array in descending order
	    Arrays.sort(stringArray, Collections.reverseOrder());
	    
	    //Sort a Set - There is no direct method. Convert Set to List and then List -> Set
	    HashSet<Integer> numberSet = new LinkedHashSet<>(Arrays.asList(15,11,9,55,47,18,1123,520,366,420));
	    List<Integer> numberList = new ArrayList<>(numberSet);
	    Collections.sort(numberList);
	    numberSet = new LinkedHashSet<Integer>(numberList);
	    
	    for(int val : numberSet) {
	    	System.out.print(val +",");
	    }
		
		//Sort Map Keys in asending Order
	    Map<Integer, String> map = new HashMap<>();
        
	    map.put(50, "Alex");
	    map.put(20, "Charles");
	    map.put(60, "Brian");
	    map.put(70, "Edwin");
	    map.put(120, "George");
	    map.put(10, "David");
	     
	    TreeMap<Integer, String> treeMap = new TreeMap<>(map);
	     
	    System.out.println(treeMap);
		
		
		// Sort Map Keys in decending Order
		
		
		//Sort Map values in Asending Order
	    HashMap<Integer, String> unSortedMap = new HashMap<>();
        
	    unSortedMap.put(50, "Alex");
	    unSortedMap.put(20, "Charles");
	    unSortedMap.put(60, "Brian");
	    unSortedMap.put(70, "Edwin");
	    unSortedMap.put(120, "George");
	    unSortedMap.put(10, "David");
	     
	    //LinkedHashMap preserve the ordering of elements in which they are inserted
	    LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
	     
	    unSortedMap.entrySet()
	        .stream()
	        .sorted(Map.Entry.comparingByValue())
	        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
	     
	    System.out.println(sortedMap);
		
		// Sort Map Values in Decending Order
		
		
		// Round the double and float values
		
		// Compare List values inside list itself
	    
	    // Char[] to String
	    char[] cArr = {'a','b','c'};
	    String s = new String(cArr);
	    
	    String str11 = String.valueOf(cArr);
		
	    String strLen = "haribabu";
		System.out.println(strLen.substring(2,strLen.length()-2));
		
		// List SORT and RANGE with stream
		List<Integer> intList = Arrays.asList(2,4,5,3,23,56,43);
		Object[] arr = intList.stream().sorted().limit(3).toArray();
		
		for(Object val : arr) {
			System.out.println(val.toString());
		}
		
		// integer to char
		char c = (char)65;
		//Char to String
		String sc = String.valueOf(c);
		
		Map<String, Object> testMap = new HashMap<>();
	//	testMap.compute("one", new Boolean(true).getClass());
		
	}// main end
} // Class end
