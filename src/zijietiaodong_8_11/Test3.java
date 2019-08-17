package zijietiaodong_8_11;

import java.util.Scanner;

/**
 * @author Leon Song
 * @date 2019-08-11
 */
public class Test3 {
    public static void main(String[] args) {
        //
//        int n=4;
//        int[] nums={3,9,2,7};
//        System.out.println(minMoney(n, nums));
        //

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(minMoney(n, nums));
    }

    public static int minMoney(int n, int[] nums) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        boolean flag = true;
        while (flag) {
            flag = false;

            //从左往右
            for (int i = 1; i < n; i++) {
                if ((nums[i] > nums[i - 1])
                        && (res[i] <= res[i - 1])) {
                    flag = true;
                    res[i] = res[i - 1] + 1;
                }
            }

            //从右往左
            for (int i = n - 2; i >= 0; i--) {
                if ((nums[i] > nums[i + 1])
                        && (res[i] <= res[i + 1])) {
                    flag = true;
                    res[i] = res[i + 1] + 1;
                }
            }

        }
        int sum = 0;
        for (int money : res) {
            sum += money;
        }
        return sum * 100;
    }
}
