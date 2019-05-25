import java.util.Stack;

public class LargestRectangleAreaTest {
	public static void main(String[] args) {
		//
		int[] heights= {2,1,5,6,2,3};
		//
		System.out.println(largestRectangleArea_method2(heights));
	}
	public static int largestRectangleArea_method1(int[] heights) {
		int max=0;
		
		int left,right,temp;
		for (int i = 0; i < heights.length; i++) {
			left=i-1;
			right=i+1;
			
			while(left>=0&&heights[i]<=heights[left]) left--;
			while(right<heights.length&&heights[i]<=heights[right]) right++;
			
			temp=heights[i]*(right-left-1);
			
			if (max<temp) {
				max=temp;
			}
		}
		
		return max;
	}
	public static int largestRectangleArea_method2(int[] heights) {
		if (heights.length==0) {
			return 0;
		}
		Stack<Integer> st=new Stack<>();
		
		int max=0;
		
		for (int i = 0; i < heights.length; i++) {
			if (st.isEmpty()||heights[i]>heights[st.peek()]) {
				st.push(i);
			} else {
				int index=st.pop();
				int width=st.isEmpty()?i:i-1-st.peek();
				max=Math.max(max, heights[index]*width);
				i--;
			}
		}
		while(!st.isEmpty()) {
			int index=st.pop();
			int width=st.isEmpty()?heights.length:heights.length-1-st.peek();
			max=Math.max(max, heights[index]*width);
		}
		return max;
	}
}
