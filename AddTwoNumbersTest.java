//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) { val = x; }
//	
//}

//public class MyLinkedList{
//	ListNode head;
//	
//	public MyLinkedList(int x) {
//		this.head=new ListNode(x);
//	}
//	public MyLinkedList(ListNode node) {
//		this.head=node;
//	}
//	
//	public void addNode(int x) {
//		ListNode current=new ListNode(x);
//		current.next=head;
//		head=current;
//	}
//	
//	public void printAllNode() {
//		ListNode current=head;
//		while(current!=null) {
//			System.out.println(current.val);
//			current=current.next;
//		}
//	}
//}


public class AddTwoNumbersTest {
	public static void main(String[] args) {
		//��������
		MyLinkedList l1=new MyLinkedList(8);//��
//		l1.addNode(4);
//		l1.addNode(2);
		l1.addNode(5);					//С
//		l1.printAllNode();
		MyLinkedList l2=new MyLinkedList(4);//��
//		l2.addNode(6);
//		l2.addNode(5);					//С
		
		MyLinkedList ans=new MyLinkedList(AddTwoNumbers(l1.head, l2.head));
		ans.printAllNode();
	}
	
	public static ListNode AddTwoNumbers(ListNode l1,ListNode l2) {
		ListNode ans=new ListNode((l1.val+l2.val)%10);
		ListNode current=ans;
		int full=(l1.val+l2.val)/10;
		int temp;
		l1=l1.next;
		l2=l2.next;
		
		while(l1!=null&&l2!=null) {
			temp=l1.val+l2.val+full;
			if (temp/10==1) {
				current.next=new ListNode(temp%10);
				current=current.next;
				full=1;
			} else {
				current.next=new ListNode(temp);
				current=current.next;
				full=0;
			}
			
			l1=l1.next;
			l2=l2.next;	
		}
		
		while(l1!=null) {
			temp=l1.val+full;
			if (temp/10==1) {
				current.next=new ListNode(temp%10);
				current=current.next;
				full=1;
			} else {
				current.next=new ListNode(temp);
				current=current.next;
				full=0;
			}
			l1=l1.next;
		}
		
		while(l2!=null) {
			temp=l2.val+full;
			if (temp/10==1) {
				current.next=new ListNode(temp%10);
				current=current.next;
				full=1;
			} else {
				current.next=new ListNode(temp);
				current=current.next;
				full=0;
			}
			l2=l2.next;
		}
		
		if (full==1) {
			current.next=new ListNode(1);
		}
		
		return ans;
	}
}
