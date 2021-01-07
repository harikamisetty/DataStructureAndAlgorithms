package com.hari.dsal.linkedlist;

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) { // Best Solution but doesn't work for all scenarios
		// check if the linked list is null
		if (l1 == null && l2 == null)
			return null;

		// convert digits into integer
		long num1 = toInteger(l1);
		long num2 = toInteger(l2);

		// calculate the sum
		long sum = num1 + num2;

		// construct new linked list
		ListNode result = new ListNode(0);
		ListNode head = result;

		do {
			int digit = (int) (sum % 10);
			sum /= 10;

			// Append the digit to the linked list
			ListNode node = new ListNode(digit);
			head.next = node;
			head = node;
		} while (sum != 0);

		return result.next;
	}

	// convert digits to integers
	private static long toInteger(ListNode list) {
		long num = 0;
		int i = 0;
		while (list != null) {
			num += list.val * Math.pow(10, i++);
			list = list.next;
		}
		return num;
	}
	
	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // check if the linked list is null
        if (l1 == null && l2 == null) return null;
         
        int carry = 0;
         
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = new ListNode(0);
        ListNode head = p3;
         
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
             
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
             
            int d3 = carry % 10;
            carry /= 10;
             
            head.next = new ListNode(d3);
            head = head.next;
        }
         
        if (carry == 1) {
            head.next = new ListNode(1);
            head = head.next;
        }
         
        return p3.next;
    }
	
		
		public static void main(String[] args) {
			
			ListNode head = new ListNode(1);
			ListNode node1 = new ListNode(2);
			head.next = node1;

			ListNode node2 = new ListNode(3);
			node1.next = node2;

			node2.next = null;
			
			ListNode heada = new ListNode(1);
			ListNode nodea1 = new ListNode(2);
			heada.next = nodea1;

			ListNode nodea2 = new ListNode(3);
			nodea1.next = nodea2;

			nodea2.next = null;
			
			ListNode resNode = addTwoNumbers1(head, heada);
			
			while(resNode.next != null) {
				System.out.print(resNode.val);
				resNode = resNode.next;
				//resNode.next = resNode.next.next;
			}
			System.out.print(resNode.val);
	}

}
