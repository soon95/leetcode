import java.util.Arrays;

public class CanJumpTest {
	public static void main(String[] args) {
		//²âÊÔÊı¾İ
		int[] nums= {2,0,0};
		//
		System.out.println(CanJump(nums));
//		System.out.println(canJumpThis(nums, 8));
	}
	public static boolean CanJump(int[] nums) {
		int[] indexOfZero= new int[0];
		
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i]==0) {
				indexOfZero=Arrays.copyOf(indexOfZero, indexOfZero.length+1);
				indexOfZero[indexOfZero.length-1]=i;
			}
		}
//		System.out.println(Arrays.toString(indexOfZero));
		for (int index:indexOfZero) {
			if (!canJumpThis(nums, index)) {
				return false;
			}
		}
		return true;
	}
	public static boolean canJumpThis(int[] nums,int index) {
		for (int i = index-1; i >= 0; i--) {
			if (nums[i]>index-i) {
				return true;
			}
		}
		return false; 
	}
	
}
