
public class TrailingZerosTest {
	public static void main(String[] args) {
		//
		int n=1808548329;//1808548329
		//
//		System.out.println(zeroNum(10000));
//		System.out.println(factorial(n));
		System.out.println(trailingZeros(n));
		
	}
	public static int trailingZeros(int n) {
		return zeros(n);
	}
	public static int zeros(int n) {
		if (n<5) {
			return 0;
		} else {
			return n/5+zeros(n/5);
		}
	}
	
}
