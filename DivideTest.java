
public class DivideTest {
	public static void main(String[] args) {
		//
		int dividend=10;
		int divisor=2;
		//
		System.out.println(divide(dividend, divisor));
		
	}
	public static int divide(int dividend,int divisor) {
		if(dividend==-2147483648 && divisor==-1) {
			return 2147483647;			
		}
		boolean flag=false;
		if (dividend>0^divisor>0) {
			flag=true;
		}
		long dvd=Math.abs((long)dividend);
		long dvs=Math.abs((long)divisor);
		long ans=0;
		
		while(dvd>=dvs) {
			long temp=dvs;
			long divide=1;
			while(dvd>=(temp<<1)) {
				temp<<=1;
				divide<<=1;
			}
			dvd-=temp;
			ans+=divide;
		}
		
		return (int) (flag?-ans:ans);
		
	}
}
