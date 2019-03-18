import java.util.Arrays;

public class IsValidSudokuTest {
	public static void main(String[] args) {
		//
		char[][] board= {{'1','3','.','.','7','.','.','.','.'},
						 {'6','.','.','1','9','5','.','.','.'},
						 {'.','9','8','.','.','.','.','6','.'},
						 {'8','.','.','.','.','6','.','.','3'},
						 {'4','.','.','8','.','3','.','.','1'},
						 {'7','.','.','.','2','.','.','.','6'},
						 {'.','6','.','.','.','.','2','8','.'},
						 {'.','.','.','4','1','9','.','.','5'},
						 {'.','.','.','.','8','.','.','7','9'},
						};
		//
//		System.out.println(isOnly(board[0]));
		System.out.println(isValidSudoku(board));
		
	}
	public static boolean isValidSudoku(char[][] board) {
		char[] temp=new char[9];
		for (int i = 0; i < 9; i++) {//检验每行
			for (int j = 0; j < 9; j++) {
				temp[j]=board[i][j];
			}
			if (!isOnly(temp)) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {//检验每列
			for (int j = 0; j < 9; j++) {
				temp[j]=board[j][i];
			}
			if (!isOnly(temp)) {
				return false;
			}
		}
		for (int i = 0; i < 3; i++) {//检验每个宫格
			for (int j = 0; j < 3; j++) {
				int index=0;
				temp[index++]=board[3*i][3*j];
				temp[index++]=board[3*i][3*j+1];
				temp[index++]=board[3*i][3*j+2];
				temp[index++]=board[3*i+1][3*j];
				temp[index++]=board[3*i+1][3*j+1];
				temp[index++]=board[3*i+1][3*j+2];
				temp[index++]=board[3*i+2][3*j];
				temp[index++]=board[3*i+2][3*j+1];
				temp[index++]=board[3*i+2][3*j+2];
				
				if (!isOnly(temp)) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isOnly(char[] arr) {
		int[] count=new int[9];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]!='.') {
				count[arr[i]-'1']++;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i]>1) {
				return false;
			}
		}
		return true;
	}
}
