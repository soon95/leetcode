package hot150;

import java.util.Arrays;

/**
 * @author Leon Song
 * @date 12/9/23
 */
public class No27Test {


    public int removeElement(int[] nums, int val) {

        int count = 0;


        int length = nums.length;

        for (int i = length - 1; i >= 0; i--) {

            if (nums[i] == val) {
                count++;

                nums[i] = 0;

                this.exchange(nums, i, length - count);

            }

        }


        return length - count;

    }

    private void exchange(int[] nums, int index1, int index2) {

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }

    public static void main(String[] args) {


        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;


        No27Test test = new No27Test();
        int i = test.removeElement(nums, val);

        System.out.println(i);
        System.out.println(Arrays.toString(nums));

    }
}
