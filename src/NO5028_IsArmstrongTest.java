import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Song
 * @date 2019-07-27
 */
public class NO5028_IsArmstrongTest {
    public static void main(String[] args) {
        //
        int num = 1;
        //
        System.out.println(isArmstrong(num));
    }

    public static boolean isArmstrong(int num) {
        int org = num;

        List<Integer> list = new ArrayList<>();

        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }

        int exp = list.size();

        int sum = 0;
        for (int n : list) {
            sum += Math.pow(n, exp);
        }

        return sum == org;
    }
}
