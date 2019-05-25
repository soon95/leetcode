import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubstringTest {
	public static void main(String[] args) {
		//
		String s="wordgoodstudentgoodword";
		String[] words= {"word","student"};
		//
		System.out.println(findSubstring(s, words));
		
	}
	public static List<Integer> findSubstring(String s,String[] words){
		List<Integer> ans=new ArrayList<>();
		if (words.length==0||words[0].length()==0) {
			return ans;
		}
		int length=words.length;
		int size=words[0].length();
		
		Arrays.sort(words);
		for (int i = 0; i <= s.length()-length*size; i++) {
			String[] subList=new String[length];
			String sub=s.substring(i, i+length*size);
			for (int j = 0; j < length; j++) {
				subList[j]=sub.substring(j*size,(j+1)*size);
			}
			Arrays.sort(subList);
			if (Arrays.equals(words, subList)) {
				ans.add(i);
			}
		}
		return ans;
	}
	
//
	public static List<Integer> findSubstring2(String s,String[] words){
		List<Integer> ans=new ArrayList<Integer>();
		
		int[] beginsIndex=new int[s.length()];
		
		for (int i = 0; i < words.length; i++) {
			List<Integer> begin=whereBegin(s, words[i]);
			for (int j = 0; j < begin.size(); j++) {
				beginsIndex[begin.get(j)]=i+1;
			}
		}
		
		for (int i = 0; i < beginsIndex.length; i++) {
			if (beginsIndex[i]!=0&&isConcatenation(beginsIndex, words, i)) {
				ans.add(i);
			}
		}
		return ans;
	}
	public static boolean isConcatenation(int[] beginsIndex,String[] words,int index) {
		int[] count=new int[words.length];
		int jump=0;
		
		while(index<beginsIndex.length&&beginsIndex[index]!=0&&jump<words.length) {
			count[beginsIndex[index]-1]++;
			jump++;
			index+=words[beginsIndex[index]-1].length();
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i]!=1) {
				return false;
			}
		}
		return true;
	}
	
	
	public static List<Integer> whereBegin(String s,String word) {
		List<Integer> begin=new ArrayList<>();
		for (int i = 0; i < s.length()-word.length()+1; i++) {
			if (same(s, word, i)) {
				begin.add(i);
			}
		}
		return begin;
	}
	public static boolean same(String s,String word,int index) {
		int length=word.length();
		for (int i = 0; i < length; i++) {
			if (s.charAt(index+i)!=word.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	
}
