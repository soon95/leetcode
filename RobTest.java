
public class RobTest {
	public static void main(String[] args) {
		//
		int[] nums= {2,7,9,3,1};
		//
		System.out.println(rob(nums));
	}
	public static int rob(int[] nums) {
		int len=nums.length;
		if (len==0) {
			return 0;
		}
		int[] dp=new int[len+1];
		dp[1]=nums[0];
		for (int i = 2; i <= len; i++) {
			int temp=0;
			for (int j = 0; j < i-1; j++) {
				temp=Math.max(temp, nums[i-1]+dp[j]);
			}
			dp[i]=temp;
		}
		int max=0;
		for (int i = 0; i < dp.length; i++) {
			max=Math.max(max, dp[i]);
		}
		
		return max;
	}
}
