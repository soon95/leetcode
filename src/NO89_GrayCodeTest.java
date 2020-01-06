import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Leon Song
 * @date: 2020/1/6
 */
public class NO89_GrayCodeTest {
    public static void main(String[] args) {
        //
        int n = 2;
        //
        System.out.println(Arrays.toString(grayCode(n).toArray()));
    }


    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ i / 2);
        }

        return ans;
    }

}
