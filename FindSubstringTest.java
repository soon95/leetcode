import java.util.ArrayList;
import java.util.List;

public class FindSubstringTest {
	public static void main(String[] args) {
		//
		String s="barfoothefoobarman";
		String[] words= {"foo","bar"};
		//
		System.out.println(same(s, 0, words[1]));
		
	}
	public static List<Integer> findSubstring(String s,String[] words){
		ArrayList<Integer> ans=new ArrayList<>();
		
		
		
		
		
		return ans;
	}
	public static boolean same(String s,int index,String word) {
		int length=word.length();
		if (!s.substring(index, length).equals(word)) {
			return false;
		}
		return true;
	}
}
