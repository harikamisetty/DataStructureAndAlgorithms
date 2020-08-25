package com.hari.dsal.implementations;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	class Node {
		public int count = 0;
		public LinkedHashSet<Integer> keys = null;
		public Node prev = null, next = null;

		public Node(int count) {
			this.count = count;
			keys = new LinkedHashSet<>();
			prev = next = null;
		}
	}

	private int cap = 0;
	private HashMap<Integer, Integer> valueHash = null;
	private HashMap<Integer, Node> nodeHash = null;
	private Node head = null;

	public LFUCache(int capacity) {
		this.cap = capacity;
	}

	public int get(int key) {
		if (valueHash.containsKey(key)) {
			increaseCount(key);
			return valueHash.get(key);
		}
		return -1;
	}

	private void increaseCount(int key) {
		Node node = nodeHash.get(key);
		node.keys.remove(key);

		if (node.next == null) {
			node.next = new Node(node.count + 1);
			node.next.prev = node;
			node.next.keys.add(key);
		} else {

		}
	}
}
