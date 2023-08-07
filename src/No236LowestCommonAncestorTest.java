/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=featured-list&envId=2cktkvj
 */
public class No236LowestCommonAncestorTest {


    private TreeNode ans;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        doFind(root,p,q);

        return ans;
    }

    private boolean doFind(TreeNode root, TreeNode p, TreeNode q){

        if (root==null){
            return false;
        }


        boolean leftAns = doFind(root.left, p, q);
        boolean rightAns = doFind(root.right, p, q);

        if (leftAns&&rightAns){
            ans=root;
        } else if ((root==p||root==q)&&(leftAns||rightAns)){
            ans=root;
        }


        return leftAns||rightAns||root==p||root==q;
    }

    public static void main(String[] args) {


        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node5.left=node8;
        node5.right=node9;


        No236LowestCommonAncestorTest test = new No236LowestCommonAncestorTest();
        TreeNode ans = test.lowestCommonAncestor(node1, node2, node9);

        System.out.println(ans);


    }


}
