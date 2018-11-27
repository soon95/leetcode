import java.util.Arrays;

public class SortColorsTest {
	public static void main(String[] args) {
		//
		int[] nums= {2,0,2,1,1,0};
		//
		sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}
	public static void sortColors(int[] nums) {
		int temp;
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]>nums[j]) {
					temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
		}
	}
	public static void sortColors2(int[] nums) {
		int[] count=new int[3];
		for(int n:nums) {
			count[n]++;
		}
		int index=0;
		for (int i = 0; i < count[0]; i++) {
			nums[index++]=0;
		}
		for (int i = 0; i < count[1]; i++) {
			nums[index++]=1;
		}
		for (int i = 0; i < count[2]; i++) {
			nums[index++]=2;
		}
	}
}
