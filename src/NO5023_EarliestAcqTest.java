import java.util.Arrays;
import java.util.Comparator;


/**
 * @auther Leon Song
 * @date 2019-06-29 23:30
 */
public class NO5023_EarliestAcqTest {
    public static void main(String[] args) {
        //
        int[][] logs = {{20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}};
        int num = 6;
        //
        System.out.println(earliestAcq(logs, num));

    }

    public static int earliestAcq(int[][] logs, int num) {
        int earliestTime = -1;

        int[] father = new int[num];
        for (int i = 0; i < num; i++) {
            father[i] = i;
        }

        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] log : logs) {
            int time = log[0];
            int from = log[1];
            int to = log[2];

            int fromFather = getFather(father, from);
            int toFather = getFather(father, to);

            if (fromFather != toFather) {
                earliestTime = time;
                father[toFather] = fromFather;
            }
        }


        int temp = getFather(father, 0);
        for (int i = 1; i < num; i++) {
            if (temp != getFather(father, i)) {
                return -1;
            }
        }

        return earliestTime;
    }

    private static int getFather(int[] father, int index) {
        while (father[index] != index) {
            index = father[index];
        }
        return index;
    }
}
