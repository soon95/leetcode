import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode.cn/problems/path-sum-ii/
 */
public class No113PathSumTest {


    private List<List<Integer>> ans=new ArrayList<>();


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        this.doFind(new ArrayList<>(),root,targetSum);

        return this.ans;
    }

    private void doFind(List<Integer> path,TreeNode root,int targetSum){

        if (root==null){
            return;
        }

        path.add(root.val);
        targetSum-=root.val;

        if (root.left==null&&root.right==null){

            if (targetSum==0){
                this.ans.add(path);
            }

            return;
        }

        this.doFind(new ArrayList<>(path),root.left,targetSum);
        this.doFind(new ArrayList<>(path),root.right,targetSum);
    }


    public static void main(String[] args) {


        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.left=node9;
        node6.right=node10;

        No113PathSumTest test = new No113PathSumTest();

        int targetSum=22;

        List<List<Integer>> ans = test.pathSum(node1, targetSum);

        System.out.println(ans);


    }


}
