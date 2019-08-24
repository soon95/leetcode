package jingdong_8_24;


import java.util.*;

/**
 * @author Leon Song
 * @date 2019-08-24
 */
public class Test2 {
    public static void main(String[] args) {
        //
        int each = 2;
        int pairs = 2;
        int[][] relationships = {{1, 3}, {1, 4}};

        //
//        Scanner input=new Scanner(System.in);
//        int each=input.nextInt();
//        int pairs=input.nextInt();
//        int[][] relationships=new int[pairs][2];
//        for (int i = 0; i < pairs; i++) {
//            relationships[i][0]=input.nextInt();
//            relationships[i][1]=input.nextInt();
//        }
//        input.close();
        //
        solve(each, pairs, relationships);
    }

    public static void solve(int each, int pairs, int[][] relationships) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pairs; i++) {
            int temp = map.getOrDefault(relationships[i][0], 0);
            map.put(relationships[i][0], temp + 1);

            temp = map.getOrDefault(relationships[i][1], 0);
            map.put(relationships[i][1], temp + 1);
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            flag = false;
            for (Integer key : map.keySet()) {
                int value = map.get(key);
                if (value > 1) {
                    flag = true;
                    count++;
                    list.add(key);
                    map.put(key, 0);
                    for (int[] relationship : relationships) {
                        if (relationship[0] == key) {
                            map.put(relationship[1], map.get(relationship[1]) - 1);
                        } else if (relationship[1] == key) {
                            map.put(relationship[0], map.get(relationship[0]) - 1);
                        }
                    }
                }
            }
        }

        System.out.println(count);

        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.append(list.get(list.size() - 1));
        System.out.println(sb.toString());
    }

    public static void method2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] num = new int[2 * m];
        int index = 0;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            num[index++] = x;
            int y = in.nextInt();
            num[index++] = y;
            Integer[] arr = {x, y};
            list.add(arr);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : num) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list1 = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue() - o1.getValue());   //按降序
            }
        });
    }
}
