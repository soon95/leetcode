import java.util.*;

public class No763PartitionLabelsTest {


    public static void main(String[] args) {


//        String s="ababcbacadefegdehijhklij";
        String s="eccbbbbdec";

        No763PartitionLabelsTest test = new No763PartitionLabelsTest();
        List<Integer> integers = test.partitionLabels(s);

        System.out.println(integers);

    }


    public List<Integer> partitionLabels(String s) {

        Map<Character,Integer> lastIndexMap=new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i),i);
        }


        List<Integer> res=new ArrayList<>();

        int start=0;
        int end=0;


        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);

            Integer lastIndex = lastIndexMap.get(cur);

            end=Math.max(lastIndex,end);

            if (end==i){
                res.add(end-start+1);
                start=end+1;
                end=start;
            }
        }


        return res;
    }
}
