package com.hari.dsal.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	private List<Interval> insertInterval(List<Interval> intervalList, Interval input) {

		if (intervalList == null || input == null)
			return null;
		List<Interval> res = new ArrayList<>();
		boolean found = false;
		for (Interval val : intervalList) {
			res.add(val);
			if (val.end < input.start && !found) {
				res.add(input);
				found = true;
			}
		}
		return res;
	}
	
	 public int[][] insert(int[][] intervals, int[] newInterval) {
		 
		 int[][] res = new int[intervals.length][intervals[0].length];
		 int[] prev = intervals[0];
		 
		 for(int i =1; i < intervals.length;i++) {
			 int[] curr = intervals[i];
			 if(isOverlap(prev, curr)) {
				 prev[0] = prev[0];
				 prev[1] = Math.max(prev[1],curr[1]);				
			 }else {
				 res[i] = prev;
				 prev = curr;
			 }
		 }	 
		 
		 return res;	        
	 }
	 
	private boolean isOverlap(int[] int1, int[] int2) {
		
		if (int1[1] >= int2[0])
			return true;
		return false;
	}

	public static void main(String[] args) {
		Interval int1 = new Interval(1, 2);
		Interval int2 = new Interval(2, 3);
		Interval int3 = new Interval(6, 7);

		List<Interval> intervalList = Arrays.asList(int1, int2, int3);
		InsertInterval ii = new InsertInterval();
		Interval input = new Interval(4, 5);
		for (Interval val : ii.insertInterval(intervalList, input)) {
			System.out.println(val.start + ":" + val.end);
		}
		
		int[][] intervals  = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4,8};
		int[][] res = ii.insert(intervals, newInterval );
		
		for(int i=0; i < res.length;i++) {
			//System.out.println(res[i][0]+"-------"+res[i][1]);
		}
	}
}
