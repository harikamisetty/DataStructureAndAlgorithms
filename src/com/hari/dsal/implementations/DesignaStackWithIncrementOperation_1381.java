package com.hari.dsal.implementations;

import java.util.ArrayList;
import java.util.List;

public class DesignaStackWithIncrementOperation_1381 {
	List<Integer> list;
	int maxSize;

	public DesignaStackWithIncrementOperation_1381(int maxSize) {
		this.list = new ArrayList<>();
		this.maxSize = maxSize;
	}

	public void push(int x) {
		if (list.size() >= maxSize) {
			return;
		} else {
			list.add(x);
		}
	}

	public int pop() {
		if (!list.isEmpty()) {
			return list.remove(list.size() - 1);
		} else {
			return -1;
		}
	}

	public void increment(int k, int val) {
		for (int i = 0; i < k && i < list.size(); i++) {
			list.set(i, list.get(i) + val);
		}
	}
}
