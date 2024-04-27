public class No1143LongestCommonSubsequenceTest {

    public static void main(String[] args) {

//
//       String text1 = "abcde";
//       String text2 = "ace";
       String text1 = "abc";
       String text2 = "def";

        No1143LongestCommonSubsequenceTest test = new No1143LongestCommonSubsequenceTest();

        int ans = test.longestCommonSubsequence(text1, text2);

        System.out.println(ans);

    }

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp=new int[m][n];

        dp[0][0]=text1.charAt(0)==text2.charAt(0)?1:0;

        for (int i = 1; i < n; i++) {
            if (text1.charAt(0)==text2.charAt(i)){
                dp[0][i]=1;
            } else {
                dp[0][i]=dp[0][i-1];
            }
        }

        for (int i = 1; i < m; i++) {
            if (text1.charAt(i)==text2.charAt(0)){
                dp[i][0]=1;
            } else {
                dp[i][0]=dp[i-1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
