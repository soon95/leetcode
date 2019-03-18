
public class SwapPairsTest {
	public static void main(String[] args) {
		//
		MyLinkedList l1=new MyLinkedList(4);
		l1.addNode(3);
//		l1.addNode(2);
//		l1.addNode(1);
		l1.printAllNode();
		//
		swapPairs(l1.head).printAll();
		
	}
	public static ListNode swapPairs(ListNode head) {
		if (head==null) {
			return null;
		}
		
		ListNode current=head;
		ListNode ans;
		if (current.next!=null) {
			ans=current.next;
			current.next=ans.next;
			ans.next=current;
			
		} else {
			return head;
		}
		current=ans;
		int count=1;
		while(current.next.next!=null) {
			if (count%2==0) {
				ListNode temp1=current.next;
				ListNode temp2=current.next.next;
				temp1.next=temp2.next;
				temp2.next=temp1;
				current.next=temp2;	
			}
			current=current.next;
			count++;
		}
		
		return ans;
	}
}
