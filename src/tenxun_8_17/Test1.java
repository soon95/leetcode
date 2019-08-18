package tenxun_8_17;

import java.util.Scanner;

/**
 * @author Leon Song
 * @date 2019-08-17
 */
public class Test1 {
    public static void main(String[] args) {
        //
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();

        System.out.println(solve(str));

        //
//        String str="HG[3|B[2|CA]]F";
//        System.out.println(solve(str));
    }

    public static String solve(String str) {
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        int index = 0;

        while (index < len) {
            char ch = str.charAt(index);
            if (ch != '[') {
                sb.append(ch);
                index++;
            } else {
                int time = str.charAt(index + 1) - '0';
                int end = findEnd(str, index);
                String anotherStr = str.substring(index + 3, end);
                String temp = solve(anotherStr);
                for (int i = 0; i < time; i++) {
                    sb.append(temp);
                }
                index = end + 1;
            }
        }
        return sb.toString();
    }

    private static int findEnd(String str, int index) {
        int count = 0;
        while (index < str.length()) {
            char ch = str.charAt(index);
            if (ch == '[') {
                count++;
            } else if (ch == ']') {
                count--;
                if (count == 0) {
                    return index;
                }
            }
            index++;
        }
        return 0;
    }
}
