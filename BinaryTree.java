
public class BinaryTree {
	TreeNode root;
	
	public BinaryTree() {//实例化一个测试用例
		this.root=new TreeNode(1);
//		
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
//		root.left.right=new TreeNode(5);
//		
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(5);
//		root.right.right=new TreeNode(7);
	}
}
