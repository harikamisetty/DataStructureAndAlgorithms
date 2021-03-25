package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransactionLogs {
	
	private List<Integer> getMostFromLogs(List<List<Integer>> data){
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> mapdata = new TreeMap<>();
		for(List<Integer> list : data) {
			for(int val : list) {
				if(!mapdata.containsKey(val)) {
					mapdata.put(val,1);
				} else {
					mapdata.put(val, mapdata.get(val));
				}
			}
		}
		
		LinkedHashMap<Integer, Integer> tempmap = new LinkedHashMap<Integer, Integer>();		
		mapdata.entrySet().stream().sorted().forEach(x -> tempmap.put(x.getKey(), x.getValue()));
		tempmap.entrySet().stream().limit(3).forEach(x-> res.add(x.getKey()));
				
		return res;
	}
	public static void main(String[] args) {
		int [][] data = {
				{345366, 89921, 45},
				{29323, 38239, 23},
				{38239, 345366, 15},
				{29323, 38239, 77},
				{345366, 38239, 23},
				{29323, 345366, 13},
				{38239, 38239, 23}
		};
		
		
		
		TransactionLogs tl = new TransactionLogs();

	}
}
