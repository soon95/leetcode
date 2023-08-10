/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=featured-list&envId=2cktkvj
 */
public class No543DiameterOfBinaryTreeTest {


    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return ans;
    }


    private int dfs(TreeNode root){

        if (root==null){
            return 0;
        }


        int left = this.dfs(root.left);
        int right = this.dfs(root.right);

        int temp=left+right;

        this.ans=Math.max(this.ans,temp);


        return 1+Math.max(left,right);
    }




    public static void main(String[] args) {





    }
}
