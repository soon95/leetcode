package practise2025.island;

class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '0') {
                    continue;
                }
                if (visited[i][j]) {
                    continue;
                }
                cnt++;
                visit(grid, visited, i, j);
            }
        }

        return cnt;
    }

    private void visit(char[][] grid, boolean[][] visited, int i, int j) {

        if (grid[i][j] == '0') {
            return;
        }

        if (visited[i][j]) {
            return;
        }


        visited[i][j] = true;

        int m = grid.length;
        int n = grid[0].length;

        if (i - 1 >= 0) {
            visit(grid, visited, i - 1, j);
        }
        if (i + 1 < m) {
            visit(grid, visited, i + 1, j);
        }
        if (j - 1 >= 0) {
            visit(grid, visited, i, j - 1);
        }
        if (j + 1 < n) {
            visit(grid, visited, i, j + 1);
        }

    }


    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        Solution s = new Solution();
        int res = s.numIslands(grid);

        System.out.println(res);


    }
}
