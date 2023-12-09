package hot150;

import java.util.Arrays;

/**
 * @author Leon Song
 * @date 12/9/23
 */
public class No88Test {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];


        this.merge(nums1, m, 0, nums2, n, 0, temp, 0);


        System.arraycopy(temp, 0, nums1, 0, temp.length);
    }

    private void merge(int[] nums1, int m, int index1, int[] nums2, int n, int index2, int[] temp, int index) {


        if (m == index1 && n == index2) {
            return;
        }

        if (m == index1) {

            temp[index++] = nums2[index2++];

        } else if (n == index2) {
            temp[index++] = nums1[index1++];
        } else {

            if (nums1[index1] <= nums2[index2]) {
                temp[index++] = nums1[index1++];
            } else {
                temp[index++] = nums2[index2++];

            }
        }

        merge(nums1, m, index1, nums2, n, index2, temp, index);
    }


    public static void main(String[] args) {


        int[] nums1 = new int[]{
                1, 2, 3, 0, 0, 0
        };
        int m = 3;

        int[] nums2 = new int[]{
                2, 5, 6, 0, 0, 0
        };
        int n = 3;

        No88Test test = new No88Test();

        test.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }


}
