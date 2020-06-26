package com.hari.dsal.trees;

public class Node<T> implements Comparable<T>{
	
	private T item;
	private Node<T> next;
	
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	@Override
	public int compareTo(T arg) {
		
		if(arg == this.item) {
			return 0;
		} else {
			return 1;
		}
	}
}
