import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=featured-list&envId=2cktkvj
 */
public class No84LargestRectangleAreaTest {


    public int largestRectangleArea(int[] heights) {

        int ans=heights[0];

        int length = heights.length;
        int[] nums=new int[length+2];
        for (int i = 0; i < length; i++) {
            nums[i+1]=heights[i];
        }

        // 一个单调栈
        Stack<Integer> stack=new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){

                int height=nums[stack.pop()];

                int width=i-stack.peek()-1;

                int temp=height*width;

                ans=Math.max(ans,temp);
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {


//        int[] heights = new int[]{2,1,5,6,2,3};
        int[] heights = new int[]{1,2};


        No84LargestRectangleAreaTest test = new No84LargestRectangleAreaTest();

        System.out.println(test.largestRectangleArea(heights));


    }



}
