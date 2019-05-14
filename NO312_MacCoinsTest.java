import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO312_MacCoinsTest {
	public static void main(String[] args) {
		//
		int[] nums= {3,1,5,8};// 3,1,5,8   9,76,64,21
		//
		System.out.println(maxCoins(nums));
	}
	
	public static int maxCoins(int[] nums) {		
		int len=nums.length;
		int[][] dp=new int[len+2][len+2];
		
		int[] arr=new int[len+2];
		arr[0]=1;
		arr[len+1]=1;
		for (int i = 0; i < len; i++) {
			arr[i+1]=nums[i];
		}
		
//		for (int win = 1; win <= len; win++) { // 窗口大小
//			for (int left = 1; left+win <= len+1; left++) {
//				int right=left+win-1;
//				for (int k = left; k <= right; k++) {
//					dp[left][right]=Math.max(dp[left][right], 
//							arr[left-1]*arr[k]*arr[right+1]+dp[left][k-1]+dp[k+1][right]);
//				}
//				
//				
//			}
//		}
		
		for (int row = len; row >= 1; row--) {
			for (int col = row; col <= len; col++) {
				for (int last = row; last <= col; last++) {
					dp[row][col]=Math.max(dp[row][col], 
							arr[row-1]*arr[last]*arr[col+1]+dp[row][last-1]+dp[last+1][col]);
				}
			}
		}
		for (int i = 0; i <= len+1; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		
		return dp[1][len];
	}
	
	
	/*
	 * 递归超时
	 */
	public static int maxCoins_method2(int[] nums) {
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		for(int x:nums) {
			list.add(x);
		}
		list.add(1);
		return dfs(list);
	}	
	public static int dfs(List<Integer> list) {
		int ans=0;
		for (int i = 1; i < list.size()-1; i++) {
			int temp=list.get(i);
			int multi=list.get(i-1)*list.get(i)*list.get(i+1);
			list.remove(i);
			ans=Math.max(ans, dfs(list)+multi);
			list.add(i, temp);
		}
		return ans;
	}
}
