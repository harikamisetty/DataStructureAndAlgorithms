package com.hari.dsal.interval;

import java.util.Arrays;
import java.util.List;

public class PrintIntervals {	
	
	public static void main(String[] args) {
		Interval int1 = new Interval(1,4);
		Interval int2 = new Interval(2,3);
		Interval int3 = new Interval(6,7);
		Interval int4 = new Interval(7,9);
		Interval int5 = new Interval(8,10);
		Interval int6 = new Interval(10,14);
		Interval int7 = new Interval(11,14);
		Interval int8 = new Interval(12,16);
		Interval int9 = new Interval(16,24);
		Interval int10 = new Interval(20,24);
		
		List<Interval> intervalList = Arrays.asList(int1,int2,int3,int4,int5,int6,int7,int8,int9,int10);
		
		printInterVals(intervalList);		
	}

	private static void printInterVals(List<Interval> intervalList) {
		
		for(Interval interval : intervalList) {
			System.out.println(interval.start + " : " + interval.end);
		}
	}
}
