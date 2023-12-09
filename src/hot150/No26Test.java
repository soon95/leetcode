package hot150;

import java.util.Arrays;

/**
 * @author Leon Song
 * @date 12/9/23
 */
public class No26Test {


    public int removeDuplicates(int[] nums) {


        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        int index = 1;

        for (int i = 1; i < length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }

        }

        return index;
    }

    public static void main(String[] args) {


        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        No26Test test = new No26Test();

        int i = test.removeDuplicates(nums);

        System.out.println(i);
        System.out.println(Arrays.toString(nums));


    }
}
