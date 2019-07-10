import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Leon Song
 * @date 2019-07-06
 */
public class NO149_MaxPointsTest {
    public static void main(String[] args) {
        //
//        int[][] points={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] points={{0,0}};
//        int[][] points={{1,1},{1,1},{2,2},{2,2}};
//        int[][] points={{2,3},{3,3},{-5,3}};
//        int[][] points={{0,0},{94911151,94911150},{94911152,94911151}};
        int[][] points = {{0, 0}, {1, 1}, {1, -1}};
        //
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        int nums = points.length;
        int maxPoints = 0;
        Map<Slope, Integer> map = new HashMap<>();
        for (int i = 0; i < nums; i++) {
            map.clear();
            int same = 0;
            for (int j = 0; j < nums; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                    continue;
                }
                Slope slope = new Slope(points[i], points[j]);
                int val = map.getOrDefault(slope, 0);
                map.put(slope, val + 1);
            }
            maxPoints = Math.max(maxPoints, same);
            for (int x : map.values()) {
                maxPoints = Math.max(maxPoints, x + same);
            }
        }
        return maxPoints;
    }
}

class Slope {
    public int dx;
    public int dy;

    public Slope(int[] a, int[] b) {
        dx = a[0] - b[0];
        dy = a[1] - b[1];

        if (dx == 0) {
            dx = 1;
            dy = Integer.MAX_VALUE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slope slope = (Slope) o;
        return dx * slope.dy == dy * slope.dx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(1.0 * dy / dx);
    }
}