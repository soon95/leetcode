import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesisTest {
	public static void main(String[] args) {
		//
		int n=0;
		String str="()((";
		//
//		System.out.println(Arrays.toString(generateAll(n)));
//		System.out.println(isAvailable(str, n));
		System.out.println(generateParenthesis(n));
	}
	public static List<String> generateParenthesis(int n){
		List<String> ans=new ArrayList<>();
		
		String[] all=generateAll(n);
		for (int i = 0; i < all.length; i++) {
			if (isAvailable(all[i], n)) {
				ans.add(all[i]);
			}
		}
		
		return ans;
	}
	public static String[] generateAll(int n) {
		if (n==0) {
			String[] res= {};
			return res;
		}else if (n==1) {
			String[] res= {"((","))","()",")("};
			return res;
		} else {
			String[] res=new String[(int) Math.pow(2, 2*n)];
			String[] temp= {"((","))","()",")("};
			int index=0;
			for(String str:generateAll(n-1)) {
				for (int i = 0; i < temp.length; i++) {
					res[index++]=str+temp[i];
				}
			}
			return res;
		}

	}
	public static boolean isAvailable(String str,int n) {
		int count=0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='(') {
				count++;
			} else if (str.charAt(i)==')') {
				count--;
			}
			
			if (count<0||count>n) {
				return false;
			}
		}
		if (count!=0) {
			return false;
		} else {
			return true;			
		}
	}
}
