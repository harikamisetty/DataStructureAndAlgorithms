package com.hari.dsal.linkedlist;
// http://www.java2novice.com/data-structures-in-java/linked-list/singly-linked-list/

public class SingleLinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public void add(T element) {
		
		Node<T> nd = new Node<T>();
		nd.setItem(element);

		if(head == null) {
			head = nd;
			tail = nd;
		} else {
			tail.setNext(nd);
			tail=nd;
		}
	}
	
	public void addAfter(T element, T after) {
		
		Node<T> tmp = head;
		Node<T> refNode = null;
		
		while(true) {
			
			if(tmp == null) break;
			if(tmp.compareTo(after) == 0) {
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		
		if(refNode != null) {
			Node<T> nd= new Node<T>();
			nd.setItem(element);
			nd.setNext(tmp.getNext());
			if(tmp == tail) {
				tail = nd;
			}
			tmp.setNext(nd);
		}
	}
}
