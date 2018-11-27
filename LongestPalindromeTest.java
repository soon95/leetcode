
public class LongestPalindromeTest {
	public static void main(String[] args) {
		//
		String s="";
		//
		System.out.println(longestPalindrome(s));
	}
	public static String longestPalindrome(String s) {
		if (s.length()==0) {
			return "";
		}
		
		int begin=0;
		int end=0;
		int len=0;
		int len1=0;
		int len2=0;
		
		for (int i = 0; i < s.length(); i++) {
			len1=expandAroundCenter(s, i, i);
			len2=expandAroundCenter(s, i, i+1);
			len=len1<len2?len2:len1;
			if (len>end-begin) {
				begin=i-(len-1)/2;
				end=i+len/2;
			}
		}
		return s.substring(begin, end+1);
	}
	
	public static int expandAroundCenter(String s,int left,int right) {
		int l=left;
		int r=right;
		
		while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)) {
			 l--;
			 r++;
		}
		
		return r-l-1;
	}
}
