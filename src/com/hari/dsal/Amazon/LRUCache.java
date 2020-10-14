package com.hari.dsal.Amazon;

import java.util.HashMap;
/*
 * 
 * http://buttercola.blogspot.com/search?q=Delete+Node+in+a+Linked+List
 */
public class LRUCache {
	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head;
	private Node tail;
	private int len;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node temp = map.get(key);
			removeNode(temp);
			insertHead(temp);

			return temp.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node temp = map.get(key);
			// update the node
			temp.val = value;

			removeNode(temp);
			insertHead(temp);
			map.put(key, temp);

		} else { // do not contain
			Node temp = new Node(key, value);
			if (len < capacity) {
				insertHead(temp);
				map.put(key, temp);
				len++;
			} else if (len == capacity) {
				map.remove(tail.key);
				removeTail();
				insertHead(temp);
				map.put(key, temp);
			}
		}
	}

	private void removeNode(Node node) {
		Node curNode = node;
		Node preNode = node.pre;
		Node nextNode = node.next;

		if (preNode == null) {
			head = head.next;
			if (head == null)
				tail = head;
			else
				head.pre = null;
		} else if (nextNode == null) {
			tail = tail.pre;
			if (tail == null)
				head = tail;
			else
				tail.next = null;
		} else {
			preNode.next = nextNode;
			nextNode.pre = preNode;
		}
	}

	private void insertHead(Node node) {
		if (head == null) {
			head = node;
			tail = head;
			head.pre = null;
			tail.next = null;
		} else {
			node.next = head;
			head.pre = node;
			head = node;
			head.pre = null;
		}
	}

	private void removeTail() {
		tail = tail.pre;
		if (tail == null)
			head = tail;
		else
			tail.next = null;
	}

	// Doubly linked list
	private class Node {
		public int key;
		public int val;
		public Node pre;
		public Node next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
