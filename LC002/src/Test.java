
public class Test {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;

		ListNode m1 = new ListNode(5);
		ListNode m2 = new ListNode(6);
		ListNode m3 = new ListNode(4);
		m1.next = m2;
		m2.next = m3;
		
		Solution s = new Solution();
		ListNode head = s.addTwoNumbers(n1, m1);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
