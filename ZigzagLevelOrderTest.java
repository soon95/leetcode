import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrderTest {
	public static void main(String[] args) {
		//测试用例
		BinaryTree bt=new BinaryTree();
		//
		System.out.println(zigzagLevelOrder(bt.root));
		
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		Stack<TreeNode> stPre=new Stack<>();//创建一个栈
		Stack<TreeNode> stCur=new Stack<>();//创建一个栈
		int count=1;//用来区分奇偶
		if (root==null) {
			return ans;
		}
		stCur.push(root);
		while(!stCur.empty()) {
			List<Integer> subans=new ArrayList<>();
			Stack<TreeNode> temp = new Stack<>();
			
			while(!stCur.empty()) {
				temp.push(stCur.pop());
			}
			while(!temp.empty()) {
				stPre.push(temp.pop());
			}
			while(!stPre.empty()) {//读入列表
				//将下一层压入栈中，分奇偶
				if (count%2==1) {//奇数时
					if (stPre.peek().left!=null) {
						stCur.push(stPre.peek().left);
					}
					if (stPre.peek().right!=null) {
						stCur.push(stPre.peek().right);
					}
				} else {//偶数时
					if (stPre.peek().right!=null) {
						stCur.push(stPre.peek().right);
					}
					if (stPre.peek().left!=null) {
						stCur.push(stPre.peek().left);
					}
				}
				subans.add(stPre.pop().val);
			}
			count++;
			ans.add(subans);
		}
		return ans;
	}
	
}
