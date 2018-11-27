import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAtioTest {
	public static void main(String[] args) {
		//
		String s="   1234";
		char ch='4';
		//
		System.out.println(myAtio2(s));

	}
	public static int myAtio2(String str) {
		/**
		 * ^[\s]*([-|\+]?)([0-9]*)
		 */
		String reg="^([\\s]*)([-|\\+]?)([0-9]*)";
		Pattern pattern=Pattern.compile(reg);
		Matcher matcher=pattern.matcher(str);
		String s1 = "";
		String s2 = "";
		while (matcher.find()) {
		    s1 = matcher.group(1);
		    s2 = matcher.group(2);
		}if (s2.length() == 0) {
            return 0;
        }
        String ss1 = s1.replaceAll("\\+", "");
        try {
            if (ss1.length() == 0) {
                return Integer.valueOf(s2);
            } else {
                return Integer.valueOf(ss1 + s2);
            }
        }   catch (Exception e) {
            if (ss1.length() == 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
		
	}
	
	public static int myAtio(String str) {
		if (str.length()==0) {
			return 0;
		}
		int ans=0;
		int sign=1;
		
		int index=0;
		while(index<str.length()&&str.charAt(index)==' ') {
			index++;
		}
		if (index==str.length()) {
			return 0;
		}
		
		if (str.charAt(index)=='+'||str.charAt(index)=='-') {
			sign=str.charAt(index)=='+'?1:-1;
			index++;
		}
		while(index < str.length()){
	        int digit = str.charAt(index) - '0';
	        if(digit < 0 || digit > 9) break;
	 
	        if(Integer.MAX_VALUE/10 < ans || Integer.MAX_VALUE/10 == ans && Integer.MAX_VALUE %10 < digit)
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	 
	        ans = 10 * ans + digit;
	        index ++;
	    }
		
		return ans*sign;
	}

}
