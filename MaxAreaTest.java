
public class MaxAreaTest {
	public static void main(String[] args) {
		//
		int[] height= {1,8,6,2,5,4,8,3,7};
		//
		System.out.println(maxArea(height));
//		int x=1;
//		int y=8;
//		System.out.println(area(x, y, height));
	}
	public static int maxArea(int[] height) {
		int max=0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i; j < height.length; j++) {
				if (area(i, j, height)>max) {
					max=area(i, j, height);
				}
			}
		}
		return max;
	}
	
	public static int area(int x,int y,int[] height) {
		return height[x]>height[y]?(y-x)*height[y]:(y-x)*height[x];
	}
	
}
