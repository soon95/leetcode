
public class CountAndSayTest {
	public static void main(String[] args) {
		//
		int n=1;
		String str="1";
		//
//		System.out.println(count(str));
//		System.out.println(""+'1'+'0');
		System.out.println(countAndSay2(n));
	}
	public static String countAndSay(int n) {//递归版
		if (n==1) {
			return "1";
		} else {
			return count(countAndSay(n-1));
		}
	}
	public static String countAndSay2(int n) {//循环版
		String say="1";
		String next;
		for (int i = 1; i < n; i++) {
			next=count(say);
			say=next;
		}
		return say;
	}
	public static String count(String str) {
		String ans="";
		char num=str.charAt(0);
		int count=0;
		
		for (int i = 0; i < str.length(); i++) {
			if (num==str.charAt(i)) {
				count++;
			} else {
				ans=""+ans+count+num;
				num=str.charAt(i);
				count=1;
			}
		}
		ans=""+ans+count+num;
		return ans;
	}
}
