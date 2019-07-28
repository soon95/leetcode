package pinduoduo_7_28;

import java.util.Arrays;

/**
 * @author Leon Song
 * @date 2019-07-28
 */
public class Test1 {
    public static void main(String[] args) {
        //
//        Scanner input=new Scanner(System.in);
//
//        String str1=input.nextLine();
//        String str2=input.nextLine();
//
//        String[] list1=str1.split(" ");
//        String[] list2=str2.split(" ");
//
//        int[] arr1=new int[list1.length];
//        int[] arr2=new int[list2.length];
//
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i]= Integer.valueOf(list1[i]);
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            arr2[i]=Integer.valueOf(list2[i]);
//        }
//
//        solve(arr1, arr2);

        //
        int[] arr1 = {5, 6};
        int[] arr2 = {2, 3};

        solve(arr1, arr2);
    }


    public static void solve(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        int[] list = new int[arr1.length + 2];
        list[0] = Integer.MIN_VALUE;
        for (int i = 1; i < list.length - 1; i++) {
            list[i] = arr1[i - 1];
        }
        list[list.length - 1] = Integer.MAX_VALUE;

        for (int i = arr1.length; i >= 1; i--) {
            if (!(list[i] > list[i - 1] && list[i] < list[i + 1])) {

                int index = arr2.length - 1;

                while (index >= 0 && arr2[index] > list[i + 1]) {
                    index--;
                }
                if (index < 0 || arr2[index] <= list[i - 1]) {
                    continue;
                }

                arr1[i - 1] = arr2[index];

                StringBuffer sb = new StringBuffer();

                for (int x : arr1) {
                    sb.append(x);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb.toString());
                return;
            }
        }
        System.out.println("NO");
    }
}
