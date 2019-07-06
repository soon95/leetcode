/**
 * @author Leon Song
 * @date 2019-07-06
 */
public class NO240_SearchMatrixTest {
    public static void main(String[] args) {
        //
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 20;
        //
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            }

            if (cur < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
