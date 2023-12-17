package hot150;

/**
 * @author Leon Song
 * @date 12/17/23
 */
public class No125Test {


    public static void main(String[] args) {

//        String s="A man, a plan, a canal: Panama";
        String s = "race a car";

        No125Test test = new No125Test();

        System.out.println(test.isPalindrome(s));


    }


    public boolean isPalindrome(String s) {


        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if ((ch >= '0' && ch <= '9') ||
                    (ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z')
            ) {

                sb.append(ch);
            }
        }

        String str = sb.toString().toLowerCase();

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }


        return true;
    }
}
