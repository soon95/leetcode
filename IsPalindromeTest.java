

public class IsPalindromeTest {
	public static void main(String[] args) {
		//
		int x=13131;
		//
		System.out.println(isPalindrome(x));
		
	}
	public static boolean isPalindrome(int x) {
		String s=String.valueOf(x);
		int length=s.length();
		
		for (int i = 0; i < length/2; i++) {
			if (s.charAt(i)!=s.charAt(length-1-i)) {
				return false;
			}
		}
		return true;
	}
}
