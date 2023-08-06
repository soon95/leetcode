public class No206ReverseListTest {


    public ListNode reverseList(ListNode head) {

        if (head==null||head.next==null){
            return head;
        }


        ListNode next = head.next;
        head.next=null;
        ListNode ans = reverseList(next);
        next.next=head;


        return ans;
    }


    public static void main(String[] args) {


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;


        No206ReverseListTest test = new No206ReverseListTest();

        ListNode ans = test.reverseList(node1);

        System.out.println(ans);

    }
}
