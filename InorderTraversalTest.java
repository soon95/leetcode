import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversalTest {
	public static void main(String[] args) {
		//≤‚ ‘”√¿˝
		BinaryTree bt=new BinaryTree();
		//
		System.out.println(inorderTraversal(bt.root));
		
		
	}
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> ans=new ArrayList<Integer>();
		
		return inorder(root, ans);
	}
	public static List<Integer> inorder(TreeNode node,List<Integer> ans){
		if (node!=null) {
			inorder(node.left, ans);
			ans.add(node.val);
			inorder(node.right, ans);	
		}
		return ans;
	}
}
