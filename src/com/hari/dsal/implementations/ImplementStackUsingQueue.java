package com.hari.dsal.implementations;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
	Queue<Integer> queue;
	
	public ImplementStackUsingQueue() {
		this.queue = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		queue.add(x);
		// Convert Queue into Stack
		for(int i=0; i<queue.size()-1;i++) {
			queue.add(queue.poll());
		}
	}
	
	public void pop() {
		System.out.println(queue.poll());
	}
	
	public int top() {
		return queue.peek();
	}
	
	public boolean empty() {
		return queue.isEmpty();
	}
	
	public static void main(String[] args) {
		ImplementStackUsingQueue isq = new ImplementStackUsingQueue();
		isq.push(10);
		isq.push(20);
		isq.push(30);
		isq.push(40);
		isq.push(50);
		isq.pop();
		isq.pop();
	}
}
