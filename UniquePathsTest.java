
public class UniquePathsTest {
	public static void main(String[] args) {
		//
		int m=3;
		int n=2;
		//
		System.out.println(uniquePaths(m, n));
//		System.out.println(arrange(3));
	}
	public static int uniquePaths(int m,int n) {
		int[][] paths=new int[m][n];
		
		for (int i = 0; i < m; i++) {
			paths[i][0]=1;
		}
		for (int i = 0; i < n; i++) {
			paths[0][i]=1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				paths[i][j]=paths[i-1][j]+paths[i][j-1];
			}
		}
		return paths[m-1][n-1];
	}
	//ตÝน้
	public static int paths(int x,int y) {
		if (x==1||y==1) {
			return 1;
		}
		return paths(x-1,y)+paths(x,y-1);
	}
	
	
	
	
}
