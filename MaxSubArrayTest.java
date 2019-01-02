
public class MaxSubArrayTest {
	public static void main(String[] args) {
		//
		int[] nums= {-4,-1};//-2,1,-3,4,-1,2,1,-5,4
		//
		System.out.println(maxSubArray(nums));
		
	}
	public static int maxSubArray(int[] nums) {
		int max=Integer.MIN_VALUE;
		int start=0;
		int end;
		int length=nums.length;
		int temp;
		
		while(start<length) {
//			while(start<length&&nums[start]<0) {
//				start++;
//			}
			end=start;
			temp=0;
			while(end<length) {
				temp+=nums[end];
				if (temp>max) {
					max=temp;
				}
				end++;
			}
			start++;
		}
		
		return max;	
	}

	public static int maxSubArray2(int[] nums) {
		int maxSum = nums[0];
        int curSum = 0;
        for (int n: nums) {
            curSum += n;
            if (curSum > maxSum) { maxSum = curSum; }
            if (curSum < 0) { curSum = 0; }
            
        }
        return maxSum;
	}
	
}
