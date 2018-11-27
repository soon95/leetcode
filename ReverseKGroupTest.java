import java.util.List;

public class ReverseKGroupTest {
	public static void main(String[] args) {
		//
		MyLinkedList l1=new MyLinkedList(5);
		l1.addNode(4);
		l1.addNode(3);
		l1.addNode(2);
		l1.addNode(1);
//		l1.printAllNode();
		int k=4;
		//
//		System.out.println(enough(l1.head, k));
//		reverseK(l1.head, k);
//		l1.printAllNode();
		newReverseKGroup(l1.head, k).printAll();
	}
	public static ListNode newReverseKGroup(ListNode head, int k) {
		ListNode currentNode = head;
        if(currentNode==null || k<0){
            return head;
        }
        int count = 0;
        while(currentNode!=null && count<k){
            currentNode = currentNode.next;
            count++;
        }
        if(count==k){
            currentNode = newReverseKGroup(currentNode,k);
            while(count-->0){
                ListNode temp = head.next;
                head.next = currentNode;
                currentNode = head;
                head = temp;
                System.out.println("*****************");
                head.printAll();
                System.out.println("*****************");
            }
            head = currentNode;
        }
        return head;
	}
	
	
	public static ListNode reverseKGroup(ListNode head,int k) {
		ListNode beg=new ListNode(Integer.MAX_VALUE);
		beg.next=head;
		int count=0;
		ListNode current=beg;
		while(enough(current, k+1)) {
			if (count%k==0) {
				reverseK(current, k);
			}
			current=current.next;
			
			count++;
		}
		return beg.next;
	}
	public static void reverseK(ListNode head,int k) {
		ListNode[] arr=new ListNode[k];
		ListNode current=head.next;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=current;
			current=current.next;
		}
		ListNode pre=current;
		
		head.next=arr[k-1];
		for (int i = k-1; i > 0; i--) {
			arr[i].next=arr[i-1];
		}
		arr[0].next=pre;
	}
	public static boolean enough(ListNode head,int k) {
		ListNode current=head;
		for (int i = 0; i < k; i++) {
			if (current==null) {
				return false;
			}
			current=current.next;
		}
		return true;
	}
}
