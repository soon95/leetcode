import java.util.Arrays;

public class RemoveElementTest {
	public static void main(String[] args) {
		//
		int[] nums= {};
		int val=2;
		//
		System.out.println(removeElement(nums, val));
	}
	public static int newRemoveElement(int[] nums,int val) {
		int i = 0;
        for(int j = 0; j < nums.length; j++) {
           if(nums[j] != val) {
               nums[i] = nums[j];
               i++;
           }
        }
        return i;
	}
	
	public static int removeElement(int[] nums,int val) {
		Arrays.sort(nums);
		
		boolean find=false;
		int left=0;
		int right=0;
		int length=nums.length;
		
		while(right<length) {
			if (nums[left]==val) {
				find=true;
			} else if (nums[left]>val) {
				return length;
			} else {
				left++;
			}
			if (find&&(right+1==length||nums[right+1]!=val)) {
				break;
			} else {
				right++;
			}
		}
		int bias;
		if (find) {
			bias=right-left+1;
			for (int i = right+1; i < nums.length; i++) {
				nums[i-bias]=nums[i];
			}
		} else {
			bias=0;
		}
//		System.out.println(Arrays.toString(nums));
		
		
		return length-bias;
	}
}
