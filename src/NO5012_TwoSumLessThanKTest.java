import java.util.Arrays;

/**
 * @auther Leon Song
 * @date 2019-06-29 22:30
 */
public class NO5012_TwoSumLessThanKTest {
    public static void main(String[] args) {
        //
        int[] arr = {34, 23, 1, 24, 75, 33, 54, 8};//{34,23,1,24,75,33,54,8}
        int max = 60;
        //
        System.out.println(twoSumLessThank(arr, max));

    }


    public static int twoSumLessThank(int[] arr, int max) {
        Arrays.sort(arr);
        int len = arr.length;
        int sum = -1;

        int right = 0;
        while (right < len && arr[right] < max) {
            right++;
        }

        if (right <= 1) {
            return sum;
        }


        for (int index = 0; index < right; index++) {
            for (int next = right - 1; next > index; next--) {
                int temp = arr[index] + arr[next];
                if (temp < max) {
                    sum = Math.max(sum, temp);
                    break;
                }
            }
        }

        return sum;
    }
}
