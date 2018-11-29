import java.util.Arrays;

public class SearchRangeTest {
	public static void main(String[] args) {
		//
		int[] nums= {5,7,7,8,8,9,10};
		int target=9;
		//
		System.out.println(Arrays.toString(searchRange(nums, target)));
		
	}
	public static int[] searchRange(int[] nums, int target) {
		int[] ans = {-1,-1};
		
		int index=0;
		int len=nums.length;
		
		while(index<len&&nums[index]<target) {
			index++;
		}
		if (index<len&&nums[index]==target) {
			ans[0]=index;
			
			while(index<len&&nums[index]==target) {
				ans[1]=index;
				index++;
			}
		} else {
			return ans;
		}

		return ans;
	}
}
