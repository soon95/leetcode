import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Song
 * @date 2019-07-22
 */
public class NO95_GenerateTreesTest {
    public static void main(String[] args) {
        //
        int n = 0;
        //
        List<TreeNode> ans = generateTrees(n);

        for (TreeNode t : ans) {
            t.printAll();
            System.out.println("================");
        }

        System.out.println(ans.size());
    }

    public static List<TreeNode> generateTrees(int n) {
        List<Integer> nums = new ArrayList<>();
        if (n == 0) {
            return new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        return dfs(nums);
    }

    private static List<TreeNode> dfs(List<Integer> nums) {
        List<TreeNode> ans = new ArrayList<>();
        if (nums.size() == 0) {
            ans.add(null);
            return ans;
        }

        for (int i = 0; i < nums.size(); i++) {

            List<TreeNode> left = dfs(nums.subList(0, i));
            List<TreeNode> right = dfs(nums.subList(i + 1, nums.size()));

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(nums.get(i));

                    treeNode.left = l;
                    treeNode.right = r;

                    ans.add(treeNode);
                }
            }
        }
        return ans;
    }

}
