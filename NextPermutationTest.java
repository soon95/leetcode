import java.util.Arrays;

public class NextPermutationTest {
	public static void main(String[] args) {
		//
		int[] nums= {1,5,1};
		//
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		
	}
	public static void nextPermutation(int[] nums) {
		int len=nums.length;
		int index=len-2;
		while(index>=0&&nums[index+1]<=nums[index]) {
			index--;
		}
		int mark=index;
		index++;
		int temp;
		if (mark>=0) {
			while(index<len&&nums[index]-nums[mark]>0) {
				index++;
			}
			int sec=index-1;
			temp=nums[mark];
			nums[mark]=nums[sec];
			nums[sec]=temp;
		}
		index=mark+1;
		int k=len-1;
		while(index<=(mark+len-1)/2) {
			temp=nums[index];
			nums[index]=nums[k];
			nums[k]=temp;
			index++;
			k--;
		}
	}
}
