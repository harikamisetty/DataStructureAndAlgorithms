package com.hari.dsal.leetcode;


/*
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	
	Key point: We need to add a carry just as we do addition in arithmetic. A carry is a digit that is transferred from one column of digits to another column of more significant digits.

	For different cases:

	If there are remaining nodes (l1, l2) in both two linked lists, the result linked list node gets value from ((l1.val + l2.val + carry) % 10).
	If there is only one linked list has remaining node, the esult linked list node gets value ((l1.val + carry) % 10 or (l2.val + carry) % 10).
	If neither of linked list has remaining nodes, we should check if there is still carryover value.
	
 */
public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
                
        while (l1 != null && l2 != null) {
            int value = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode result = new ListNode(value);
            current.next = result;
            l1 = l1.next;
            l2 = l2.next;
            current = result;
        }
        
        while (l1 != null) {
            int value = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;            
            ListNode result = new ListNode(value);
            current.next = result;
            l1 = l1.next;
            current = result;            
        }
        
        while (l2 != null) {
            int value = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;     
            ListNode result = new ListNode(value);
            current.next = result;
            l2 = l2.next;
            current = result;            
        }        
        
        if (carry != 0) {
            ListNode result = new ListNode(carry);
            current.next = result;
            current = result;             
        }
        
        return dummy.next;        
    }
	
	public static void main(String[] args) {
		ListNode l1= new ListNode(243);
		ListNode l2= new ListNode(564);
		
		System.out.println(addTwoNumbers(l1, l2).val)
		
		;
		
	}

}
