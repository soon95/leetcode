package pinduoduo_7_28;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Leon Song
 * @date 2019-07-28
 */
public class Test4 {
    public static void main(String[] args) {
        //
//        Scanner input=new Scanner(System.in);
//
//        int num=input.nextInt();
//
//        int[] l=new int[num];
//        int[] w=new int[num];
//
//        for (int i = 0; i < num; i++) {
//            l[i]=input.nextInt();
//        }
//        for (int i = 0; i < num; i++) {
//            w[i]=input.nextInt();
//        }

        //
//        int num=10;
//        int[] l={1,2,3,4,5,6,7,8,9,10};
//        int[] w={1,1,1,1,1,1,1,1,1,10};

        int num = 2;
        int[] l = {1, 2};
        int[] w = {5, 5};


        System.out.println(solve(num, l, w));

    }

    public static int solve(int num, int[] l, int[] w) {
        int[][] root = new int[num][2];
        for (int i = 0; i < num; i++) {
            root[i][0] = l[i];
            root[i][1] = w[i];
        }
        Arrays.sort(root, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] dp = new int[num][2];
        dp[0][0] = root[0][1];
        dp[0][1] = 1;

        for (int cur = 1; cur < num; cur++) {

            for (int pre = 0; pre < cur; pre++) {
                if (root[cur][0] > root[pre][0]
                        && dp[pre][0] <= root[cur][1] * 7
                        && dp[cur][1] <= dp[pre][1] + 1) {

                    if (dp[cur][1] == dp[pre][1] + 1) {
                        dp[cur][0] = Math.min(dp[cur][0], dp[pre][0] + root[pre][1]);
                    } else {
                        dp[cur][0] = dp[pre][0] + root[pre][1];
                    }
                    dp[cur][1] = dp[pre][1] + 1;
                }
            }
        }

        int max = 0;
        for (int[] x : dp) {
            max = Math.max(max, x[1]);
        }
        return max;
    }
}
