import java.util.HashSet;
import java.util.Set;

/**
 * @author Leon Song
 * @date 4/18/24
 */
public class No3LengthOfLongestSubstringTest {

    public static void main(String[] args) {

//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";

        No3LengthOfLongestSubstringTest test = new No3LengthOfLongestSubstringTest();
        int res = test.lengthOfLongestSubstring(s);

        System.out.println(res);


    }

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();

        int res = 0;


        while (end < s.length()) {

            char cur = s.charAt(end);

            boolean contains = set.contains(cur);
            if (contains) {
                // 如果重复

                set.remove(s.charAt(start));

                start++;

            } else {
                // 如果不重复

                set.add(cur);

                end++;

                res = Math.max(res, end - start);
            }
        }

        return res;
    }

}
