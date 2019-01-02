import java.util.ArrayList;
import java.util.List;

public class TotalNQueensTest {
	public static void main(String[] args) {
		int n=4;
		System.out.println(totalNQueens(n));
	}
	public static int totalNQueens(int n){
		List<String> board=generateBoard(n);
		
		List<List<String>> ans=new ArrayList<>();
		
		solve(board, ans, 0);
		
		return ans.size();
	}
	
	public static void solve(List<String> state,List<List<String>> ans,int row) {//解当前棋盘，返回是否可解
		int size=state.size();
		
		if (row==size) {//满足条件
			List<String> ele=new ArrayList<>(state);
			ans.add(ele);
		} else {
			for (int col = 0; col < size; col++) {
				changeBoard(state, row, col, true);
				if (satisfy(state)) {
					solve(state, ans, row+1);
				}
				changeBoard(state, row, col, false);
			}
		}
		
	}
	
	
	public static void changeBoard(List<String> board,int row,int col,boolean setQueen) {
		String str=board.get(row);
		StringBuilder strBuilder=new StringBuilder(str);
		if (setQueen) {
			strBuilder.setCharAt(col, 'Q');			
		} else {
			strBuilder.setCharAt(col, '.');
		}
		str=strBuilder.toString();
		board.set(row, str);
	}
	
	
	
	public static List<String> generateBoard(int n){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(".");
		}
		String ele=sb.toString();
		
		List<String> board=new ArrayList<>();
		for (int i = 0; i < n; i++) {
			board.add(ele);
		}
		
		return board;
	}
	
	public static boolean satisfy(List<String> state) {		
		int count;
		
		int size=state.size();
		
		//检查每行
//		for (int i = 0; i < size; i++) {
//			count=0;
//			for (int j = 0; j < size; j++) {
//				if (state.get(i).charAt(j)=='Q') {
//					count++;
//				}
//			}
//			if (count>1) {
//				return false;
//			}
//			
//		}
		//检测每列
		for (int i = 0; i < size; i++) {
			count=0;
			for (int j = 0; j < size; j++) {
				if (state.get(j).charAt(i)=='Q') {
					count++;
				}
			}
			if (count>1) {
				return false;
			}
		}
		//检测斜向
		int row;
		int col;
		int begin;
		//检测右下斜方向
		begin=0;
		while(begin<size) {
			row=begin;
			col=0;
			count=0;
			while(row<size&&col<size) {
				if (state.get(row).charAt(col)=='Q') {
					count++;
				}
				row++;
				col++;
			}
			if (count>1) {
				return false;
			}
			begin++;
		}
		
		begin=1;
		while(begin<size) {
			row=0;
			col=begin;
			count=0;
			while(row<size&&col<size) {
				if (state.get(row).charAt(col)=='Q') {
					count++;
				}
				row++;
				col++;
			}
			if (count>1) {
				return false;
			}
			begin++;
		}
		//检测左下斜方向
		begin=0;
		while(begin<size) {
			row=begin;
			col=0;
			count=0;
			while(row>=0&&col<size) {
				if (state.get(row).charAt(col)=='Q') {
					count++;
				}
				row--;
				col++;
			}
			if (count>1) {
				return false;
			}
			begin++;
		}
		
		begin=1;
		while(begin<size) {
			row=size-1;
			col=begin;
			count=0;
			while(row>=0&&col<size) {
				if (state.get(row).charAt(col)=='Q') {
					count++;
				}
				row--;
				col++;
			}
			if (count>1) {
				return false;
			}
			begin++;
		}
		return true;
		
	}
}
