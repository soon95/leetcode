package hot150;

import java.util.Arrays;

/**
 * @author Leon Song
 * @date 12/9/23
 */
public class No274Test {


    public int hIndex(int[] citations) {


        Arrays.sort(citations);

        int length = citations.length;

        int index = 0;
        while (index < length) {

            if (citations[index] >= length - index) {
                break;
            }

            index++;

        }


        return length - index;
    }


    public static void main(String[] args) {


//        int[] citations = new int[]{3,0,6,1,5};
        int[] citations = new int[]{1, 3, 1};

        No274Test test = new No274Test();

        int ans = test.hIndex(citations);
        System.out.println(ans);

    }
}
