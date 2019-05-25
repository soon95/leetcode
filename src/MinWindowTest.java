import java.util.HashMap;
import java.util.Map;

public class MinWindowTest {
	public static void main(String[] args) {
		//
		String s = "a";
		String t = "aa";
		//
		System.out.println(minWindow(s, t));
	}

	public static String minWindow(String s, String t) {
		char[] arr = s.toCharArray();
		char[] sub = t.toCharArray();

		Map<Character, Integer> target = new HashMap<>();
		for (int i = 0; i < sub.length; i++) {
			int temp = target.getOrDefault(sub[i], 0);
			target.put(sub[i], temp + 1);
		}

		int require = sub.length;
		int found = 0;

		int lenWindow = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;

		Map<Character, Integer> cur = new HashMap<>();
		int left = 0;
		int right = 0;
		while (right < arr.length) {
			char key = arr[right];
			int count = cur.getOrDefault(key, 0);
			cur.put(key, count + 1);

			if (target.containsKey(key) && cur.get(key) <= target.get(key)) {
				found++;
			}

			while (left <= right && require == found) {
				key = arr[left];

				if (lenWindow > right - left + 1) {
					lenWindow = right - left + 1;
					start = left;
					end = right;
				}

				count = cur.get(key);
				cur.put(key, count - 1);
				if (target.containsKey(key) && cur.get(key) < target.get(key)) {
					found--;
				}
				left++;
			}
			right++;
		}
		return lenWindow == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
	}
}
