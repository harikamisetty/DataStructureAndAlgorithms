package com.hari.dsal.Amazon;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer_L138 {
	public Node copyRandomList(Node head) {
		Node resHead = null;
		if (head == null)
			return resHead;

		Map<Integer, Integer> addressMap = new HashMap<>();
		Node temp = head;
		int index = 0;
		while (temp != null) {
			addressMap.put(temp.hashCode(), index++);
			temp = temp.next;
		}

		temp = head;

		while (temp != null) {
			System.out.println(temp.val + "------" + addressMap.get(temp.random.hashCode()));
			temp = temp.next;
		}

		return resHead;
	}

	public Node copyRandomList1(Node head) {

		if (head == null) {
			return null;
		}

		// Creating a new weaved list of original and copied nodes.
		Node ptr = head;
		while (ptr != null) {

			// Cloned node
			Node newNode = new Node(ptr.val);

			// Inserting the cloned node just next to the original node.
			// If A->B->C is the original linked list,
			// Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
			newNode.next = ptr.next;
			ptr.next = newNode;
			ptr = newNode.next;
		}

		ptr = head;

		// Now link the random pointers of the new nodes created.
		// Iterate the newly created list and use the original nodes' random pointers,
		// to assign references to random pointers for cloned nodes.
		while (ptr != null) {
			ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
			ptr = ptr.next.next;
		}

		// Unweave the linked list to get back the original linked list and the cloned
		// list.
		// i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
		Node ptr_old_list = head; // A->B->C
		Node ptr_new_list = head.next; // A'->B'->C'
		Node head_old = head.next;
		while (ptr_old_list != null) {
			ptr_old_list.next = ptr_old_list.next.next;
			ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
			ptr_old_list = ptr_old_list.next;
			ptr_new_list = ptr_new_list.next;
		}
		return head_old;
	}

	public static Node initNode() {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		head.next = node1;
		head.random = node5;

		node1.next = node2;
		node1.random = head;

		node2.next = node3;
		node2.random = node2;

		node3.next = node4;
		node3.random = node3;

		node4.next = node5;
		node4.random = node1;

		node5.next = null;
		node5.random = node4;

		return head;

	}

	public static void main(String[] args) {
		CopyListwithRandomPointer_L138 clp = new CopyListwithRandomPointer_L138();
		clp.copyRandomList(initNode());
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
