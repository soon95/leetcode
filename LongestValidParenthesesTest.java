import java.util.Stack;

public class LongestValidParenthesesTest {
	public static void main(String[] args) {
		//
		String s="()()(()";//"))))())()()(()",")(",")(((((()())()()))()(()))("
		        //0123456789
		//
		System.out.println(longestValidParantheses(s));
		
	}
	public static int longestValidParantheses(String s) {
		int ans=0;
		Stack<Integer> st=new Stack<>();
		int len=s.length();
		int index=0;
		int beg=0;
		while(index<len) {
			char temp=s.charAt(index);
			if (temp=='(') {	//如果是左括号，就压入栈中
				st.push(index);
			} else {	//如果是右括号
				if (st.size()==0) {	//如果栈为空，则更新计数起始位置
					beg=index+1;
				} else {	//如果栈不为空，即有左括号
					st.pop();
					if (st.size()==0) {	//如果此时栈为空
						ans=ans>index-beg+1?ans:index-beg+1;
					} else {	//不为空
						ans=ans>index-st.peek()?ans:index-st.peek();
					}
				}
			}
			index++;
		}
		return ans;
	}
	
}
