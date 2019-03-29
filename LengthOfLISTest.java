
public class LengthOfLISTest {
	public static void main(String[] args) {
		//
		int[] nums= {10,9,2,5,3,7,101,18};
		//
		System.out.println(lengthOfLIS(nums));
		
	}
	public static int lengthOfLIS(int[] nums) {
		int length=nums.length;
		if (length==0) {
			return 0;
		}
		
		int[] dp=new int[length];
		dp[0]=1;
		
		for (int cur = 1; cur < length; cur++) {
			int max=1;
			int temp=1;
			for (int pre = 0; pre < cur; pre++) {
				if (nums[pre]<nums[cur]) {
					temp=dp[pre]+1;
					max=Math.max(max, temp);
				}
			}
			dp[cur]=max;
		}
		int max=0;
		for (int i = 0; i < dp.length; i++) {
			max=Math.max(max, dp[i]);
		}
		return max;
	}
}
