import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsTest {
	public static String[][] numTable= {{},{"a","b","c"},{"d","e","f"},
			{"g","h","i"},{"j","k","l"},{"m","n","o"},
			{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
	
	public static void main(String[] args) {
		//²âÊÔÓÃÀı
		String digits="25";
		//
		System.out.println(letterCombinations(digits));
		
		
	}
	public static List<String> letterCombinations(String digits){
		String[] digit=digits.split("");
		List<String> ans=new ArrayList<>();
		if (digits.equals("")) {
			return ans;
		}
		for (int i = 0; i < numTable[toNum(digit[0])].length; i++) {
			ans.add(numTable[toNum(digit[0])][i]);
		}
		for (int i = 1; i < digit.length; i++) {
			ans=twoLetterCombination(ans, toNum(digit[i]));
		}
		return ans;
	}
	
	public static List<String> twoLetterCombination(List<String> mid,int b){
		List<String> subans=new ArrayList<>();
		
		for (int i = 0; i < numTable[b].length; i++) {
			for (int j = 0; j < mid.size(); j++) {
				subans.add(mid.get(j)+numTable[b][i]);
			}
		}
		
		
		return subans;
	}
	
	
	public static int toNum(String st) {
		return Integer.valueOf(st)-1;
	}
	
	
}
