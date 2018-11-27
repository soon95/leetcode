
public class MyLinkedList {
	ListNode head;
	
	public MyLinkedList(int x) {
		this.head=new ListNode(x);
	}
	
	public MyLinkedList(ListNode node) {
		this.head=node;
	}
	
	public void addNode(int x) {
		ListNode current=new ListNode(x);
		current.next=head;
		head=current;
	}
	
	public void printAllNode() {
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.val);
			current=current.next;
		}
	}
}
