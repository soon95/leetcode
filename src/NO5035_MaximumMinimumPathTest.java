import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @auther Leon Song
 * @date 2019-06-30 09:44
 */
public class NO5035_MaximumMinimumPathTest {

    public static void main(String[] args) {
        //
        int[][] map = {{2, 2, 1, 2, 2, 2},//[2,2,1,2,2,2],[1,2,2,2,1,2]
                {1, 2, 2, 2, 1, 2}};

        //
        System.out.println(maximumMinimumPath(map));

    }

    public static int maximumMinimumPath(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        int minPath = Integer.MAX_VALUE;
        boolean[][] isVisited = new boolean[rows][cols];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        pq.add(new int[]{map[0][0], 0, 0});

        while (true) {

            int[] cur = pq.poll();
            int val = cur[0];
            int row = cur[1];
            int col = cur[2];

            isVisited[row][col] = true;
            minPath = Math.min(minPath, val);

            if (row == rows - 1 && col == cols - 1) {
                break;
            }

            if (row - 1 >= 0 && row - 1 < rows && col >= 0 && col < cols && !isVisited[row - 1][col]) {
                pq.add(new int[]{map[row - 1][col], row - 1, col});
            }
            if (row + 1 >= 0 && row + 1 < rows && col >= 0 && col < cols && !isVisited[row + 1][col]) {
                pq.add(new int[]{map[row + 1][col], row + 1, col});
            }
            if (row >= 0 && row < rows && col - 1 >= 0 && col - 1 < cols && !isVisited[row][col - 1]) {
                pq.add(new int[]{map[row][col - 1], row, col - 1});
            }
            if (row >= 0 && row < rows && col + 1 >= 0 && col + 1 < cols && !isVisited[row][col + 1]) {
                pq.add(new int[]{map[row][col + 1], row, col + 1});
            }

        }

        return minPath;
    }

}
