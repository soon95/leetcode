
public class CandyTest {
	public static void main(String[] args) {
		//
		int[] ratings = {1,0,2};
		//
		System.out.println(candy_method1(ratings));
	}
	
	public static int candy_method1(int[] ratings) {
		int len = ratings.length;
		
		int[] candy = new int[len];
		for (int i = 0; i < len; i++) {
			candy[i] = 1;
		}
		
		int index =1;
		while(index < len) {
			if (ratings[index] > ratings[index-1] 
					&& candy[index] <= candy[index-1]) {
				candy[index] = candy[index-1]+1;
			}
			index++;
		}
		
		index = len-2;
		while(index >= 0) {
			if (ratings[index] > ratings[index+1] 
					&& candy[index] <= candy[index+1]) {
				candy[index] = candy[index+1]+1;
			}
			index--;
		}
		
		
		int sum = 0;
		for(int x:candy) {
			sum += x;
		}
		return sum;
	}
	
	public static int candy_method2(int[] ratings) {
		int len = ratings.length;
		
		int[] candy = new int[len];
//		for (int i = 0; i < len; i++) {
//			candy[i] = 1;
//		}
		
		boolean finish = true;
		
		while(finish) {
			finish = false;
			int index = 1;
			while(index < len) {
				if (ratings[index] > ratings[index-1] 
						&& candy[index] <= candy[index-1]) {
					candy[index]++;
					finish = true;
				}
				index++;
			}
			
			index = len-2;
			while(index >= 0) {
				if (ratings[index] > ratings[index+1] 
						&& candy[index] <= candy[index+1]) {
					candy[index]++;
					finish = true;
				}
				index--;
			}
		}
		
		
		int sum = len;
		for(int x:candy) {
			sum += x;
		}
		return sum;
	}
}
