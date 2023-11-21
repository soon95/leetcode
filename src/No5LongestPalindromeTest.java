public class No5LongestPalindromeTest {



    public String longestPalindrome(String s) {

        int length = s.length();

        boolean[][] dp=new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i]=true;
        }


        for (int i = length-2; i >=0; i--) {

            for (int j = i+1; j <length; j++) {

                if (j==i+1){

                    dp[i][j]= s.charAt(i) == s.charAt(j);

                } else {

                    dp[i][j]= s.charAt(i) == s.charAt(j)&& dp[i+1][j-1];

                }

            }

        }

        String res="";

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {

                if (dp[i][j]){

                    if (res.length()<j-i+1){
                        res=s.substring(i,j+1);
                    }
                }

            }
        }
        return res;
    }





    public static void main(String[] args) {

        String s="babad";


        No5LongestPalindromeTest test = new No5LongestPalindromeTest();

        String ans = test.longestPalindrome(s);

        System.out.println(ans);

    }


}
