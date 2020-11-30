package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet_380 {
	private List<Integer> list;
    private Map<Integer, Integer> map;
     
    /** Initialize your data structure here. */
    public RandomizedSet_380() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
     
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
         
        int index = list.size();
        list.add(val);
        map.put(val, index);
         
        return true;
    }
     
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
         
        int indexRemove = map.get(val);
        int tail = list.get(list.size() - 1);
         
        swap(indexRemove, list.size() - 1);
        map.put(tail, indexRemove);
        list.remove(list.size() - 1);
        map.remove(val);
         
        return true;
    }
     
    /** Get a random element from the set. */
    public int getRandom() {
         
        if (list.isEmpty()) {
            return 0;
        }
         
        Random rand = new Random();
        int index = rand.nextInt(list.size());
         
        return list.get(index);
    }
     
    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    public static void main(String[] args) {
    	RandomizedSet_380 rs = new RandomizedSet_380();
    	rs.insert(10);
    	rs.insert(10);
    	rs.insert(20);
    	rs.remove(10);
    	for(int val : rs.list) {
    		System.out.println(rs.getRandom());
    	}
	}
}
