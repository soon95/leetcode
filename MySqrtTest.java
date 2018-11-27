
public class MySqrtTest {
	public static void main(String[] args) {
		//²âÊÔÓÃÀı
		int x=2147395600;
		//
		System.out.println(mySqrt(x));
		
		
	}
	public static int mySqrt(int x) {
		int i=46330;
		while(Math.pow(i, 2)<=x) {
			i++;
		}
		return --i;
	}
}
