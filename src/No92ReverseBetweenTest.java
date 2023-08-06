/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 */
public class No92ReverseBetweenTest {


    private boolean needReverse;

    private ListNode leftNode;

    private int curIndex;

    public ListNode reverseBetween(ListNode head, int left, int right) {


        if (head==null||head.next==null){
            return head;
        }

        this.curIndex++;

        if (this.curIndex==left){
            this.needReverse=true;
            this.leftNode=head;
        }

        if (this.needReverse){


            if (this.curIndex==right){

                this.needReverse=false;

                leftNode.next= reverseBetween(head.next, left, right);

                return head;

            } else {


                ListNode next = head.next;
                head.next=null;
                ListNode ans = reverseBetween(next, left, right);
                next.next=head;

                return ans;
            }


        } else {

            head.next= reverseBetween(head.next, left, right);

            return head;
        }

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


        int left=2;
        int right=4;

        No92ReverseBetweenTest test = new No92ReverseBetweenTest();
        ListNode ans = test.reverseBetween(node1, left, right);

        System.out.println(ans);


    }
}
