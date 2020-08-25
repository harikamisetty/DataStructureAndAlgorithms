package com.hari.dsal.mislanious;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AmazonTopSellers {

	private static List<String> getTopSellers(List<String> sellersList, List<String> responseList, int howManyTop) {

		if (sellersList != null) {

			Map<String, Integer> data = new HashMap<String, Integer>();

			for (String seller : sellersList) {

				for (String review : responseList) {

					for (String test : review.split(" ")) {
						if (seller.equalsIgnoreCase(test)) {
							if (data.containsKey(seller)) {
								data.put(seller, data.get(seller) + 1);
							} else {
								data.put(seller, 1);
							}
						}
					}
				}
			}

			for (Map.Entry<String, Integer> entry : data.entrySet()) {
				System.out.println(entry.getKey() + "-----------" + entry.getValue());
			}

			// --------- Sort by Key -----------

			Map<String, Integer> sortedMapKey = new TreeMap<String, Integer>(data);
			System.out.println("Sorted Map  Key : " + sortedMapKey);

			Map<String, Integer> reverseSortedMapKey = new TreeMap<String, Integer>(Collections.reverseOrder());
			reverseSortedMapKey.putAll(data);
			System.out.println("Reverse Sorted Map   : " + reverseSortedMapKey);

			// LinkedHashMap preserve the ordering of elements in which they are inserted
			LinkedHashMap<String, Integer> sortedMapByKey = new LinkedHashMap<>();

			data.entrySet().stream().sorted(Map.Entry.comparingByKey())
					.forEachOrdered(x -> sortedMapByKey.put(x.getKey(), x.getValue()));

			System.out.println("Sorted Map Key  : " + sortedMapByKey);

			// LinkedHashMap preserve the ordering of elements in which they are inserted
			LinkedHashMap<String, Integer> sortedMapReverse = new LinkedHashMap<>();

			data.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
					.forEachOrdered(x -> sortedMapReverse.put(x.getKey(), x.getValue()));

			System.out.println("Sorted Map Revwese   : " + sortedMapReverse);

			// --------- Sort by Value -----------

			LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

			data.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

			System.out.println("Sorted Map   : " + sortedMap);

			// LinkedHashMap preserve the ordering of elements in which they are inserted
			LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

			// Use Comparator.reverseOrder() for reverse ordering
			data.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

			System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
			// Top 10 Keys List
			reverseSortedMap.keySet().stream().sorted().limit(10)
					.collect(Collectors.toMap(Function.identity(), reverseSortedMap::get));
		}
		return null;
	}

	public static void main(String[] args) {
		String s[] = { "hari", "koman", "nilu" };
		List<String> sellersList = Arrays.asList(s);
		String[] arg0 = { "hari is the best company to send the products", "koman is more better than hari",
				"nilu is better than hari", "koman is better than nilu", "hari koman  are three different companies" };
		List<String> responseList = Arrays.asList(arg0);
		int howManyTop = 2;
		;
		List<String> topSellers = getTopSellers(sellersList, responseList, howManyTop);

		int a[] = { 2, 4, 6, 7, 8, 9 };

		List myList = Arrays.asList(a);

		List<Integer> resList = (List<Integer>) myList.stream().map(x -> x).collect(Collectors.toList());

		// resList.forEach(e -> System.out.println(e));

		// topSellers.forEach(e -> System.out.println(e));
	}

}
