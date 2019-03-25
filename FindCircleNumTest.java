
public class FindCircleNumTest {
	public static void main(String[] args) {
		//
		int[][] m= {{1,1,0},
					{1,1,0},
					{0,0,1}};
		//
		System.out.println(findCircleNum(m));
	}
	public static int findCircleNum(int[][] m) {
		int count=0;
		for (int i = 0; i < m.length; i++) {
			if (m[i][i]==1) {
				count++;				
				dfs(m, i);
			}
		}
		return count;
	}
	public static void dfs(int[][] m,int x) {
		m[x][x]=0;
		for (int i = 0; i < m.length; i++) {
			if (i!=x&&m[x][i]==1) {
				m[x][i]=0;
				m[i][x]=0;
				dfs(m, i);
			}
		}
	}
}
