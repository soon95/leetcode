
public class IsMatch2Test {
	public static void main(String[] args) {
		//
		String s="acdcb";
		String p="a*c?b";
		//
		System.out.println(isMatch(s, p));
	}
	public static boolean isMatch(String s,String p) {
		String pp="";
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i)=='*') {
				pp=pp+p.charAt(i)+"";
				while(i<p.length()&&p.charAt(i)=='*') {
					i++;
				}
			} 
			if (i<p.length()) {
				pp=pp+p.charAt(i)+"";
			}
		}
		p=pp;
		
		int lenS=s.length();
		int lenP=p.length();
		
		boolean[][] res=new boolean[lenS+1][lenP+1];
		res[0][0]=true;
		if (p.length()>0&&p.charAt(0)=='*') {
			res[0][1]=true;
		}
		for (int i = 1; i <= lenS; i++) {
			for (int j = 1; j <= lenP; j++) {
				if (p.charAt(j-1)=='*') {
					res[i][j]=res[i-1][j]||res[i][j-1]||res[i-1][j-1];
				} else {
					res[i][j]=res[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?');
				}
			}
		}
		return res[lenS][lenP];
	}
	
}
