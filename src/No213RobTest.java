public class No213RobTest {

    public int rob(int[] nums) {

        int length = nums.length;



        if (length==1){
            return nums[0];
        }

        if (length==2){
            return Math.max(nums[0],nums[1]);
        }

        int[] dpWithoutHead=new int[length];
        int[] dpWithoutTail=new int[length];


        dpWithoutHead[0]=0;
        dpWithoutHead[1]=nums[1];
        dpWithoutTail[0]=nums[0];
        dpWithoutTail[1]=Math.max(nums[0], nums[1]);


        for (int i = 2; i < length; i++) {

            dpWithoutHead[i]=Math.max(dpWithoutHead[i-1],dpWithoutHead[i-2]+nums[i]);
        }

        for (int i = 2; i < length - 1; i++) {
            dpWithoutTail[i]=Math.max(dpWithoutTail[i-1],dpWithoutTail[i-2]+nums[i]);
        }

        return Math.max(dpWithoutHead[length-1], dpWithoutTail[length-2]);
    }

    public static void main(String[] args) {


//        int[] nums =new int[]{2,3,2};
//        int[] nums =new int[]{1,2,3,1};
        int[] nums =new int[]{4,1,2,7,5,3,1};

        No213RobTest test = new No213RobTest();

        System.out.println(test.rob(nums));


    }


}
