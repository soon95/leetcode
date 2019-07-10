import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Song
 * @date 2019-07-10
 */
public class NO77_CombineTest {
    public static void main(String[] args) {
        //
        int n = 10;
        int k = 3;
        //
        List<List<Integer>> ans = combine(n, k);
        for (List<Integer> list : ans) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            dfs(n, k, ans, temp, i);
        }

        return ans;
    }

    private static void dfs(int n, int k, List<List<Integer>> ans, List<Integer> temp, int cur) {
        temp.add(cur);
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = cur + 1; i <= n; i++) {
                dfs(n, k, ans, temp, i);
            }
        }
        temp.remove(temp.size() - 1);
    }
}
