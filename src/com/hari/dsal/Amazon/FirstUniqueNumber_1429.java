package com.hari.dsal.Amazon;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUniqueNumber_1429 {
	Set<Integer> all = new HashSet<>();
	Set<Integer> unique = new LinkedHashSet<>();

	public FirstUniqueNumber_1429(int[] nums) {
		for (int n : nums) {
			if (all.contains(n)) {
				unique.remove(n);
			} else {
				all.add(n);
				unique.add(n);
			}
		}
	}

	public int showFirstUnique() {
		if (unique.size() > 0) {
			return unique.iterator().next();
		}
		return -1;
	}

	public void add(int value) {

		if (all.contains(value)) {
			unique.remove(value);
		} else {
			all.add(value);
			unique.add(value);
		}
	}
	
	// #2 Solution
 /*   
   HashMap<Integer, Integer> map;
    Queue<Integer> queue;

    public FirstUniqueNumber_1429(int[] nums) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty()) {
            int num = queue.peek();
            int freq = map.get(num);
            if (freq > 1) {
                queue.poll();
            } else {
                return num;
            }
        }
        return -1;
    }

    public void add(int value) {
        if (map.containsKey(value)) {
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
            queue.add(value);
        }
    }*/
}
