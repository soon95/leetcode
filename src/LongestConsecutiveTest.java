import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LongestConsecutiveTest {
	public static void main(String[] args) {
		//
		int[] nums= {100, 4, 200, 1, 3, 2};
		//
		System.out.println(longestConsecutive(nums));
	}
	public static int longestConsecutive(int[] nums) {
		if (nums.length==0) {
			return 0;
		}
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		HashSet<Integer> hs=new HashSet<>();
		
		for(int num:nums) {
			if (!hs.contains(num)) {
				pq.add(num);
				hs.add(num);
			}
		}
		
		int max=1;
		int count=1;
		int pre=pq.poll();
		while(!pq.isEmpty()) {
			if (pre==pq.peek()-1) {
				count++;
			} else {
				count=1;
			}
			max=Math.max(max, count);
			
			pre=pq.poll();
		}
		
		
		return max;
	}
}
