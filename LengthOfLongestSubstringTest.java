
public class LengthOfLongestSubstringTest {
	public static void main(String[] args) {
		//
		String s="";
		//
		System.out.println(lengthOfLongestSubstring(s));
		
		
	}
	public static int lengthOfLongestSubstring(String s) {
		if (s.length()==0) {
			return 0;
		}
		
		int max=1;
		int length=1;
		
		int f1=0;
		
		while(f1<s.length()-1) {
			length=1;
			int f2=f1+1;
			while(f2<s.length()&&!isRep(s, f1, f2)) {
				length++;
				f2++;
			}
			if (length>max) {
				max=length;
			}
			
			f1++;
		}
		
		return max;
	}
	public static boolean isRep(String s,int f1,int f2) {
		for (int i = f1; i < f2; i++) {
			if (s.charAt(i)==s.charAt(f2)) {
				return true;
			}
		}
		return false;
	}
}
