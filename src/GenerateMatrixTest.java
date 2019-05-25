import java.util.Arrays;

public class GenerateMatrixTest {
	public static void main(String[] args) {
		//
		int n=5;
		//
		int[][] matrix=generateMatrix(n);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	public static int[][] generateMatrix(int n){
		int[][] matrix=new int[n][n];
		
		int row=0;
		int col=-1;
		String nextDir="right";
		for (int i = 1; i <= n*n; i++) {
			nextDir=nextDirection(row, col, nextDir, matrix);
			if (nextDir.equals("right")) {
				matrix[row][++col]=i;
			} else if (nextDir.equals("down")) {
				matrix[++row][col]=i;
			} else if (nextDir.equals("left")) {
				matrix[row][--col]=i;
			} else if (nextDir.equals("up")) {
				matrix[--row][col]=i;
			}
		}
		return matrix;
	}
	public static String nextDirection(int row,int col,String direction,int[][] matrix) {
		int length=matrix.length;
		
		if (direction.equals("right")) {
			if (col<length-1&&matrix[row][col+1]==0) {//没到头
				return "right";
			} else {
				return "down";
			}
		} else if (direction.equals("down")) {
			if (row<length-1&&matrix[row+1][col]==0) {
				return "down";
			} else {
				return "left";
			}
		} else if (direction.equals("left")) {
			if (col>0&&matrix[row][col-1]==0) {
				return "left";
			} else {
				return "up";
			}
		} else if (direction.equals("up")) {
			if (row>0&&matrix[row-1][col]==0) {
				return "up";
			} else {
				return "right";
			}
		}
		return "方向输入错误";
	}
}
