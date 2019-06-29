import java.util.Arrays;

/**
 * @auther Leon Song
 * @date 2019-06-29 16:43
 */
public class NO105_BuildTreeTest {

    public static void main(String[] args) {
        //
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        //
        TreeNode root = buildTree(preorder, inorder);
        root.printAll();
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        int value = preorder[0];

        int index = 0;
        while (index < len && inorder[index] != value) {
            index++;
        }


        TreeNode root = new TreeNode(value);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1)
                , Arrays.copyOfRange(inorder, 0, index));

        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, len)
                , Arrays.copyOfRange(inorder, index + 1, len));

        return root;
    }
}
