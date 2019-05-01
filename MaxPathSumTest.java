
public class MaxPathSumTest {
	public static void main(String[] args) {
		//
		TreeNode t1 = new TreeNode(-10);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		
		//
		System.out.println(maxPathSum(t1));
		
	}
	public static int max = Integer.MIN_VALUE;
	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		path(root);
		return max;
	}
	public static int path(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int left = Math.max(path(node.left), 0);
		int right = Math.max(path(node.right), 0);
		
		max = Math.max(max, left+right+node.val);
		
		return Math.max(left+node.val, right+node.val);
	}
	
}
