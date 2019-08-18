package tenxun_8_17;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Leon Song
 * @date 2019-08-17
 */
public class Test3 {
    public static void main(String[] args) {
        //
        int nums = 3;
        int len = 5;
        int[][] guards = {{0, 5}, {1, 4}, {2, 3}};
//        int[][] guards={{3,6},
//                        {2,4},
//                        {0,2},
//                        {2,7}};
        System.out.println(minGuard(nums, len, guards));
        //
//        Scanner input=new Scanner(System.in);
//        int nums=input.nextInt();
//        int len=input.nextInt();
//        int[][] guards=new int[nums][2];
//        for (int i = 0; i < nums; i++) {
//            guards[i][0]=input.nextInt();
//            guards[i][1]=input.nextInt();
//        }
//        input.close();
//        System.out.println(minGuard(nums, len, guards));
    }

    public static int minGuard(int nums, int len, int[][] guards) {

        Arrays.sort(guards, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        if (guards[0][0] != 0) {
            return -1;
        }

        int[] cover = new int[nums + 1];
        int[] count = new int[nums + 1];
        for (int i = 1; i <= nums; i++) {
            count[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= nums; i++) {
            int from = guards[i - 1][0];
            int to = guards[i - 1][1];

            if (from > cover[i - 1]) {
                return -1;
            }

            if (to <= cover[i - 1]) {
                cover[i] = cover[i - 1];
                count[i] = count[i - 1];
            } else {
                cover[i] = to;
                for (int j = 0; j < i; j++) {
                    if (cover[j] >= from) {
                        count[i] = Math.min(count[i], count[j] + 1);
                    }
                }

            }
        }

        if (cover[nums] != len) {
            return -1;
        }

        return count[nums];
    }
}
