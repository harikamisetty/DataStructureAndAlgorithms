package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequencyAndValue {
	
	private int[] getNumbersByFrequency(int[] nums) {
		
		Map<Integer, Integer> tempMap = new LinkedHashMap<>();
		
		for(int val : nums) {
			if(tempMap.containsKey(val)) {
				tempMap.put(val,tempMap.get(val)+1);
			} else {
				tempMap.put(val,1);
			}
		}
		List<Integer> res = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {		
			
			for(int i=0;i<entry.getValue();i++) {
				res.add(entry.getKey());
			}
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
		SortByFrequencyAndValue sbfa = new SortByFrequencyAndValue();
		int[] nums = {1,1,5,5,5,2,2,2,1,1};
		
		
		for(int val : sbfa.getNumbersByFrequency(nums)) {
			System.out.print(val+",");
		}
	}
}
