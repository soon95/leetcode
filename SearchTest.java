
public class SearchTest {
	public static void main(String[] args) {
		//
		int[] nums= {1,4};
		           //0,1,2,3,4,5,6
		int target=5;
		//
		System.out.println(search(nums, target));
		
	}
	
	public static int search(int[] nums,int target) {
		if (nums.length==0) {
			return -1;
		}
		if (nums.length==1&&nums[0]!=target) {
			return -1;
		}
		
		int index=0;
		int len=nums.length;
		
		if (nums[index]==target) {
			return index;
		} else if (nums[index]<target) {//向右寻找
			while((index<len-1)&&(nums[index]<target)&&(nums[index]<nums[index+1])) {
				index++;	
			}
			if (nums[index]==target) {
				return index;
			} else {
				return -1;
			}
		} else {//向左寻找
			if (nums[index]<nums[len-1]) {
				return -1;
			} else {
				index=len-1;
				while((nums[index]>target)&&nums[index]>nums[index-1]) {
					index--;
				}
				if (nums[index]==target) {
					return index;
				} else {
					return -1;
				}
				
			}
			
		}	
	}
}
