
public class FindLengthOfLCISTest {
	public static void main(String[] args) {
		//
		int[] nums= {1};
		//
		System.out.println(findLongthOfLCIS(nums));
	}
	public static int findLongthOfLCIS(int[] nums) {
		if (nums.length==0) {
			return 0;
		}
		int max=1;
		int temp=1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]>nums[i-1]) {
				temp++;
			} else {
				temp=1;
			}
			max=Math.max(max, temp);
		}
		return max;
	}
}
