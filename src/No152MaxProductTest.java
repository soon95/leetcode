/**
 * 152. 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/description/?envType=featured-list&envId=2cktkvj
 */
public class No152MaxProductTest {

    public int maxProduct(int[] nums) {

        int length = nums.length;

        int[] dpMax=new int[length];
        int[] dpMin=new int[length];

        dpMax[0]=nums[0];
        dpMin[0]=nums[0];

        for (int i = 1; i < length; i++) {

            int cur=nums[i];

            if (cur==0){
                dpMax[i]=0;
                dpMin[i]=0;
            }

            dpMax[i]=Math.max(cur,Math.max(dpMax[i-1]*cur,dpMin[i-1]*cur));
            dpMin[i]=Math.min(cur,Math.min(dpMax[i-1]*cur,dpMin[i-1]*cur));
        }


        int ans=Integer.MIN_VALUE;

        for (int item:dpMax){
            ans=Math.max(ans,item);
        }

        return ans;
    }

    public static void main(String[] args) {

//        int[] nums=new int[]{2,3,-2,4};
        int[] nums=new int[]{-2,1,-1};

        No152MaxProductTest test = new No152MaxProductTest();

        System.out.println(test.maxProduct(nums));

    }




}
