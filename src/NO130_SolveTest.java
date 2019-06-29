import java.util.Arrays;

/**
 * @auther Leon Song
 * @date 2019-06-29 17:08
 */
public class NO130_SolveTest {
    public static void main(String[] args) {
        //
//        char[][] board = {{'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}};
        char[][] board = {{'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}};
        //
        solve(board);
        for (char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void solve(char[][] board) {

        int rows = board.length;
        if (rows == 0) return;
        int cols = board[0].length;

        boolean[][] isVisited = new boolean[rows][cols];

        char[][] ans = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                ans[row][col] = 'X';
            }
        }

        for (int col = 0; col < cols - 1; col++) {
            dfs(board, ans, 0, col, isVisited);
        }
        for (int row = 0; row < rows - 1; row++) {
            dfs(board, ans, row, cols - 1, isVisited);
        }
        for (int col = cols - 1; col >= 0; col--) {
            dfs(board, ans, rows - 1, col, isVisited);
        }
        for (int row = rows - 1; row >= 0; row--) {
            dfs(board, ans, row, 0, isVisited);
        }


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = ans[row][col];
            }
        }
    }

    private static void dfs(char[][] board, char[][] ans, int row, int col, boolean[][] isVisited) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows
                || col < 0 || col >= cols
                || board[row][col] == 'X'
                || isVisited[row][col]) {
            return;
        }

        isVisited[row][col] = true;

        ans[row][col] = 'O';

        dfs(board, ans, row - 1, col, isVisited);
        dfs(board, ans, row + 1, col, isVisited);
        dfs(board, ans, row, col - 1, isVisited);
        dfs(board, ans, row, col + 1, isVisited);

    }

}
