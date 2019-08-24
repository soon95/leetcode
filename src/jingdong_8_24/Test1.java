package jingdong_8_24;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Leon Song
 * @date 2019-08-24
 */
public class Test1 {
    public static void main(String[] args) {
        //
        int nums = 5;
        int[] heights = {1, 2, 3, 2, 1};
//        int[] heights={69079936,
//                236011312,77957850,653604087,443890802,277126428,755625552,768751840,993860213,882053548};
        //
//        Scanner input=new Scanner(System.in);
//        int nums=input.nextInt();
//        int[] heights=new int[nums];
//        for (int i = 0; i < nums; i++) {
//            heights[i]=input.nextInt();
//        }
//        input.close();
        System.out.println(maxGroup(nums, heights));
    }

    public static int maxGroup(int nums, int[] heights) {

        int[] max = new int[nums + 1];
        int[] dp = new int[nums + 1];

        max[0] = Integer.MIN_VALUE;
        dp[0] = 0;

        int index;
        for (int cur = 1; cur <= nums; cur++) {
            index = cur - 1;//heights坐标
            if (heights[index] >= max[cur - 1]) {
                max[cur] = heights[index];
                dp[cur] = dp[cur - 1] + 1;
            } else {
                int pre = cur - 1;
                while (heights[index] < max[pre]) {
                    pre--;
                }
                max[cur] = max[cur - 1];
                dp[cur] = dp[pre] + 1;
            }
        }
        return dp[nums];
    }

    public static void method2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] high = new int[n];
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            high[i] = in.nextInt();
            sorted[i] = high[i];
        }
        Arrays.sort(sorted);
        int start = 0, end = 0, group = 0;
        int total = high[start];
        int total2 = sorted[start];
        while (end < n) {
            while (total != total2) {
                end++;
                total += high[end];
                total2 += sorted[end];
            }
            group++;
            end++;
            if (end >= high.length)
                break;
            start = end;
            total = high[start];
            total2 = sorted[start];
        }
        System.out.println(group);
    }
}