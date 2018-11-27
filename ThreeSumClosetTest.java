import java.util.Arrays;

public class ThreeSumClosetTest {
	public static void main(String[] args) {
		//
		int[] nums= {-1,2,1,-4};
		int target=1;
		//
		System.out.println(threeSumCloset(nums, target));
	}
	public static int threeSumCloset(int[] nums,int target) {
		int length=nums.length;
		int[] sum=new int[length*(length-1)*(length-2)/(6)];
		
		int index=0;
		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i+1; j < nums.length-1; j++) {
				for (int j2 = j+1; j2 < nums.length; j2++) {
					sum[index++]=nums[i]+nums[j]+nums[j2];
				}
			}
		}
		int ans=0;
		int min=Integer.MAX_VALUE;
		int temp;
		for (int i = 0; i < sum.length; i++) {
			temp=Math.abs(sum[i]-target);
			if (temp<min) {
				min=temp;
				ans=sum[i];
			}
		}
		
		return ans;
	}
}
