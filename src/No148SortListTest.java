import java.util.List;

/**
 * 148. 排序链表
 * https://leetcode.cn/problems/sort-list/description/?envType=featured-list&envId=2cktkvj
 */
public class No148SortListTest {


    public ListNode sortList(ListNode head) {


        if (head==null||head.next==null){
            return head;
        }



        ListNode middleNode = findMiddle(head);

        ListNode leftHead=head;
        ListNode rightHead=middleNode.next;
        middleNode.next=null;


        ListNode leftAns = sortList(leftHead);
        ListNode rightAns = sortList(rightHead);


        return merge(leftAns,rightAns);
    }

    private ListNode merge(ListNode node1,ListNode node2){

        if (node1==null){
            return node2;
        }

        if (node2==null){
            return node1;
        }

        ListNode head=null;

        if (node1.val<node2.val){

            head=node1;

            head.next= merge(node1.next, node2);

        } else {

            head=node2;

            head.next=merge(node1,node2.next);
        }

        return head;
    }

    private ListNode findMiddle(ListNode head){

        ListNode slowNode=head;
        ListNode fastNode=head;

        while (fastNode!=null&&fastNode.next!=null&&fastNode.next.next!=null){

            slowNode=slowNode.next;

            fastNode=fastNode.next.next;
        }

        return slowNode;
    }





    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;



        No148SortListTest test = new No148SortListTest();

        ListNode ans = test.sortList(node1);

        System.out.println(ans);


    }


}
