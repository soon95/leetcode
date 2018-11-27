
public class MaxProfitTest {
	public static void main(String[] args) {
		//测试数据
		int[] prices= {7,6,5,4,3,2};
		//
		System.out.println(maxProfit(prices));
		
	}
	public static int maxProfit(int[] prices) {
		int income=0;
		int buy=Integer.MAX_VALUE;
		
		for(int price:prices) {
			buy=buy<=price?buy:price;//找到最小买入点
			income=income>(price-buy)?income:(price-buy);//比较当前时刻卖出收入
		}
		return income;
	}
	
}
