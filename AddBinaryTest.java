
public class AddBinaryTest {
	public static void main(String[] args) {
		//
		String a = "0";
		String b = "0";
		//
		System.out.println(addBinary(a, b));
	}
	public static String addBinary(String a, String b) {
		char[] str1 = a.toCharArray();
		char[] str2 = b.toCharArray();
		
		int len = str1.length > str2.length ? str1.length : str2.length;
		
		int[] ans = new int[len+1];
		
		for (int i = 0; i < str1.length; i++) {
			ans[i] += str1[str1.length-i-1]-'0';
		}
		for (int i = 0; i < str2.length; i++) {
			ans[i] += str2[str2.length-i-1]-'0';
		}
		for (int i = 0; i < len; i++) {
			ans[i+1] += ans[i]/2;
			ans[i] %= 2;
		}
		ans[len] += ans[len-1]/2;
		ans[len-1] %= 2;
		
		
		int index = len;
		while(index>=0 && ans[index] == 0) index--;
		if (index < 0) {
			return "0";
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(index>=0) {
			sb.append(ans[index--]);
		}
		return sb.toString();
		
	}
}
