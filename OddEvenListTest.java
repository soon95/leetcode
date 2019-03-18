
public class OddEvenListTest {
	public static void main(String[] args) {
		//≤‚ ‘ ˝æ›
		MyLinkedList l1=new MyLinkedList(6);
		l1.addNode(5);
		l1.addNode(4);
		l1.addNode(3);			
		l1.addNode(2);		
		l1.addNode(1);		
//		l1.printAllNode();
		MyLinkedList ans=new MyLinkedList(oddEvenList(l1.head));
		ans.printAllNode();
	}
	
	public static ListNode oddEvenList(ListNode head) {
		if (head==null) {
			return null;
		}
		ListNode ans=new ListNode(head.val);
		ListNode current=ans;
		ListNode temp=head;
		
		while(temp.next!=null&&temp.next.next!=null) {
			temp=temp.next.next;
			current.next=temp;
			current=current.next;
		}
		
		
		temp=head.next;
		if (temp!=null) {
			current.next=new ListNode(temp.val);
			current=current.next;
			
			while(temp.next!=null&&temp.next.next!=null) {
				temp=temp.next.next;
				current.next=new ListNode(temp.val);
				current=current.next;
			}
		}
		

		return ans;
	}
}
