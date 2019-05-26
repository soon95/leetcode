/**
 * @auther Leon Song
 * @date 2019-05-26 17:45
 */
public class NO79_ExistTest {

    public static void main(String[] args) {
        //
        char[][] board = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'E', 'S'},
                          {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";

        //
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;


        char[] chars = word.toCharArray();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean[][] visited = new boolean[rows][cols];
                if (dfs(board, chars, row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, char[] chars, int row, int col, int index, boolean[][] visited) {
        if (index == chars.length) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return false;
        }

        if (board[row][col] != chars[index]) {
            return false;
        } else {
            index++;
            visited[row][col] = true;

            if (dfs(board, chars, row + 1, col, index, visited) ||
                    dfs(board, chars, row - 1, col, index, visited) ||
                    dfs(board, chars, row, col + 1, index, visited) ||
                    dfs(board, chars, row, col - 1, index, visited)){
                return true;
            } else {
                visited[row][col]=false;
                return false;
            }
        }

    }
}
