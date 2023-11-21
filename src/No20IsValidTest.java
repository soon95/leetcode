import java.util.Stack;

public class No20IsValidTest {


    public boolean isValid(String s){

        int length = s.length();

        if (length==0){
            return true;
        }

        Stack<Character> stack=new Stack<>();


        int index=0;


        while (index<length){

            char cur = s.charAt(index);

            if (stack.isEmpty()){
                stack.push(cur);
            } else {

                Character peek = stack.peek();

                if (cur==')'&&peek=='('){
                    stack.pop();
                } else if (cur==']'&&peek=='['){
                    stack.pop();
                } else if (cur=='}'&&peek=='{'){
                    stack.pop();
                } else {
                    stack.push(cur);
                }

            }

            index++;
        }


        return stack.isEmpty();
    }



    public static void main(String[] args) {

        String s="({[)";

        No20IsValidTest test = new No20IsValidTest();

        boolean ans = test.isValid(s);
        System.out.println(ans);


    }




}
