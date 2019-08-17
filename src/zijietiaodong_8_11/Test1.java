package zijietiaodong_8_11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Leon Song
 * @date 2019-08-11
 */
public class Test1 {

    public static void main(String[] args) {
        //
//        int n=3;
//        int[][] alarms={{5,0},
//                        {6,0},
//                        {7,0}};
//        int distance=59;
//
//        int[] target={6,59};
        //
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] alarms = new int[n][2];
        for (int i = 0; i < n; i++) {
            alarms[i][0] = input.nextInt();
            alarms[i][1] = input.nextInt();
        }
        int distance = input.nextInt();
        int[] target = new int[2];
        target[0] = input.nextInt();
        target[1] = input.nextInt();
        int[] res = alarmTime(n, alarms, distance, target);
        System.out.println(res[0] + " " + res[1]);
        //
//        System.out.println(Arrays.toString(alarmTime(n, alarms, distance, target)));
    }


    public static int[] alarmTime(int n, int[][] alarms, int distance, int[] target) {

        //倒序排列
        Arrays.sort(alarms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        for (int[] alarm : alarms) {
            if (timeBetween(alarm, target) >= distance) {
                return alarm;
            }
        }
        return null;
    }

    private static int timeBetween(int[] from, int[] to) {
        int sum = 0;

        int hours = to[0] - from[0];
        int mins = to[1] - from[1];

        sum = hours * 60 + mins;

        return sum;
    }

}
