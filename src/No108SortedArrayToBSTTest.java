/**
 * @author Leon Song
 * @date 4/20/24
 */
public class No108SortedArrayToBSTTest {


    public static void main(String[] args) {

        int[] nums = new int[]{-10, -3, 0, 5, 9};


        No108SortedArrayToBSTTest test = new No108SortedArrayToBSTTest();

        TreeNode root = test.sortedArrayToBST(nums);

        System.out.println(root);


    }


    public TreeNode sortedArrayToBST(int[] nums) {

        return transferArray(nums, 0, nums.length - 1);
    }

    private TreeNode transferArray(int[] nums, int start, int end) {

        if (end < start) {
            return null;
        }


        int middle = (start + end) / 2;


        TreeNode cur = new TreeNode(nums[middle]);

        cur.left = transferArray(nums, start, middle - 1);
        cur.right = transferArray(nums, middle + 1, end);


        return cur;
    }

}
