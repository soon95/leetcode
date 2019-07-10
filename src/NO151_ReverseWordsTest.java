import java.util.Stack;

/**
 * @author Leon Song
 * @date 2019-07-10
 */
public class NO151_ReverseWordsTest {
    public static void main(String[] args) {
        //
        String s = "";
        //
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        String[] strs = s.split(" ");

        StringBuffer sb = new StringBuffer();

        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (str.length() != 0) {
                stack.push(str);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
