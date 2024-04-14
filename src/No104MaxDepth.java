public class No104MaxDepth {

    public static void main(String[] args) {

        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;


        No104MaxDepth test = new No104MaxDepth();

        System.out.println(test.maxDepth(node1));

    }



    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node){
        if (node==null){
            return 0;
        }

        return Math.max(dfs(node.left),dfs(node.right))+1;
    }

}
