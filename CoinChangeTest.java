import java.util.Arrays;
import java.util.Stack;

public class CoinChangeTest {
	public static void main(String[] args) {
		//
//		int[] coins= {3,2,5};
//		int amount=11;
		int[] coins= {186,419,83,408};
		int amount=6249;
		//
		System.out.println(coinChange(coins, amount));
		
		
	}
	public static int coinChange(int[] coins,int amount) {
		int[] method=new int[amount+1];
		method[0]=0;
		for (int amo = 1; amo <= amount; amo++) {
			int preMethod=Integer.MAX_VALUE;//前项硬币最少
			for (int i = 0; i < coins.length; i++) {//寻找前项硬币最少
				if (amo>=coins[i]&&method[amo-coins[i]]!=-1) {
					if (method[amo-coins[i]]<preMethod) {
						preMethod=method[amo-coins[i]];
					}
				}
			}
			if (preMethod!=Integer.MAX_VALUE) {
				method[amo]=preMethod+1;
			} else {
				method[amo]=-1;
			}
		}
		return method[amount];
	}
	
}
