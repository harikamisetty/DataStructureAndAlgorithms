package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOperations {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 2, 9, 7, 6, 8, 22, 45);
		// Sort  a List
		Collections.sort(intList);

		for (int val : intList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");
		
		// Reverse Sort List
		Collections.sort(intList, Comparator.reverseOrder());

		for (int val : intList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");
		// Read First 3 element from a lost
		List<Integer> list = intList.parallelStream().limit(3).collect(Collectors.toList());

		for (int res : list) {
			System.out.print(res + ",");
		}
		System.out.println("\n");
		
		// Sort with ignore case
		List<String> strList = Arrays.asList("hari", "Koman", "Nilu", "apple", "zoo");
		Collections.sort(strList, new SortIgnoreCase());

		for (String val : strList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");

		// 3 ways to sort Strings in a ReverseOrder in case insensitive
		Collections.sort(strList, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(strList, Comparator.reverseOrder());
		Collections.sort(strList, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

		for (String val : strList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");
		List<String> listStr = strList.parallelStream().limit(3).collect(Collectors.toList());

		for (String res : listStr) {
			System.out.print(res + ",");
		}
		System.out.println("\n");
		
		// Position insert
		List<Integer> res = new ArrayList<>();
		res.add(0,3);
		res.add(0,5);
		for(int val : res) {
			System.out.println(val);
		}
		
		// Convert LIST to ARRAY
		int[] array = res.stream().mapToInt(Integer::intValue).toArray();
		int[] arrat2 = res.parallelStream().mapToInt(Integer::intValue).toArray();
		
		Map<String, List<String>> map = new HashMap<>();
		// Convert Map values to List
		List<List<String>> templ= new ArrayList<List<String>>(map.values()); 
		
		// MIN and MAX in a list
		int min = Collections.min(intList);
		int max = Collections.max(intList);	
		
		List[] arrlist = new List[3];
		
		for(int i=0;i<3;i++) {
			arrlist[i] = Arrays.asList(i+1,i+2);
		}
		
		for(List lists : arrlist) {
			System.out.println(lists);
		}	
		
	}
}

class SortIgnoreCase implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		return s1.toLowerCase().compareTo(s2.toLowerCase());
	}
}
