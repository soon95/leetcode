import java.util.Arrays;

public class SolveSudokuTest {
	public static void main(String[] args) {
		//
		char[][] board= {{'5','3','.','.','7','.','.','.','.'},
						 {'6','.','.','1','9','5','.','.','.'},
						 {'.','9','8','.','.','.','.','6','.'},
						 {'8','.','.','.','6','.','.','.','3'},
						 {'4','.','.','8','.','3','.','.','1'},
						 {'7','.','.','.','2','.','.','.','6'},
						 {'.','6','.','.','.','.','2','8','.'},
						 {'.','.','.','4','1','9','.','.','5'},
						 {'.','.','.','.','8','.','.','7','9'}};

		//
		System.out.println("题目：");
		print(board);
		solveSudoku(board);
		System.out.println("答案：");
		print(board);
		
	}
	public static void solveSudoku(char[][] board) {
		solve(board);
	}
	public static boolean solve(char[][] board) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (board[row][col]=='.') {
					for (int number = 1; number <= 9; number++) {//逐个尝试
						if (check(row, col, number, board)) {
							board[row][col]=(char) ('0'+number);
							
							if (solve(board)) {
								return true;
							} else {
								board[row][col]='.';
							}
						}
					}
					return false;//所有尝试失败，则该问题无解
				}
				
			}
		}
		return true;
	}
	public static boolean check(int row,int col,int number,char[][] board) {
		for (int i = 0; i < 9; i++) {//判断行和列是否有重复
			if (board[row][i]-'0'==number||board[i][col]-'0'==number) {
				return false;
			}
		}
		//判断小九宫格内是否有重复
		int thisRow=row/3;
		int thisCol=col/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[thisRow*3+i][thisCol*3+j]-'0'==number) {
					return false;
				}
			}
		}
		return true;
	}

	public static void print(char[][] board) {
		for (int i = 0; i < 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
