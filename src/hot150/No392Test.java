package hot150;

/**
 * @author Leon Song
 * @date 12/17/23
 */
public class No392Test {


    public static void main(String[] args) {

//        String s="abc";
        String s = "axc";
        String t = "ahbgdc";

        No392Test test = new No392Test();

        System.out.println(test.isSubsequence(s, t));


    }


    public boolean isSubsequence(String s, String t) {


        if (s.length() == 0) {
            return true;
        }


        int curIndex = 0;

        for (int i = 0; i < t.length(); i++) {

            if (curIndex >= s.length()) {
                return true;
            }

            if (s.charAt(curIndex) == t.charAt(i)) {
                curIndex++;
            }

        }


        return curIndex == s.length();
    }


}
