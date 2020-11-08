package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class KClosestPoints_973 {
	
	 public int[][] kClosest(int[][] points, int K) {
	        int m = points.length;
	        int n = points[0].length;
	        Map<Integer,Double> resList = new HashMap<>();
	        int res [][] =new int[K][2];
	        
	        for(int i=0;i<m;i++){     
	           
	                int x = (points[i][0] - 0); 
	                int y = (points[i][1] - 0);
	                double d = Math.sqrt((x*x)+(y*y));
	                resList.put(i,d);
	            
	        }	        
	       
	        LinkedHashMap<Integer,Double> lmap = new LinkedHashMap<>();
	        resList.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x->lmap.put(x.getKey(),x.getValue()));
	       
	        List<Entry<Integer,Double>> countList = lmap.entrySet().parallelStream().limit(K).collect(Collectors.toList());
	        List<Integer> keys = new ArrayList<>();
	        for(Entry<Integer,Double> val :countList) {
	        	System.out.println(val.getKey() + ","+val.getValue()+"----------");
	        	keys.add(val.getKey());
	        }
	        int j= 0;
	        for(int i=0;i<m;i++){  
	        	if(keys.contains(i))
	        	res[j++] = points[i];
	        }
	        
	        return res;
	    }
	 public static void main(String[] args) {
		 KClosestPoints_973 kp = new KClosestPoints_973();
		//int[][] points = {{1,3},{-2,2}};
		 int[][] points = {{3,3},{5,-1},{-2,4}};
		int res[][] =kp.kClosest(points , 2);
		System.out.println(kp);
		for(int i=0; i<res.length;i++) {
			for(int j=0; j <res[0].length;j++) {
				System.out.print(res[i][j]);
			}
			System.out.println("\n");
		}
	}
}
