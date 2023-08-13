import sun.reflect.generics.tree.Tree;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=featured-list&envId=2cktkvj
 */
public class No114FlattenTest {

    public void flatten(TreeNode root) {

        this.doFlatten(root);
    }

    private SingleList doFlatten(TreeNode root){

        if (root==null){
            return null;
        }

        TreeNode head=root;
        TreeNode tail=root;


        SingleList leftList = this.doFlatten(root.left);
        SingleList rightList = this.doFlatten(root.right);

        root.left=null;

        if (leftList!=null){

            head.right=leftList.head;
            tail=leftList.tail;
        }

        if (rightList!=null){

            tail.right=rightList.head;

            tail=rightList.tail;
        }


        SingleList singleList = new SingleList();
        singleList.head=head;
        singleList.tail=tail;

        return singleList;
    }



    public static class SingleList{

        private TreeNode head;

        private TreeNode tail;

    }


    public static void main(String[] args) {

        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);


        node1.left=node2;
        node2.left=node3;
        node2.right=node4;
        node1.right=node5;
        node5.right=node6;

        No114FlattenTest test = new No114FlattenTest();

        test.flatten(node1);

        System.out.println(node1);


    }





}
