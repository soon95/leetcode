import java.util.ArrayList;
import java.util.List;

public class MinimumTotalTest {
	public static void main(String[] args) {
		//
		List<Integer> l1=new ArrayList<>();
		l1.add(2);
		List<Integer> l2=new ArrayList<>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3=new ArrayList<>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4=new ArrayList<>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		
		List<List<Integer>> triangle=new ArrayList<>();
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		//
		System.out.println(minimumTotal(triangle));
	}
	public static int minimumTotal(List<List<Integer>> triangle) {
		int length=triangle.size();
		int[][] dp=new int[length][length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = i+1; j < dp.length; j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		dp[0][0]=triangle.get(0).get(0);
		for (int i = 1; i < length; i++) {
			int size=triangle.get(i).size();
			for (int j = 0; j < size; j++) {
				if (j==0) {
					dp[i][j]=triangle.get(i).get(j)+dp[i-1][j];
				} else if (j==size-1) {
					dp[i][j]=triangle.get(i).get(j)+dp[i-1][j-1];
				} else {
					dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j-1], dp[i-1][j]);
				}
			}
		}
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			min=Math.min(min, dp[length-1][i]);
		}
		return min;
	}
}
