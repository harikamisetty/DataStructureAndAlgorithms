package com.hari.dsal.implementations;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter_362 {
	Queue<Integer> queue;

	/** Initialize your data structure here. */
	public DesignHitCounter_362() {
	   queue = new LinkedList<>();
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {

		queue.add(timestamp);

		removeOldHits(timestamp);
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		removeOldHits(timestamp);

		return queue.size();
	}

	public void removeOldHits(int currentTime) {
		int last = currentTime - 300;

		while (!queue.isEmpty() && last >= queue.peek()) {
			queue.remove();
		}
	}
}