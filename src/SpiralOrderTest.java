import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpiralOrderTest {
	public static void main(String[] args) {
		//
		int[][] matrix= {{1,2}
					     };
		//
		System.out.println(spiralOrder(matrix));
		
	}
	
	public static List<Integer> spiralOrder(int[][] matrix){
		ArrayList<Integer> ans=new ArrayList<>();
		
		if (matrix.length==0) {
			return ans;
		} else if(matrix[0].length==1) {
			for (int i = 0; i < matrix.length; i++) {
				ans.add(matrix[i][0]);
			}
			return ans;
		} else if (matrix.length==1) {
			for (int i = 0; i < matrix[0].length; i++) {
				ans.add(matrix[0][i]);
			}
			return ans;
		}
		
		
		int[] indexEle= {0,0,RIGHT};
		
		while(!isEnd(matrix, indexEle)) {
			ans.add(matrix[indexEle[0]][indexEle[1]]);
			matrix[indexEle[0]][indexEle[1]]=FLAG;
			indexEle=nextEle(matrix, indexEle);
		}
		ans.add(matrix[indexEle[0]][indexEle[1]]);
		return ans;
	}
	
	public static boolean isEnd(int[][] matrix,int[] thisEle) {
		int[] next=new int[3];
		next=nextEle(matrix, thisEle);
		return isBoundary(matrix, thisEle)&&matrix[next[0]][next[1]]==FLAG;
	}
	
	public static int[] nextEle(int[][] matrix,int[] thisEle) {
		int[] next=new int[3];
		
		
		switch (thisEle[2]) {
		case RIGHT:
			if (!isBoundary(matrix, thisEle)) {
				next[0]=thisEle[0];
				next[1]=thisEle[1]+1;
				next[2]=RIGHT;
			} else {
				next[0]=thisEle[0]+1;
				next[1]=thisEle[1];
				next[2]=DOWN;
			}
			break;
		case DOWN:
			if (!isBoundary(matrix, thisEle)) {
				next[0]=thisEle[0]+1;
				next[1]=thisEle[1];
				next[2]=DOWN;
			} else {
				next[0]=thisEle[0];
				next[1]=thisEle[1]-1;
				next[2]=LEFT;
			}
			break;
		case LEFT:
			if (!isBoundary(matrix, thisEle)) {
				next[0]=thisEle[0];
				next[1]=thisEle[1]-1;
				next[2]=LEFT;
			} else {
				next[0]=thisEle[0]-1;
				next[1]=thisEle[1];
				next[2]=UP;
			}
			break;
		case UP:
			if (!isBoundary(matrix, thisEle)) {
				next[0]=thisEle[0]-1;
				next[1]=thisEle[1];
				next[2]=UP;
			} else {
				next[0]=thisEle[0];
				next[1]=thisEle[1]+1;
				next[2]=RIGHT;
			}
			break;
		}
		
		return next;
	}
	
	public static boolean isBoundary(int[][] matrix,int[] thisEle) {
		switch (thisEle[2]) {
		case RIGHT:
			if (thisEle[1]==matrix[0].length-1) {
				return true;
			} else if(matrix[thisEle[0]][thisEle[1]+1]==FLAG) {
				return true;
			} else {
				return false;
			}
		case DOWN:
			if (thisEle[0]==matrix.length-1) {
				return true;
			} else if(matrix[thisEle[0]+1][thisEle[1]]==FLAG) {
				return true;
			} else {
				return false;
			}
		case LEFT:
			if (thisEle[1]==0) {
				return true;
			} else if(matrix[thisEle[0]][thisEle[1]-1]==FLAG) {
				return true;
			} else {
				return false;
			}
		case UP:
			if(matrix[thisEle[0]-1][thisEle[1]]==FLAG) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	public static final int RIGHT=1;
	public static final int DOWN=2;
	public static final int LEFT=3;
	public static final int UP=4;
	public static final int FLAG=Integer.MAX_VALUE;
}
