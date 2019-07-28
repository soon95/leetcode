import java.util.HashMap;
import java.util.Map;

/**
 * @author Leon Song
 * @date 2019-07-27
 */
public class NO5034_LargestUniqueNumberTest {
    public static void main(String[] args) {
        //
        int[] nums = {5, 7, 3, 9, 4, 9, 8, 3, 1};
        //
        System.out.println(largestUniqueNumber(nums));
    }

    public static int largestUniqueNumber(int[] nums) {
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int cur = map.getOrDefault(num, 0);
            map.put(num, cur + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                max = Math.max(max, num);
            }
        }

        return max;
    }
}
