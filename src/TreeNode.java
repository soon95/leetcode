
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val=x;
	}


	public void printAll() {
		String leftInfor;
		String rightInfor;

		if (left != null) {
			leftInfor = String.valueOf(left.val);
		} else {
			leftInfor = "*";
		}
		if (right != null) {
			rightInfor = String.valueOf(right.val);
		} else {
			rightInfor = "*";
		}
		System.out.println("*******");
		System.out.println("   " + val + "   ");
		System.out.println("  / \\    ");
		System.out.println(" " + leftInfor + "   " + rightInfor + " ");
		System.out.println("*******");

		if (this.left != null) {
			this.left.printAll();
		}
		if (this.right != null) {
			this.right.printAll();
		}
	}
}
