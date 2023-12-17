package hot150;

import java.util.*;

/**
 * @author Leon Song
 * @date 12/17/23
 */
public class No380Test {


    public static void main(String[] args) {


        RandomizedSet randomizedSet = new RandomizedSet();

        randomizedSet.insert(1);

        randomizedSet.remove(2);

        randomizedSet.insert(2);

        int res1 = randomizedSet.getRandom();
        System.out.println(res1);

        randomizedSet.remove(1);

        randomizedSet.insert(2);

        int res2 = randomizedSet.getRandom();
        System.out.println(res2);


    }


}

class RandomizedSet {

    Map<Integer, Integer> map = new HashMap();

    List<Integer> list = new ArrayList<>();


    public RandomizedSet() {

    }

    public boolean insert(int val) {


        boolean containsKey = map.containsKey(val);
        if (containsKey) {
            return false;
        }


        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        boolean containsKey = map.containsKey(val);
        if (!containsKey) {
            return false;
        }

        Integer index = map.get(val);


        // 将最后一个元素的位置改成index


        Integer lastVal = list.get(list.size() - 1);
        map.put(lastVal, index);
        list.set(index, lastVal);
        list.remove(list.size() - 1);

        map.remove(val);


        return true;
    }

    public int getRandom() {


        int size = list.size();


        Random random = new Random();
        int index = random.nextInt(size);

        return list.get(index);
    }
}
