import java.util.Arrays;



public class MajorityElementTest {
	public static void main(String[] args) {
		//测试用例
		int[] nums= {2,2,1,1,1,2,2};
		//处理
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		
		if (isMajority(nums[0], nums)) {
			return nums[0];
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]!=nums[i-1]) {
				if (isMajority(nums[i], nums)) {
					return nums[i];
				}
			}
		}
		return 0;
	}
	public static boolean isMajority(int num,int[] nums) {
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]==num) {
				count++;
			}
		}
		if (count>=nums.length/2+1) {
			return true;
		}
		return false;
	}
	
}
