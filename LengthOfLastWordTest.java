
public class LengthOfLastWordTest {
	public static void main(String[] args) {
		//
		String s="qq a";
		//
		System.out.println(lengthOfLastWord(s));
	}
	public static int lengthOfLastWord(String s) {
		int length=0;
		for (int i = s.length()-1; i >= 0; i--) {
			if (s.charAt(i)!=' ') {
				length++;
			} else if (length!=0&&s.charAt(i)==' ') {
				break;
			}
		}
		return length;
	}
}
