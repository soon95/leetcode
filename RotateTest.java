import java.util.Arrays;

public class RotateTest {
	public static void main(String[] args) {
		//
		int[][] matrix= {{1,2,3},
						 {4,5,6},
						 {7,8,9}};
		//
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	public static void rotate(int[][] matrix) {
		int size=matrix.length;
		
		int temp;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size/2; j++) {
				temp=matrix[i][j];
				matrix[i][j]=matrix[i][size-j-1];
				matrix[i][size-j-1]=temp;
			}
		}
	}
}
