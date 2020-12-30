package com.hari.dsal.Amazon;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks_1167 {
	 public int connectSticks(int[] sticks) {
	        int totalCost = 0;
	 
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	 
	        // add all sticks to the min heap.
	        for (int stick : sticks) {
	            pq.add(stick);
	        }
	       while(pq.size() > 0) {
	    	   System.out.print(pq.remove()+ ",");
	       }
	 
	        // combine two of the smallest sticks until we are left with just one.
	        while (pq.size() > 1) {
	            int stick1 = pq.remove();
	            int stick2 = pq.remove();
	            
	            int cost = stick1 + stick2;
	            totalCost += cost;
	            
	            pq.add(stick1 + stick2);
	        }
	 
	        return totalCost;
	    }
	 public static void main(String[] args) {
		int a[] = {1,8,3,5};
		MinimumCostToConnectSticks_1167 mt = new MinimumCostToConnectSticks_1167();
		System.out.println( "res="+ mt.connectSticks(a));
	}

}
