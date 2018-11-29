
public class SearchInsertTest {
	public static void main(String[] args) {
		//
		int[] nums= {1,3,5,6};
		int target=0;
		//
		System.out.println(searchInsert(nums, target));
	}
	public static int searchInsert(int[] nums,int target) {
		int index=0;
		int len=nums.length;
		
		while(index<len&&nums[index]<target) {
			index++;
		}
		
		return index;
	}
}
