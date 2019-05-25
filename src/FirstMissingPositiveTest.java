
public class FirstMissingPositiveTest {
	public static void main(String[] args) {
		//
		int[] nums= {0};
		//
		System.out.println(firstMissingPositive(nums));
	}
	public static int firstMissingPositive(int[] nums) {
		int length=nums.length;
		//寻找最大和最小的正数
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			if (nums[i]>0&&nums[i]>max) {
				max=nums[i];
			}
		}
		if (max<=0) {
			return 1;
		}
		int[] count=new int[max];
		for (int i = 0; i < length; i++) {
			if (nums[i]>0) {
				count[nums[i]-1]++;
			}
		}
		for (int i = 0; i < max; i++) {
			if (count[i]==0) {
				return i+1;
			}
		}
		return max+1;
	}
}
