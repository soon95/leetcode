
public class SuperEggDropTest {
	public static void main(String[] args) {
		//
		int k=8;
		int n=5000;
		//
		System.out.println(superEggDrop_method2(k, n));
	}

    /**
     * 算法解析
     * N层 K蛋 M(N,K)
     * 假设第一个蛋扔第t层
     * _____________________._____________________
     * 碎:M(t,K-1)     t    没碎:M(N-t,K)
     * 第一个蛋扔k层，一共需要的次数: M_k(K,N)=max{M(t,K-1),M(N-t,K)}+1
     * M(N,K)=min{M_k(N,K)}
     */
    public static int superEggDrop_method1(int eggs, int heights) {

        int[][] dp=new int[eggs+1][heights+1];
        for (int i = 1; i <= eggs; i++) {
            dp[i][1]=1;
        }
        for (int i = 1; i <= heights; i++) {
            dp[1][i]=i;
        }
        for (int height = 2; height <= heights; height++) {
            for (int egg = 2; egg <= eggs; egg++) {
                int temp=Integer.MAX_VALUE;
                for (int i = 1; i <= height; i++) {
                    temp=Math.min(temp, 1+Math.max(dp[egg-1][i-1], dp[egg][height-i]));
                }
                dp[egg][height]=temp;
            }
        }
        return dp[eggs][heights];
    }

    /**
     * 算法解析	这个方法和法一逆向思维
     * K蛋 S次机会
     * M(K,S-1): 第S次投掷蛋没碎
     * M(K-1,S-1): 第S次投掷蛋碎
     * M(K,S)=M(K,S-1)+M(K-1,S-1)+1
     *
     * 至于这里为啥是两种情况相加，我的理解是：
     * 我们每一次扔鸡蛋，不仅仅确定了下一次扔鸡蛋的楼层的方向，也确定了另一半楼层与临界楼层的大小关系，所以在递归式中，使用的不是max，而是加法。
     *
     * 这个解释时常也不能令我信服，不知道还有啥更好的解释
     * TODO
     */
    public static int superEggDrop_method2(int k, int n) {
        int[][] dp=new int[k+1][n+1];

        for (int m = 1; m <= n; m++) {//m次
            dp[0][m]=0;
            for (int i = 1; i <= k; i++) {
                dp[i][m]=dp[i][m-1]+dp[i-1][m-1]+1;
                if (dp[i][m]>=n) {
                    return m;
                }
            }

        }
        return n;
    }
}
