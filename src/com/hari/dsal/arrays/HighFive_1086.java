package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighFive_1086 {
	
	 public int[][] highFive(int[][] items) {
		 
	     Map<Integer, List<Integer>> map = new HashMap<>();
	     List<int[]> res = new ArrayList<int[]>();
	     
	     for(int [] val : items) {
	    	 if(map.containsKey(val[0])) {
	    		 map.get(val[0]).add(val[1]);	    		
	    	 } else {
	    		 List<Integer> templist = new ArrayList();
	    		 templist.add(val[1]);
	    		 map.put(val[0],templist);	    		 
	    	 }
	     }
	     
	     for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
	    	 if(entry.getValue().size() >= 5) {
	    		 Collections.sort(entry.getValue(),Comparator.reverseOrder());
	    		 int sum =0;
	    		 for(int i=0;i<5;i++) {
	    			 sum += entry.getValue().get(i);
	    		 }
	    		 int[] temp = {entry.getKey(),sum/5};
	    		 res.add(temp);
	    	 }
	     }
	     int[][] resarr = new int[res.size()][2];
	     
	     for(int i=0;i<res.size();i++) {
	    	 resarr[i][0] = res.get(i)[0];
	    	 resarr[i][1] = res.get(i)[1];
	     }
	     
	  return resarr;   
	 }
	 
	 public static void main(String[] args) {
		 HighFive_1086 hf = new HighFive_1086();
		 int[][]items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		 
		 for(int[] val : hf.highFive(items)) {
			 System.out.println("\n");
			 for(int row : val) {
				 System.out.print(row +",");
			 }
		 }
	}

}
