/**
 * 572. 另一棵树的子树
 * https://leetcode.cn/problems/subtree-of-another-tree/description/
 */
public class No572IsSubTreeTest {


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        boolean same = isSame(root, subRoot);

        if (same){
            return true;
        }

        if (root==null&&subRoot!=null){
            return false;
        }


        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode tree1,TreeNode tree2){

        if (tree1==null&&tree2==null){
            return true;
        }

        if (tree1==null||tree2==null){
            return false;
        }

        if (tree1.val==tree2.val){
            return isSame(tree1.left,tree2.left)&&isSame(tree1.right,tree2.right);
        } else {
            return false;
        }
    }



    public static void main(String[] args) {


        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(1);
        TreeNode node5=new TreeNode(2);
        TreeNode node6=new TreeNode(0);


        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node5.left=node6;


        TreeNode subNode1=new TreeNode(4);
        TreeNode subNode2=new TreeNode(1);
        TreeNode subNode3=new TreeNode(2);

        subNode1.left=subNode2;
        subNode1.right=subNode3;


        No572IsSubTreeTest test = new No572IsSubTreeTest();

        System.out.println(test.isSubtree(node1, subNode1));

    }


}
