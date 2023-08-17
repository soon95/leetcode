import java.util.ArrayList;
import java.util.List;

/**
 * 155. 最小栈
 * https://leetcode.cn/problems/min-stack/description/?envType=featured-list&envId=2cktkvj
 */
public class No155MinStackTest {


    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }



}


class MinStack{


    private List<StackItem> list;


    public MinStack() {
        this.list=new ArrayList<>();
    }

    public void push(int val) {

        StackItem stackItem = new StackItem();
        stackItem.val=val;

        if (list.isEmpty()){
            stackItem.min=val;
        } else {
            stackItem.min=Math.min(val,list.get(list.size()-1).min);
        }

        this.list.add(stackItem);

    }

    public void pop() {
        this.list.remove(list.size()-1);
    }

    public int top() {
        return this.list.get(list.size()-1).val;
    }

    public int getMin() {
        return this.list.get(list.size()-1).min;
    }


    public static class StackItem{

        private int val;

        private int min;

    }


}
