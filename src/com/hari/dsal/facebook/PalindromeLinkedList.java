package com.hari.dsal.facebook;

import com.hari.dsal.linkedlist.ListNode;

// http://buttercola.blogspot.com/search?q=Reverse+Linked+List
public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		int len = getLength(head);
		ListNode mid = findMiddle(head);
		ListNode newHead;

		if (len % 2 == 0) {
			newHead = mid.next;
			mid.next = null;
		} else {
			ListNode dummyNode = new ListNode(mid.val);
			dummyNode.next = mid.next;
			newHead = dummyNode;
		}

		// Step 2: reverse the list
		newHead = reverseList(newHead);

		// Step 3: compare the list
		ListNode p = head;
		ListNode q = newHead;
		while (p != null && q != null) {
			if (p.val != q.val) {
				return false;
			}

			p = p.next;
			q = q.next;
		}

		return true;
	}

	private int getLength(ListNode head) {
		ListNode p = head;
		int len = 0;

		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(4);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;
		
		ListNode node3 = new ListNode(4);
		node2.next = node3;
		
		ListNode node4 = new ListNode(2);
		node3.next = node4;

		PalindromeLinkedList rll = new PalindromeLinkedList();
		System.out.println(rll.isPalindrome(head));
	}
}
