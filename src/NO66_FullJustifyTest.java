import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon Song
 * @date: 2019/12/17
 */
public class NO66_FullJustifyTest {

    public static void main(String[] args) {
//        String[] words={"This","is","an","example","of","text","justification."};
        String[] words = {"what", "must", "be", "acknowledgment", "shall", "be"};
//        String[] words={"science","is","what","we","understand","well","enough","to","explain","to","a","computer.","art","is","everything","else","we","do"};

//        String[] words={"listen","to","many","speak","be","a","few"};
        int maxWidth = 16;


        List<String> ans = fullJustify(words, maxWidth);
        for (String str : ans) {
            System.out.println(str);
        }

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int len = words[0].length();

        line.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (len + 1 + word.length() <= maxWidth) {
                len = len + 1 + word.length();
                line.add(word);
            } else {
                lines.add(line);
                line = new ArrayList<>();
                line.add(word);
                len = word.length();
            }
        }
        lines.add(line);

        //　调空格数
        List<String> ans = new ArrayList<>();
        for (int index = 0; index < lines.size() - 1; index++) {
            List<String> temp = lines.get(index);
            int length = 0;
            for (String str : temp) {
                length += str.length();
            }
            int more = maxWidth - length;
            int divisor;
            int remainder;
            if (temp.size() == 1) {
                divisor = more;
                remainder = 0;
            } else {
                divisor = more / (temp.size() - 1);
                remainder = more % (temp.size() - 1);
            }

            StringBuffer sb = new StringBuffer(temp.get(0));
            for (int i = 1; i < temp.size(); i++) {
                int blank = 0;
                if (remainder-- > 0) {
                    blank = divisor + 1;
                } else {
                    blank = divisor;
                }

                for (int j = 0; j < blank; j++) {
                    sb.append(" ");
                }
                sb.append(temp.get(i));

            }

            while (sb.length() < maxWidth) {
                sb.append(" ");
            }

            ans.add(sb.toString());
        }

        List<String> last = lines.get(lines.size() - 1);
        StringBuffer sb = new StringBuffer(last.get(0));
        for (int i = 1; i < last.size(); i++) {
            sb.append(" ");
            sb.append(last.get(i));
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        ans.add(sb.toString());

        return ans;
    }


}
