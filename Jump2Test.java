
public class Jump2Test {
	public static void main(String[] args) {
		//
		int[] nums= {2,3,1,1,4};
		//
		System.out.println(jump(nums));
//		System.out.println(nextRange(nums, 2));
		
	}
	public static int jump(int[] nums) {
		int step=0;
		int len=nums.length;
		int curMax=0;
		int preMax=0;
		int nextMax=0;
		
		
		while(nextMax<len-1) {
			preMax=curMax;
			curMax=nextMax;
			nextMax=nextRange(nums,preMax,curMax);
			step++;
		}
		
		return step;
	}
	
	public static int nextRange(int[] nums,int preRange,int curRange) {
		int furthest=0;
		int temp;
		for (int i = preRange; i <= curRange; i++) {
			temp=Math.max(curRange, nums[i]+i);
			if (temp>furthest) {
				furthest=temp;
			}
		}
		return furthest;
	}
}
