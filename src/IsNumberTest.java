
public class IsNumberTest {
	public static void main(String[] args) {
		//
		String s=" 3. ";
		//
		System.out.println(isNumber(s));
	}
	
	
	public static boolean isNumber(String s) {
		//     \s*[+-]?((\d*\.\d+)|(\d+\.?))(e[+-]?\d+)?\s*
		String reg="\\s*[+-]?((\\d*\\.\\d+)|(\\d+\\.?))(e[+-]?\\d+)?\\s*";
		return s.matches(reg);
	}
}
