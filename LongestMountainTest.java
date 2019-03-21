import java.util.ArrayList;

public class LongestMountainTest {
	public static void main(String[] args) {
		//
		int[] arr= {1,2,2,2};
		//
		System.out.println(longestMountain(arr));
	}
	public static int longestMountain(int[] arr) {
		if (arr.length<3) {
			return 0;
		}
		int max=0;
		int count;
		for (int i = 1; i < arr.length-1; i++) {
			if (arr[i]>arr[i+1]&&arr[i]>arr[i-1]) {
				int left=i-1;
				int right=i+1;
				count=1;
				while(left>=0&&arr[left]<arr[left+1]) {
					left--;
					count++;
				}
				while(right<arr.length&&arr[right]<arr[right-1]) {
					right++;
					count++;
				}
				
				if (max<count) {
					max=count;
				}
			}
		}

		return max;
	}
}
