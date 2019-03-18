
public class LongestCommonPrefixTest {
	public static void main(String[] args) {
		//
		String[] strs= {"a"};
		//
		System.out.println(longestCommonPrefix(strs));
//		System.out.println(equal(strs,2));
	}
	public static String longestCommonPrefix(String[] strs) {
		String ans="";
		
		int index=0;
		try {
			while (equal(strs, index)) {
				ans+=strs[0].charAt(index);
				index++;
			}
		} catch (Exception e) {
			return ans;
		}
		
		return ans;
	}
	
	public static boolean equal(String[] strs,int index) {
		for (int i = 1; i < strs.length; i++) {
			if (strs[0].charAt(index)!=strs[i].charAt(index)) {
				return false;
			}
		}
		return true;
	}
}
