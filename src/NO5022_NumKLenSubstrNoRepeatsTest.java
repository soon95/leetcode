import java.util.HashMap;
import java.util.Map;

/**
 * @auther Leon Song
 * @date 2019-06-29 22:57
 */
public class NO5022_NumKLenSubstrNoRepeatsTest {
    public static void main(String[] args) {
        //
        String str = "home";//havefunonleetcode
        //0123456789
        int k = 5;
        //
        System.out.println(numKLenSubstrNoRepeats(str, k));
    }

    public static int numKLenSubstrNoRepeats(String str, int k) {
        char[] chars = str.toCharArray();
        int count = 0;
        int len = chars.length;
        if (k > len) {
            return count;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int temp = map.getOrDefault(chars[i], 0);
            map.put(chars[i], temp + 1);
        }
        if (map.size() == k) {
            count++;
        }

        int index = k;

        while (index < len) {

            int temp = map.get(chars[index - k]);

            if (temp == 1) {
                map.remove(chars[index - k]);
            } else {
                map.put(chars[index - k], temp - 1);
            }

            temp = map.getOrDefault(chars[index], 0);
            map.put(chars[index], temp + 1);

            if (map.size() == k) {
                count++;
            }

            index++;
        }

        return count;
    }
}
