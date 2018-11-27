
public class MergeKListsTest {
	public static void main(String[] args) {
		//
		MyLinkedList l1=new MyLinkedList(5);
		l1.addNode(4);
		l1.addNode(1);
		
		MyLinkedList l2=new MyLinkedList(4);
		l2.addNode(3);
		l2.addNode(1);
		
		MyLinkedList l3=new MyLinkedList(6);
		l3.addNode(2);
		
//		ListNode[] lists= {l1.head,l2.head,l3.head};
		ListNode[] lists= {null};
		//
//		l1.printAllNode();
		mergeKLists(lists).printAll();;
	}
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length<1||!notOver(lists)) {
			return null;
		}
		
		int index=-1;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i]!=null&&lists[i].val<min) {
				min=lists[i].val;
				index=i;
			}
		}
		ListNode ans=new ListNode(min);
		ListNode current=ans;
		lists[index]=lists[index].next;
		
		while(notOver(lists)) {
			min=Integer.MAX_VALUE;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i]!=null&&lists[i].val<min) {
					min=lists[i].val;
					index=i;
				}
			}
			current.next=new ListNode(min);
			current=current.next;
			lists[index]=lists[index].next;
		}
		
		return ans;
	}
	public static boolean notOver(ListNode[] lists) {
		for (int i = 0; i < lists.length; i++) {
			if (lists[i]!=null) {
				return true;
			}
		}
		return false;
	}
}
