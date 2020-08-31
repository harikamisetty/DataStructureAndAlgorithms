package com.hari.dsal.mislanious;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapOperations {

	public static void main(String[] args) {

		Map<String, String> myMap = new TreeMap<>();

		myMap.put("zoo", "line");
		myMap.put("apple", "sweet");
		myMap.put("test", "popcorn");
		myMap.put("tell", "how");
		myMap.put("mca", "exam");
		myMap.put("mango", "graps");

		System.out.println("Sort Map based on Key : " + myMap);

		Map<String, Integer> unSortedMap = new HashMap<>();
		unSortedMap.put("alex", 1);
		unSortedMap.put("david", 2);
		unSortedMap.put("elle", 3);
		unSortedMap.put("charles", 4);
		unSortedMap.put("brian", 5);

		System.out.println("Unsorted Map : " + unSortedMap);
		Map<String, Integer> treeMap = new TreeMap<>(unSortedMap);
		System.out.println("Sort by Key in Map :" + treeMap);

		LinkedHashMap<String, Integer> reverseSortedTreeMap = new LinkedHashMap<>();
		treeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEachOrdered(x -> reverseSortedTreeMap.put(x.getKey(), x.getValue()));
		System.out.println("Reverse Order Sort by Key in Map" + reverseSortedTreeMap);

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		System.out.println("Sorted by value in Map   : " + sortedMap);

		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
		System.out.println("Reverse Sorted by value in Map   : " + reverseSortedMap);

		Map<String, Integer> limitmap = new LinkedHashMap<>();
		reverseSortedMap.entrySet().stream().limit(3).forEachOrdered(x -> limitmap.put(x.getKey(), x.getValue()));
		System.out.println("Limit map details : " + limitmap);
	}
}