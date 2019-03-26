
public class MaximalSquareTest {
	public static void main(String[] args) {
		//
		char[][] matrix= {{'1','0','1','0','0'},
						  {'1','0','1','1','1'},
						  {'1','1','1','1','1'},
						  {'1','0','0','1','0'}};
		//
//		System.out.println(maxArea(matrix, 1, 3));
		System.out.println(maximalSquare(matrix));
	}
	public static int maximalSquare(char[][] matrix) {
		int max=0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max=Math.max(max, maxArea(matrix, i, j));
			}
		}
		return max;
	}
	public static int maxArea(char[][] matrix,int x,int y) {
		if (matrix[x][y]=='0') {
			return 0;
		}
		boolean flag=true;
		int max=1;
		int rows=matrix.length;
		int cols=matrix[0].length;
		int size;
		for (size = 1; x+size<=rows&&y+size<=cols; size++) {
			for (int row = x; row < x+size; row++) {
				if (matrix[row][y+size-1]=='0') {
					flag=false;
				}
			}
			for (int col = y; col < y+size; col++) {
				if (matrix[x+size-1][col]=='0') {
					flag=false;
				}
			}
			if (!flag) {
				break;
			}
		}
		return (int) Math.pow(size-1, 2);
	}
}
