import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlidingWindowTest {
	public static void main(String[] args) {
		//
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		//
		System.out.println(Arrays.toString(maxSlidingWindow_method2(nums, k)));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;

		if (k == 0) {
			return new int[len];
		}

		int[] ans = new int[len - k + 1];

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int index = 0;
		while (index < len) {
			pq.add(nums[index]);

			if (pq.size() == k) {
				ans[index - k + 1] = pq.peek();
				pq.remove(nums[index - k + 1]);
			}
			index++;
		}

		return ans;
	}

	public static int[] maxSlidingWindow_method2(int[] nums, int k) {
		if (nums == null || nums.length < k || k == 0) {
			return new int[0];
		}
		int[] res = new int[nums.length - k + 1];

		// 双端队列
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			// 在尾部添加元素，并保证左边元素都比尾部大
			while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
			// 在头部移除元素
			if (deque.getFirst() == i - k) {
				deque.removeFirst();
			}
			// 输出结果
			if (i >= k - 1) {
				res[i - k + 1] = nums[deque.getFirst()];
			}
		}

		return res;
	}
}
