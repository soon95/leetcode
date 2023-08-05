public class No309MaxProfit {

    /**
     * 309. 买卖股票的最佳时机含冷冻期
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?envType=featured-list&envId=2cktkvj
     */
    public static int maxProfit(int[] prices) {


        int[] dpWithStack=new int[prices.length];
        int[] dpSell=new int[prices.length];
        int[] dpWithoutStack=new int[prices.length];

        dpWithStack[0]=-prices[0];
        dpSell[0]=0;
        dpWithoutStack[0]=0;


        for (int i = 1; i < prices.length; i++) {


            dpWithStack[i]=Math.max(dpWithStack[i-1], dpWithoutStack[i-1]-prices[i]);

            dpSell[i]=dpWithStack[i-1]+prices[i];

            dpWithoutStack[i]=Math.max(dpWithoutStack[i-1], dpSell[i-1]);
        }



        return Math.max(dpSell[prices.length-1],dpWithoutStack[prices.length-1]);
    }



    public static void main(String[] args) {

//        int[] prices=new int[]{1,2,3,0,2};
        int[] prices=new int[]{6,1,6,4,3,0,2};

        System.out.println(maxProfit(prices));


    }



}
