import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberTest {
	public static void main(String[] args) {
		//
		int[] nums = {1,0,0};
		//
		System.out.println(largestNumber(nums));
	}
	public static String largestNumber(int[] nums) {
		int len = nums.length;
		boolean flag = true;
		for (int i = 0; i < len; i++) {
			if (nums[i] != 0) {
				flag = false;
				break;
			}
		}
		if (flag) {
			return "0";
		}
		
		
		Integer[] arr = new Integer[len];
		int index=0;
		for(int x: nums) {
			arr[index++] = x;
		}
		
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = o1.toString();
				String str2 = o2.toString();
				
				long num1 = Long.parseLong(str1+str2);
				long num2 = Long.parseLong(str2+str1);
				
				return (int) (num2-num1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int x:arr) {
			sb.append(x);
		}
		return sb.toString();
	}
}
