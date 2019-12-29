import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon Song
 * @date: 2019/12/29
 */
public class NO86_PartitionTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

//        l1.printAll();

        ListNode ans = partition(l1, 1);
        ans.printAll();

    }

    public static ListNode partition(ListNode head, int x) {
        List<Integer> larger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                larger.add(cur.val);
            } else {
                smaller.add(cur.val);
            }
            cur = cur.next;
        }

        ListNode reHead = new ListNode(0);
        cur = reHead;
        for (Integer num : smaller) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        for (Integer num : larger) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        return reHead.next;
    }
}
