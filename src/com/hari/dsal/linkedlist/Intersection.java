package com.hari.dsal.linkedlist;

public class Intersection {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		int lenA = getListLength(headA);
		int lenB = getListLength(headB);

		ListNode pA = headA;
		ListNode pB = headB;

		if (lenA > lenB) {
			for (int i = 0; i < lenA - lenB; i++) {
				pA = pA.next;
			}
		} else if (lenA < lenB) {
			for (int i = 0; i < lenB - lenA; i++) {
				pB = pB.next;
			}
		}

		while (pA != null && pB != null) {
			if (pA == pB) {
				return pA;
			}
			pA = pA.next;
			pB = pB.next;
		}

		return null;
	}

	private int getListLength(ListNode head) {
		int len = 0;
		ListNode p = head;

		while (p != null) {
			len++;
			p = p.next;
		}

		return len;
	}

	// #2 SOLUTION
	public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
		while (headA != null) {
			ListNode pB = headB;
			while (pB != null) {
				if (headA == pB)
					return headA;
				pB = pB.next;
			}
			headA = headA.next;
		}
		return null;
	}
	
	// #3 Solution
	 public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
		    ListNode a = headA;
		    ListNode b = headB;

		    while (a != b) {
		      a = a == null ? headB : a.next;
		      b = b == null ? headA : b.next;
		    }

		    return a;   
		 }

}
