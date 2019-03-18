
public class ConvertTest {
	public static void main(String[] args) {
		//
		String s="";
		//
		int numRows=1;
		System.out.println(convert(s, numRows));
		System.out.println("输出完毕");
	}
	public static String convert(String s,int numRows) {
		int col=(numRows-1)*2;
		if (col==0) {
			return s;
		}
		int row=s.length()%col==0?s.length()/col:s.length()/col+1;
		char[][] alph=new char[row][col];
		int index=0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				alph[i][j]=s.charAt(index);
				index++;
				if (index>=s.length()) {
					break;
				}
			}
		}
		String ans="";
		for (int i = 0; i < row; i++) {
			ans+=alph[i][0];
		}
		for (int i = 1; i < numRows-1; i++) {
			for (int j = 0; j < row; j++) {
				ans+=(alph[j][i]!=0?alph[j][i]:"");
				ans+=(alph[j][2*numRows-i-2]!=0?alph[j][2*numRows-i-2]:"");
			}
		}
		for (int i = 0; i < row; i++) {
			ans+=(alph[i][numRows-1]!=0?alph[i][numRows-1]:"");
		}
		return ans;
	}
}
