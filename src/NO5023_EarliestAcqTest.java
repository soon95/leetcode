import java.util.Arrays;
import java.util.Comparator;


/**
 * @auther Leon Song
 * @date 2019-06-29 23:30
 */
public class NO5023_EarliestAcqTest {
    public static void main(String[] args) {
        // TODO: 未完成
        int[][] logs = {{20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}};
        int num = 6;
        //
        System.out.println(earliestAcq(logs, num));

    }

    public static int earliestAcq(int[][] logs, int num) {
        int earliest = -1;

        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        boolean[][] acq = new boolean[num][num];

        for (int[] log : logs) {
            acq[log[1]][log[2]] = true;

            int temp = totalCount(acq);
            if (temp == num) {
                earliest = log[0];
                break;
            }

        }
        return earliest;
    }

    private static int totalCount(boolean[][] acq) {
        int count = 0;

        int len = acq.length;
        boolean[][] isVisited = new boolean[len][len];

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                int temp = 0;

                temp = dfs(acq, isVisited, row, col, temp);

                count = Math.max(count, temp);

            }
        }


        return count;
    }

    private static int dfs(boolean[][] acq, boolean[][] isVisited, int row, int col, int count) {
        if (acq[row][col] && !isVisited[row][col]) {
            count++;
            isVisited[row][col] = true;
            return dfs(acq, isVisited, col, row, count);

        } else {
            return count;
        }

    }

}
