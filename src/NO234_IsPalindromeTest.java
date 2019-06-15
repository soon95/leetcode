import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @auther Leon Song
 * @date 2019-06-15 11:32
 */
public class NO234_IsPalindromeTest {

    public static void main(String[] args) {
        //
        ListNode l1=new ListNode(-129);
        ListNode l2=new ListNode(-129);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(1);
        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;

        l1.printAll();
        //
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head){

        Deque<Integer> deque=new ArrayDeque<>();

        ListNode cur=head;
        while (cur!=null){
            deque.add(cur.val);
            cur=cur.next;
        }

        while (deque.size()>1){
            if (!deque.pollFirst().equals(deque.pollLast())){
                return false;
            }
        }

        return true;
    }



}
