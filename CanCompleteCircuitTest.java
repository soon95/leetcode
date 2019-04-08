
public class CanCompleteCircuitTest {
	public static void main(String[] args) {
		//
		int[] gas= {2,3,4};
		int[] cost= {3,4,3};
		//
		System.out.println(canCompleteCircuit(gas, cost));
//		System.out.println(canComplete(gas, cost, 4));
	}
	public static int canCompleteCircuit(int[] gas,int[] cost) {
		for (int i = 0; i < cost.length; i++) {
			if (canComplete(gas, cost, i)) {
				return i;
			}
		}
		return -1;
	}
	private static boolean canComplete(int[] gas,int[] cost,int begin) {
		int len=gas.length;
		
		int curGas=0;
		int count=0;
		
		while(count<=len) {
			curGas+=gas[(begin+count)%len];
			
			if (curGas<cost[(begin+count)%len]) {
				return false;
			} else {
				curGas-=cost[(begin+count)%len];
			}
			
			
			
			count++;
		}
		
		return true;
	}
}
