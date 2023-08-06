public class No322CoinChangeTest {


    public int coinChange(int[] coins, int amount) {


        int[] dp=new int[amount+1];

        dp[0]=0;


        for (int i = 1; i < dp.length; i++) {

            int temp=Integer.MAX_VALUE;

            for (int coin : coins) {

                int preIndex = i - coin;
                if (preIndex >= 0 && dp[preIndex] != -1) {
                    temp = Math.min(temp, dp[preIndex]+1);
                }
            }

            if (temp!=Integer.MAX_VALUE){
                dp[i]=temp;
            } else {
                dp[i]=-1;
            }
        }

        return dp[amount];
    }



    public static void main(String[] args) {


//        int[] coins=new int[]{1,2,5};
//        int amount=11;
        int[] coins=new int[]{2};
        int amount=3;


        No322CoinChangeTest test = new No322CoinChangeTest();

        System.out.println(test.coinChange(coins, amount));


    }


}
