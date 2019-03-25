
public class MaxAreaOfIslandTest {
	public static void main(String[] args) {
		//
		int[][] grid= {{0,0,1,0,0,0,0,1,0,0,0,0,0},
					   {0,0,0,0,0,0,0,1,1,1,0,0,0},
					   {0,1,1,0,1,0,0,0,0,0,0,0,0},
					   {0,1,0,0,1,1,0,0,1,0,1,0,0},
					   {0,1,0,0,1,1,0,0,1,1,1,0,0},
					   {0,0,0,0,0,0,0,0,0,0,1,0,0},
					   {0,0,0,0,0,0,0,1,1,1,0,0,0},
					   {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		System.out.println(dfs(grid, 0, 0));
		//
		System.out.println(maxAreaOfIsland(grid));
	}
	
	public static int maxAreaOfIsland(int[][] grid) {
		int max=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				max=Math.max(max, dfs(grid, i, j));
			}
		}
		return max;
	}
	public static int dfs(int[][] grid,int x,int y) {
		if (x<0||x>=grid.length||y<0||y>=grid[0].length) {
			return 0;
		} else if (grid[x][y]==0) {
			return 0;
		} else {
			int count=1;
			grid[x][y]=0;
			count+=dfs(grid, x+1, y)+dfs(grid, x-1, y)+dfs(grid, x, y+1)+dfs(grid, x, y-1);
			return count;
		}
	}
}
