/**
 * @author Leon Song
 * @date 2019-07-28
 */
public class NO5139_TribonacciTest {
    public static void main(String[] args) {
        //
        int n = 0;
        //
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        int[] pre = {0, 1, 1};

        if (n < pre.length) {
            return pre[n];
        }
        int cur = 2;
        int temp;
        while (cur++ < n) {
            temp = pre[0] + pre[1] + pre[2];

            pre[0] = pre[1];
            pre[1] = pre[2];
            pre[2] = temp;
        }

        return pre[2];
    }
}
