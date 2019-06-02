import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther Leon Song
 * @date 2019-06-02 21:01
 */
public class NO494_FindTargetSumWaysTest {

    public static void main(String[] args) {
        //
        int[] nums={1,0};//[42,24,30,14,38,27,12,29,43,42,5,18,0,1,12,44,45,50,21,47]
        int S=1;
        //
        System.out.println(findTargetSumWays(nums, S));

    }

    public static int findTargetSumWays(int[] nums,int target){
        int ways=0;

        Arrays.sort(nums);

        Queue<Integer> temp=new LinkedList<>();
        temp.add(0);

        for (int i = nums.length-1; i >= 0; i--) {
            int size=temp.size();
            for (int j = 0; j < size; j++) {
                int pre=temp.poll();
                if (Math.abs(pre-target)<=nums[i]*(i+1)){
                    temp.add(pre+nums[i]);
                    temp.add(pre-nums[i]);
                }
            }
        }


        for (Integer sum:temp){
            if (sum==target){
                ways++;
            }
        }

        return ways;
    }

}
