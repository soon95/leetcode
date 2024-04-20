import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Leon Song
 * @date 4/20/24
 */
public class No994OrangesRottingTest {

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        No994OrangesRottingTest test = new No994OrangesRottingTest();

        int res = test.orangesRotting(grid);

        System.out.println(res);

    }

    public int orangesRotting(int[][] grid) {


        Queue<Orange> oranges = new ArrayDeque<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    oranges.add(new Orange(i, j));
                }
            }
        }

        int steps = 0;

        while (!oranges.isEmpty()) {

            Queue<Orange> nextOranges = new ArrayDeque<>();


            boolean hit = false;
            while (!oranges.isEmpty()) {

                Orange orange = oranges.poll();

                int x = orange.x;
                int y = orange.y;

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {

                    grid[x - 1][y] = 2;

                    nextOranges.add(new Orange(x - 1, y));

                    hit = true;
                }

                if (x + 1 < m && grid[x + 1][y] == 1) {

                    grid[x + 1][y] = 2;

                    nextOranges.add(new Orange(x + 1, y));
                    hit = true;
                }

                if (y - 1 >= 0 && grid[x][y - 1] == 1) {

                    grid[x][y - 1] = 2;

                    nextOranges.add(new Orange(x, y - 1));
                    hit = true;
                }

                if (y + 1 < n && grid[x][y + 1] == 1) {

                    grid[x][y + 1] = 2;

                    nextOranges.add(new Orange(x, y + 1));
                    hit = true;
                }


            }


            oranges = nextOranges;

            if (hit) {
                steps++;
            }
        }


        for (int[] ints : grid) {
            for (int status : ints) {
                if (status == 1) {
                    steps = -1;
                }
            }
        }


        return steps;
    }

    class Orange {
        int x;
        int y;

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
