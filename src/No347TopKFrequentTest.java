import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class No347TopKFrequentTest {

    public static int[] topKFrequent(int[] nums, int k) {


        Map<Integer,Integer> map=new HashMap<>();

        for (int num : nums) {

            int time = map.getOrDefault(num, 0);

            map.put(num, time + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((e1,e2)-> e2.getValue()-e1.getValue());

        map.entrySet().forEach(priorityQueue::add);


        int[] ans=new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> top = priorityQueue.poll();

            ans[i]=top.getKey();
        }

        return ans;
    }



    public static void main(String[] args) {



        int[] nums=new int[]{1,1,1,2,2,3};
        int k=2;


        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }



}
