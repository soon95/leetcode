/**
 * @author Leon Song
 * @date 2019-07-13
 */
public class NO1120_MaximumAverageSubtreeTest {
    public static double ans;

    public static void main(String[] args) {
        //
        TreeNode t1 = new TreeNode(30);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t1.printAll();
        //
        System.out.println(maximumAverageSubtree(t1));
    }

    public static double maximumAverageSubtree(TreeNode root) {
        ans = Double.MIN_VALUE;

        dfs(root);

        return ans;
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int cur = left[0] + right[0] + root.val;
        int num = left[1] + right[1] + 1;
        ans = Math.max(ans, 1.0 * cur / num);

        return new int[]{cur, num};
    }
}
