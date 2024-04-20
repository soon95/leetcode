import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Song
 * @date 4/20/24
 */
public class No113PartitionTest {

    public static void main(String[] args) {


//        String s = "aab";
//        String s = "a";
        String s = "abbab";

        No113PartitionTest test = new No113PartitionTest();

        List<List<String>> partition = test.partition(s);

        System.out.println(partition);


    }

    public List<List<String>> partition(String s) {

        int length = s.length();

        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {

                if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }

            }
        }


        List<List<String>> res = new ArrayList<>();

        List<String> cur = new ArrayList<>();

        findAvailable(s, dp, cur, 0, res);


        return res;
    }

    private void findAvailable(String str, boolean[][] dp, List<String> pre, int start, List<List<String>> res) {

        if (start >= str.length()) {
            res.add(pre);
            return;
        }


        for (int end = start; end < str.length(); end++) {

            if (dp[start][end]) {

                List<String> cur = new ArrayList<>(pre);
                cur.add(str.substring(start, end + 1));

                findAvailable(str, dp, cur, end + 1, res);
            }
        }
    }

}
