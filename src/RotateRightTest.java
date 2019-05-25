
public class RotateRightTest {
	public static void main(String[] args) {
		//
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		l1.printAll();
		//
		int k = 4;
		
		ListNode ans = rotateRight(l1, k);
		
		ans.printAll();
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		
		int len = 1;
		ListNode end = head;
		while(end.next != null) {
			end = end.next;
			len++;
		}
		System.out.println(len);
		
		k = k % len;
		
		int res = len - k - 1;
		
		ListNode cur = head;
		while(res > 0) {
			cur = cur.next;
			res--;
		}
		end.next = head;
		head = cur.next;
		cur.next = null;
		
		return head;
	}
}
