package com.hari.dsal.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	private List<Interval> insertInterval(List<Interval> intervalList, Interval input) {
		// Sort the list
		Collections.sort(intervalList,new IntervalComparator());
		
		if (intervalList == null || input == null)
			return null;
		List<Interval> res = new LinkedList<>();
		int i =0;
		
		// Find the location
		while(i< intervalList.size() && intervalList.get(i).end < input.start) {
			res.add(intervalList.get(i++));
		}
		// Insert and merge by updating same input
		while (i < intervalList.size() && intervalList.get(i).start <= input.end) {
			input = new Interval(Math.min(input.start, intervalList.get(i).start),
					Math.max(input.end, intervalList.get(i).end));
			i++;
		}
		
		res.add(input);
		// Add remaining 
		while(i < intervalList.size()) {
			res.add(intervalList.get(i));
			i++;
		}
		
		return res;
	}
	
	private class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
		
	}
	
	
	// With Arrays
	 public int[][] insert(int[][] intervals, int[] newInterval) {
		 
		 Arrays.sort(intervals, new IntervalComparator1());
		 
		 int[][] res = new int[intervals.length+1][intervals[0].length];
		 
		 int i=0;
		 
		 while(i < intervals.length && intervals[i][1] < newInterval[0]) {
			 res[i] = intervals[i];
			 i++;
		 }
		 int k = i;
		 while(i < intervals.length && intervals[i][0]<= newInterval[1]) {
			 newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
			 newInterval[1] = Math.max(intervals[i][1],newInterval[1]);	
			 i++;
		 }
		 
		 i=k;
		 res[i++] = newInterval;
		
		 while(i < intervals.length) {
			 res[i] = intervals[i];
			 i++;
		 }
		 return res;	        
	 }
	 
	 public int[][] insert1(int[][] intervals, int[] newInterval) {
		 
		 Arrays.sort(intervals, new IntervalComparator1());
		 
		 List<int[]> tempList = new ArrayList<>();
		 int[] prev = null;//intervals[0];
		 
		 for(int i =0; i < intervals.length;i++) {
			 prev = intervals[i];
			 if(isOverlap(prev, newInterval)) {
				 newInterval[0] = Math.min(prev[0],newInterval[0]);
				 newInterval[1] = Math.max(prev[1],newInterval[1]);
				 
			 }
			 tempList.add(prev);
		 }
		// tempList.add(prev);
		 int[][] res = new int[tempList.size()][intervals[0].length];
		 int i =0;
		 
		 for(int[] val : tempList) {
			 res[i++] = val;
		 }
		 return res;		 
	 }
	 
	 private boolean isOverlap(int[] int1, int[] int2) {			
			if (int1[1] >= int2[0])
				return true;
			return false;
		}

	private class IntervalComparator1 implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		}
	}

	public static void main(String[] args) {
		Interval int1 = new Interval(1, 3);
		//Interval int2 = new Interval(2, 3);
		Interval int3 = new Interval(6, 9);

		List<Interval> intervalList = Arrays.asList(int1, int3);
		InsertInterval ii = new InsertInterval();
		Interval input = new Interval(2, 5);
		for (Interval val : ii.insertInterval(intervalList, input)) {
			System.out.println(val.start + ":" + val.end);
		}
		
		int[][] intervals  = {{1,3},{6,9}};
		int[] newInterval = {2,5};
		int[][] res = ii.insert1(intervals, newInterval );
		
		for(int i=0; i < res.length;i++) {
			System.out.println(res[i][0]+"-------"+res[i][1]);
		}
		
		int[][] intervals1  = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval1 = {4,8};
		int[][] res1 = ii.insert1(intervals1, newInterval1);
		
		for(int i=0; i < res1.length;i++) {
			System.out.println(res1[i][0]+":"+res1[i][1]);
		}
	}
}
