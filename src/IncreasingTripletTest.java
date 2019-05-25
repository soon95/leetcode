
public class IncreasingTripletTest {
	public static void main(String[] args) {
		//²âÊÔÊı¾İ
		int[] nums= {5,1,5,5,2,5,4};
		//
		System.out.println(IncreasingTriplet(nums));
	}
	public static boolean IncreasingTriplet(int[] nums) {
		if (nums.length<3) {
			return false;
		}
		int first=Integer.MAX_VALUE;
		int second=Integer.MAX_VALUE;
		for(int num:nums) {
			if (first>num) {
				first=num;
			} else if (first<num&&second>num) {
				second=num;
			} else if (second<num) {
				return true;
			}
		}
		return false;
	}
	
}
