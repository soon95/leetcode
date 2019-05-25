import java.util.Arrays;

public class ProductExceptSelfTest {
	public static void main(String[] args) {
		//测试用例
		int[] nums= {1,2,3,4};
		//
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int[] ans=new int[nums.length];
		
		int[] arr1=new int[nums.length];
		int[] arr2=new int[nums.length];
		
		arr1[0]=1;
		arr2[arr2.length-1]=1;
		for (int i = 1; i < arr1.length; i++) {
			arr1[i]=arr1[i-1]*nums[i-1];
		}
		for (int i = arr2.length-2; i>=0; i--) {
			arr2[i]=arr2[i+1]*nums[i+1];
		}
		for (int i = 0; i < nums.length; i++) {
			ans[i]=arr1[i]*arr2[i];
		}
		
		return ans;
	}
}
