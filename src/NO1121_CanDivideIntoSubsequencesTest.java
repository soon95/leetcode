import java.util.HashMap;
import java.util.Map;

/**
 * @author Leon Song
 * @date 2019-07-13
 */
public class NO1121_CanDivideIntoSubsequencesTest {
    public static void main(String[] args) {
        //
        int[] nums = {1, 2, 2, 3, 3, 4, 4};
        int k = 3;
        //
        System.out.println(canDivideIntoSubsequences(nums, k));

    }

    public static boolean canDivideIntoSubsequences(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            mx = Math.max(mx, cnt.get(nums[i]));
        }

        if ((long) mx * k > nums.length) return false;
        return true;
    }
}
