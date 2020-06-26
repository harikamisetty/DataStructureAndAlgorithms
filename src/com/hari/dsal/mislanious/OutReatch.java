package com.hari.dsal.mislanious;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutReatch {

	public static void main(String[] args) {

		Map<Integer, Integer> serverBusyMap = new HashMap<>();

		serverBusyMap.put(5, 30);
		serverBusyMap.put(125, 260);
		serverBusyMap.put(950, 1050);

		System.out.println(getServerAvailabletime(serverBusyMap, 280));

	}

	private static int getServerAvailabletime(Map<Integer, Integer> serverBusyMap, int targetTime) {

		LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();

		//Use Comparator.reverseOrder() for reverse ordering
		serverBusyMap.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue())
		    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		int prev =0;

		for(Map.Entry<Integer, Integer> entry : reverseSortedMap.entrySet()) {

			if(entry.getKey()-prev>= targetTime) {
				return prev;
			}
			prev = entry.getValue();
		}
		return 0;
	}

}
