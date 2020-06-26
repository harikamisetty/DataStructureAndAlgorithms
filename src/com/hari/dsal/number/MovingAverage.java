package com.hari.dsal.number;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue;
    int n;
    int sum;
     
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        n = size;
        sum = 0;
    }
     
    public double next(int val) {
        queue.offer(val);
        double result = 0;
        sum += val;
        if (queue.size() <= n) {
            result = (double) sum / queue.size();
        } else {
            int remove = queue.poll();
            sum -= remove;
            result = (double) sum / n;
        }
         
        return result;
    }
    
    public static void main(String[] args) {
		
	}
}
