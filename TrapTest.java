
public class TrapTest {
	public static void main(String[] args) {
		//
		int[] height= {0,2,0};//0,1,0,2,1,0,1,3,2,1,2,1
		//
		System.out.println(trap(height));
		
//		int deep=2;
//		System.out.println(sumVolume(height, deep));
	}
	
	public static int trap(int[] height) {
		int sumWater=0;
		int length=height.length;
		if (length<3) {
			return sumWater;
		}
		
		int[] maxRs=new int[length];//记录从右往左的峰值
		int maxR=0;
		for (int i = length-1; i >= 0; i--) {
			if (maxR<height[i]) {
				maxR=height[i];
				maxRs[i]=maxR;
			} else {
				maxRs[i]=maxR;
			}
		}
		
		int maxL=height[0];
		for (int i = 1; i < length-1; i++) {
			if (maxL<height[i]) {
				maxL=height[i];
			}
			sumWater+=Math.min(maxL, maxRs[i])-height[i];
		}
		return sumWater;
	}
	
	
	public static int trap2(int[] height) {//时间复杂度不满足
		int ans=0;
		int heightest=0;
		int lowest=Integer.MAX_VALUE;
		for(int temp:height) {
			if (temp>heightest) {
				heightest=temp;
			}
			if (temp<lowest) {
				lowest=temp;
			}
		}
		for (int i = lowest; i <= heightest; i++) {
			ans+=sumVolume(height, i);
		}
		return ans;
	}
	public static int sumVolume(int[] height,int deep) {
		int volume=0;
		int index=0;
		while(height[index]<deep) {//定位到当前深度
			index++;
		}
		if (index==height.length-1) {
			return volume;
		}
		int preIndex=index++;
		for ( ; index < height.length; index++) {
			if (height[index]>=deep) {
				volume+=index-preIndex-1;
				preIndex=index;
			}
		}
		return volume;
	}
}
