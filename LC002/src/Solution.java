/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Take carry with you!
    	ListNode head = null;
		ListNode tail = null;
    	int carry = 0;
    	while(l1 != null || l2 != null || carry != 0) {
    		int v = carry;
    		if (l1 != null) {
    			v += l1.val;
    			l1 = l1.next;
    		}
    		if (l2 != null) {
    			v += l2.val;
    			l2 = l2.next;
    		}
    		if (v >= 10) {
    			carry = 1;
    			v = v % 10;
    		} else {
    			carry = 0;
    		}
    		ListNode current = new ListNode(v);
    		if (head == null) {
    			head = current;
    		}
    		if (tail != null) {
    			tail.next = current;
    		}
			tail = current;
    	}
    	return head;
    }
}