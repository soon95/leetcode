import java.util.Arrays;

/**
 * @author Leon Song
 * @date 2019-07-06
 */
public class NO289_GameOfLifeTest {
    public static void main(String[] args) {
        //
        int[][] board = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        //
        gameOfLife(board);
        for (int[] l : board) {
            System.out.println(Arrays.toString(l));
        }
    }

    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] next = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = count(board, row, col);
                if (board[row][col] == 1) {
                    if (count < 2) {
                        next[row][col] = 0;
                    } else if (count > 3) {
                        next[row][col] = 0;
                    } else {
                        next[row][col] = 1;
                    }
                } else {
                    if (count == 3) {
                        next[row][col] = 1;
                    } else {
                        next[row][col] = 0;
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = next[row][col];
            }
        }
    }

    private static int count(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        if (row - 1 >= 0) count += board[row - 1][col];
        if (row + 1 < rows) count += board[row + 1][col];
        if (col - 1 >= 0) count += board[row][col - 1];
        if (col + 1 < cols) count += board[row][col + 1];

        if (row - 1 >= 0 && col - 1 >= 0) count += board[row - 1][col - 1];
        if (row - 1 >= 0 && col + 1 < cols) count += board[row - 1][col + 1];
        if (row + 1 < rows && col - 1 >= 0) count += board[row + 1][col - 1];
        if (row + 1 < rows && col + 1 < cols) count += board[row + 1][col + 1];

        return count;
    }
}
