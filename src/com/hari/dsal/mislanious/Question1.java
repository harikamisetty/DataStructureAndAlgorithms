package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Question1 {
	
	  public List<String> mostFrequent(String helpText, List<String> wordsToExclude) {
		    // Write your code here
		  
		  List<String> res = new ArrayList<>();
		  Map<String, Integer> tempmap = new TreeMap<>();
		  String[] strs=  helpText.split("\\s+");
		  
		  for(String s : strs) {
			  s= s.toLowerCase();
			  if(!wordsToExclude.contains(s)) {
				  
				  if(tempmap.containsKey(s)) {
					  tempmap.put(s,tempmap.get(s)+1);
				  } else {
					  tempmap.put(s,1);
				  }	  
				  
			  }
		  }
		  
		  // Sort Map by value
		  LinkedHashMap<String,Integer> sortedMap = new LinkedHashMap<>();
		  tempmap.entrySet()
	        .stream()
	        .sorted(Map.Entry.comparingByValue())
	        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		  
		  String[] temps = new String[sortedMap.entrySet().size()];
		  int[] tempi = new int[sortedMap.entrySet().size()];
		  
		  
		  int value =0,i=0;
		  for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			  temps[i]= entry.getKey();
			  tempi[i] = entry.getValue();
			  i++;
		  }
		  value = tempi[tempi.length-1];
		  for(int j =tempi.length -1;j>=0;j--) {
			  if(value == tempi[j])
				  res.add(temps[j]);
		  }
		  
		  Collections.sort(res);
		  return res;
	  }
	
	public static void main(String[] args) {
		Question1 q1= new Question1();
		List<String> exclude = Arrays.asList("help", "fix", "too", "is", "of");
		List<String> res = q1.mostFrequent("Purchase Order Item Help Can't find item item is too much part of purchase need fix for image item delivered too fast purchase order too big is purchase order coming? Too big why",exclude);
		for(String str : res) {
			System.out.println(str);
		}
	}

}
