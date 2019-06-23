/**
 * @auther Leon Song
 * @date 2019-06-23 18:05
 */
public class NO98_IsValidBSTTest {

    public static void main(String[] args) {
        //
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(20);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        t1.printAll();
        //
        System.out.println(isValidBST(t1));

    }

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }

        if (root.val > left && root.val < right) {

            return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);

        } else {

            return false;

        }

    }

}
