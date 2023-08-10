import java.util.Arrays;
import java.util.Stack;

public class No739DailyTemperaturesTest {

    public int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;

        int[] ans=new int[length];


        Stack<Integer> stack=new Stack<>();

        stack.push(0);

        int index=1;

        while (index<length){

            while (!stack.isEmpty()){

                Integer peek = stack.peek();

                if (temperatures[peek]<temperatures[index]){

                    Integer pop = stack.pop();

                    ans[pop]=index-pop;
                } else {
                    break;
                }
            }

            stack.push(index);


            index++;
        }


        return ans;
    }

    public static void main(String[] args) {


        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};

        No739DailyTemperaturesTest test = new No739DailyTemperaturesTest();

        System.out.println(Arrays.toString(test.dailyTemperatures(temperatures)));

    }
}
