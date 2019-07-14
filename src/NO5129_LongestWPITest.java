/**
 * @author Leon Song
 * @date 2019-07-14
 */
public class NO5129_LongestWPITest {
    public static void main(String[] args) {
        //
        int[] hours = {6, 9, 9};
        //
        System.out.println(longestWPI(hours));
    }

    public static int longestWPI(int[] hours) {
        int len = hours.length;

        int s[] = new int[len + 1];

        for (int i = 0; i < len; ++i) {
            s[i + 1] = s[i] + ((hours[i] > 8) ? 1 : 0);
            System.out.println(hours[i]);
        }
        int longest = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                int tot = j - i + 1;
                if (tot <= longest) {
                    continue;
                }
                int lao = s[j + 1] - s[i];
                if (lao > tot - lao) {
                    longest = Math.max(longest, tot);
                }
            }
        }
        return longest;
    }
}
