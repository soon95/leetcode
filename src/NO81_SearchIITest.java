/**
 * @author: Leon Song
 * @date: 2019/12/23
 */
public class NO81_SearchIITest {
    public static void main(String[] args) {
        //
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 2;
        //
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        return search(nums, target, 0, nums.length - 1);

    }

    private static boolean search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }

        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return true;
        }


        if (nums[left] < nums[middle]) {

            if (target >= nums[left] && target < nums[middle]) {
                return search(nums, target, left, middle - 1);
            } else {
                return search(nums, target, middle + 1, right);
            }
        } else if (nums[right] > nums[middle]) {

            if (target > nums[middle] && target <= nums[right]) {
                return search(nums, target, middle + 1, right);
            } else {
                return search(nums, target, left, middle - 1);
            }
        } else {
            return search(nums, target, left, middle - 1)
                    || search(nums, target, middle + 1, right);
        }
    }

}
