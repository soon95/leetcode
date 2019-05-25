
public class NO213_RobTest {
	public static void main(String[] args) {
		//
		int[] nums= {1,2,1,1};
		//
		System.out.println(rob(nums));
	}
	public static int rob(int[] nums) {
		int len=nums.length;
		if (len==0) {
			return 0;
		}
		if (len==1) {
			return nums[0];
		}
		
		int[] dp1=new int[len];
		dp1[0]=0;
		dp1[1]=nums[0];
		for (int i = 2; i < len; i++) {
			dp1[i]=Math.max(dp1[i-2]+nums[i-1], dp1[i-1]);
		}
		
		int[] dp2=new int[len];
		dp2[0]=0;
		dp2[1]=nums[1];
		for (int i = 2; i < len; i++) {
			dp2[i]=Math.max(dp2[i-2]+nums[i], dp2[i-1]);
		}
		
		return Math.max(dp1[len-1], dp2[len-1]);
	}
}
