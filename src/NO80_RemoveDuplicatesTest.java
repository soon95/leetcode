/**
 * @author: Leon Song
 * @date: 2019/12/21
 */
public class NO80_RemoveDuplicatesTest {
    public static void main(String[] args) {
        //
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        //
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int left = 1;
        int right = 1;

        int count = 1;

        while (right < nums.length) {
            if (nums[right] == nums[right - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[left++] = nums[right];
            }

            right++;
        }

        return left;
    }
}
