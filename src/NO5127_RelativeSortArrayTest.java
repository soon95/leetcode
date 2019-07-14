import java.util.*;

/**
 * @author Leon Song
 * @date 2019-07-14
 */
public class NO5127_RelativeSortArrayTest {
    public static void main(String[] args) {
        //
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        //
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int x : arr1) {
            list.add(x);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1) && map.containsKey(o2)) {
                    return map.get(o1) - map.get(o2);
                } else if (map.containsKey(o1) && !map.containsKey(o2)) {
                    return -1;
                } else if (!map.containsKey(o1) && map.containsKey(o2)) {
                    return 1;
                } else {
                    return o1 - o2;
                }
            }
        });


        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
