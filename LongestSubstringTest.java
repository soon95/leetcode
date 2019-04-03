import java.util.Arrays;

public class LongestSubstringTest {
	public static void main(String[] args) {
		//
		String s="ababbc";
		int k=2;
		//
		System.out.println(longestSubstring_method1(s, k));
	}
	public static int longestSubstring_method1(String s,int k) {
		int len=s.length();
		int max=0;
		for (int start = 0; start <= len-k; start++) {
			int[] count=new int[26];
			for (int i = start; i < start+k-1; i++) {
				count[s.charAt(i)-'a']++;
			}
			for (int end = start+k-1; end < len; end++) {
				count[s.charAt(end)-'a']++;
				if (satisfy(count, k)) {
					max=Math.max(max, end-start+1);
				}
			}
		}
		return max;
		
	}
	public static boolean satisfy(int[] nums,int k) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=0&&nums[i]<k) {
				return false;
			}
		}
		return true;
	}
}
