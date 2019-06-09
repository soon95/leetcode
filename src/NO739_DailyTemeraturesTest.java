import java.util.*;

/**
 * @auther Leon Song
 * @date 2019-06-09 20:43
 */
public class NO739_DailyTemeraturesTest {
    public static void main(String[] args) {
        //
        int[] dailyTemp = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        //
        //
        System.out.println(Arrays.toString(dailyTemperatures(dailyTemp)));

    }

    public static int[] dailyTemperatures(int[] dailyTemp) {
        int len = dailyTemp.length;

        int[] ans = new int[len];
        int index = len - 1;

        int[] temps = new int[101];

        ans[index] = 0;
        temps[dailyTemp[index]] = index;
        while (--index >= 0 && dailyTemp[index] > dailyTemp[index + 1]) {
            ans[index] = 0;
            temps[dailyTemp[index]] = index;
        }
        while (index >= 0) {
            if (dailyTemp[index] < dailyTemp[index + 1]) {
                ans[index] = 1;
            } else {
                for (int i = dailyTemp[index] + 1; i < 101; i++) {
                    if (temps[i] != 0) {
                        ans[index] = ans[index] != 0 ? Math.min(ans[index], temps[i] - index) : temps[i] - index;
                    }
                }
            }
            temps[dailyTemp[index]] = index;
            index--;
        }
        return ans;
    }

    public static int[] dailyTemperatures_method2(int[] dailyTemp) {
        int len = dailyTemp.length;
        int[] ans = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && dailyTemp[stack.peek()] < dailyTemp[i]) {
                int cur = stack.pop();
                ans[cur] = i - cur;
            }
            stack.push(i);
        }

        return ans;
    }

}
