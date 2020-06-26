package com.hari.dsal.linkedlist;

//http://buttercola.blogspot.com/search?q=Linked+List+Cycle

public class CycleInLinkedlist {

	public boolean hasCycle(ListNode head) { // Determine if there is a Cycle Or not
		if (head == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next; // One Step
			fast = fast.next.next; // Two steps

			if (slow == fast)
				return true;
		}
		return false;
	}

	public ListNode detectCycle(ListNode head) { // Returns the Collision point
		// Find the collision point if the list has a cycle
		if (head == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				break;
		}

		// check if the list has no cycle
		if (fast == null || fast.next == null)
			return null;

		// find the entrance of the cycle once find the first Collision. Move slow to
		// head.
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	/*
	 * #3
	 * 
	 * Follow up: How to know the length of the cycle? It is not hard to come up
	 * with the solution. From the collision point in the cycle, use two pointers,
	 * one moves one step at a time while the other moves two at a time. Until they
	 * meet again, the number of steps is the length of the cycle.
	 * 
	 */

}
