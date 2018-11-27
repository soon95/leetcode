
public class IsMatchTest {
	public static void main(String[] args) {
		//
		String s= "aa";
		String p= ".*c";
		//
//		isMatch(s, p);
//		System.out.println(isSame(s, p, 2));
		System.out.println(isMatch2(s, p));
	}
	public static boolean isMatch2(String s,String p) {
		if(s == null && p == null) {
        	return true;
        }
        if(s == null || p == null ) {
        	return false;
        }
        
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m+1][n+1];

        f[0][0] = true;//s无字符，p无字符
        for (int i = 1; i <= m; i++)//s有字符，p无字符
            f[i][0] = false;
        for (int j = 1; j <= n; j++)//Ax*只有A与空串匹配，且后两个字符是x*的形式才匹配
            f[0][j] = j>1 && '*' == p.charAt(j-1) && f[0][j - 2];

        for (int i = 1; i <= m; i++)
           for (int j = 1; j <= n; j++)
                if (p.charAt(j-1) != '*') //如果不是*，只有p遍历到.或者p[j-1]和s[i-1]相等的时候匹配
                    f[i][j] = f[i - 1][j - 1] && (s.charAt(i-1) == p.charAt(j-1) || '.' == p.charAt(j-1));
                else
//                    f[i][j] = f[i][j - 2] //x*表示0个x的情况
//                    		|| (s.charAt(i-1) == p.charAt(j-2) //x*表示1个x的情况
//                    		//x*表示多个x的时候表示,此时必须s[0~i-2]与p[0～j-1]匹配且……
//                    		|| '.' == p.charAt(j-2)) && f[i - 1][j];
        
        			//标准
        			if(s.charAt(i-1) == p.charAt(j-2) || '.' == p.charAt(j-2)) {//i所指元素和8前面的元素等值，或者*前面的元素是.
        				f[i][j] = f[i][j-1]//重复一次
        							|| f[i-1][j]//重复多次
        							|| f[i][j-2];//重复多次
        			}
        			else {
        				f[i][j] = f[i][j-2];//重复0次
        			}


        return f[m][n];
	}
	public static boolean isMatch(String s,String p) {
		s+="XX";
		p+="XX";
		
		int index_s=0;
		int index_p=0;
		
		
		while(index_s<s.length()&&index_p<p.length()) {
			if (isSame(s.charAt(index_s), p.charAt(index_p))) {
				index_s++;
				index_p++;
			} else if (p.charAt(index_p)=='*'
					&&isSame(p.charAt(index_p-1), s.charAt(index_s))) {
				index_s++;
			} else if (p.charAt(index_p)=='*'
					&&!isSame(p.charAt(index_p-1), s.charAt(index_s))) {
				index_p++;
			} else if (p.charAt(index_p+1)=='*') {
				index_p+=2;
			} else {
				return false;
			}
		}
		return true;
	}
	public static boolean isSame(char ch1,char ch2) {
		if (ch1==ch2
				||ch1=='.'
				||ch2=='.') {
			return true;
		}
		return false;
	}
	
}
