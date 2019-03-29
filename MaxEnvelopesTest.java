import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopesTest {
	public static void main(String[] args) {
		//
		int[][] envelopes= {{10,8},
							{1,12},
							{6,15},
							{2,18}};
		//
		System.out.println(maxEnvelopes_method1(envelopes));
		
	}
	public static int maxEnvelopes_method3(int[][] envelopes) {
		
		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]!=o2[0]) {
					return o1[0]-o2[0];
				} else {
					return o2[1]-o1[1];
				}
			}
		});
		
		int max;
		int res=0;
		for (int i = 0; i < envelopes.length; i++) {
			max=0;
			for (int j = res; j >= 0; j--) {
				if (envelopes[i][1]>envelopes[j][1]) {
					max=j+1;
					res=Math.max(res, max);
					break;
				}
			}
			if (max==res||envelopes[i][1]<envelopes[max][1]) {
				envelopes[max][1]=envelopes[i][1];
			}
		}
		return res+1;	
	}
	
	
	
	public static int maxEnvelopes_method1(int[][] envelopes) {
		int len=envelopes.length;
		if (len==0) {
			return 0;
		}
		
		Envelop[] mails=new Envelop[len];
		for (int i = 0; i < len; i++) {
			mails[i]=new Envelop(envelopes[i][0], envelopes[i][1]);
		}
		Arrays.sort(mails, new Comparator<Envelop>() {

			@Override
			public int compare(Envelop o1, Envelop o2) {
				if (o1.w>o2.w) {
					return 1;
				} else if (o1.w<o2.w) {
					return -1;
				} else {
					return o1.h-o2.h;
				}
			}
		});
		
		int[] res=new int[len];
		res[0]=1;
		for (int cur = 1; cur < res.length; cur++) {
			int max=0;
			for (int pre = 0; pre <= cur-1; pre++) {
				if (canPut(mails[cur], mails[pre])) {
					max=Math.max(max, res[pre]);
				}
			}
			res[cur]=max+1;
		}
		
		int ans=0;
		for (int i = 0; i < res.length; i++) {
			ans=Math.max(ans, res[i]);
		}
		return ans;
	}
	private static boolean canPut(Envelop e1,Envelop e2) {
		if (e1.h>e2.h&&e1.w>e2.w) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static int maxEnvelopes_method2(int[][] envelopes) {
		int length=envelopes.length;
		boolean[][] isAvali=new boolean[length][length];
		
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < isAvali.length; col++) {
				if (envelopes[row][0]>envelopes[col][0]&&envelopes[row][1]>envelopes[col][1]) {
					isAvali[row][col]=true;
				}
			}
		}
		
		int max=0;
		int temp;
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				temp=solve(isAvali, row, col);
				max=Math.max(max, temp);
			}
		}
		return max;
	}
	
	
	public static int solve(boolean[][] matrix,int row,int col) {
		if (matrix[row][col]) {
			int max=0;
			int temp;
			for (int i = 0; i < matrix.length; i++) {
				temp=solve(matrix, col, i);
				max=Math.max(max, temp);
			}
			
			return max+1;
			
		} else {
			return 1;
		}
	}
	
}
class Envelop{
	int w;
	int h;
	public Envelop(int w,int h) {
		this.w=w;
		this.h=h;
	}
}

