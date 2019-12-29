/**
 * @author: Leon Song
 * @date: 2019/12/29
 */
public class NO87_IsScrambleTest {
    public static void main(String[] args) {
        String s1 = "abb";
        String s2 = "bba";

        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        int length = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(length - i)) && isScramble(s1.substring(i), s2.substring(0, length - i)))
            ) {
                return true;
            }
        }

        return false;
    }
}
