package com.hari.dsal.Amazon;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream_295 {

	Queue<Long> small = new PriorityQueue<>(), large = new PriorityQueue<>();

	public FindMedianFromDataStream_295() {

	}

	public void addNum(int num) {
		large.add((long) num);
		small.add(-large.poll());
		
		if (large.size() < small.size())
			large.add(-small.poll());
	}

	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
	}
	
	public static void main(String[] args) {
		FindMedianFromDataStream_295 fm = new FindMedianFromDataStream_295();
		fm.addNum(20);
		fm.addNum(30);
		fm.addNum(40);
		System.out.println(fm.findMedian());
	}
}
