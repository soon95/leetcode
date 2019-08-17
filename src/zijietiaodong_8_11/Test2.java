package zijietiaodong_8_11;

import java.util.Scanner;

/**
 * @author Leon Song
 * @date 2019-08-11
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int move = sc.nextInt();
        String s = sc.next();
        test(len, move, s);
    }

    public static void test(int len, int move, String s) {
        char[] str = new char[len];
        str[0] = s.charAt(0);
        int temp = str[0] - 48;
        for (int i = 1; i < len; i++) {
            temp = Reverseyihuo(s.charAt(i) - 48, temp);
            str[i] = (char) (temp + 48);
        }
        for (int i = 0; i < str.length; i++) {

            System.out.print(str[i]);
        }
    }

    public static int Reverseyihuo(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            if (b == 0) {
                return 1;
            } else
                return 0;
        }
    }
}
