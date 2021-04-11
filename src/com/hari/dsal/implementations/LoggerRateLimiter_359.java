package com.hari.dsal.implementations;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_359 {
	Map<String, Integer> map = new HashMap<>(); // msg : lst print timestamp
	int limiter = 10;

	public LoggerRateLimiter_359() {

	}

	public boolean shouldPrintMessage(int timestamp, String message) {

		if (!map.containsKey(message)) {
			map.put(message, timestamp);
			return true;
		} else {
			if (timestamp - map.get(message) >= limiter) {
				map.put(message, timestamp);
				return true;
			}
		}
		return false;
	}
}
