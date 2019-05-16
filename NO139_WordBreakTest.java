import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NO139_WordBreakTest {
	public static void main(String[] args) {
		//
		String s="";
		String[] dict= {"cats", "dog", "sand", "and", "cat"};
		List<String> wordDict=new ArrayList<>(Arrays.asList(dict));
		//
		System.out.println(wordBreak(s, wordDict));
	}
	public static boolean wordBreak(String s,List<String> wordDict) {
		Set<String> dict=new HashSet<>();
		for(String str:wordDict) {
			dict.add(str);
		}
		
		int len=s.length();
		boolean[] dp=new boolean[len+1];
		dp[0]=true;
		for (int i = 1; i <= len; i++) {
			for (int pre = i-1; pre >= 0; pre--) {
				if (dp[pre]&&dict.contains(s.substring(pre, i))) {
					dp[i]=true;
					break;
				}
			}
		}
		
		return dp[len];
	}
}
