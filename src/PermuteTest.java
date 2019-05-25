import java.util.ArrayList;
import java.util.List;

public class PermuteTest {
	public static void main(String[] args) {
		//
		int[] nums= {1,2};
		//
		System.out.println(permute(nums).toString());
		
	}
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> ans=new ArrayList<>();
		
		if (nums.length<1) {
			return ans;
		}
		List<Integer> temp=new ArrayList<>();
		temp.add(nums[0]);
		ans.add(temp);
		
		for (int i = 1; i < nums.length; i++) {
			ans=nextPermute(ans, nums[i]);
		}
		
		
		
		
		return ans;
	}
	public static List<List<Integer>> nextPermute(List<List<Integer>> pre,int num){
		List<List<Integer>> cur=new ArrayList<>();
		int length=pre.get(0).size();
		
		for (int i = 0; i < pre.size(); i++) {
			for (int j = 0; j < length+1; j++) {
				List<Integer> temp=new ArrayList<>(pre.get(i));
				temp.add(j,num);
				cur.add(temp);
			}
			
		}
		
		
		
		return cur;
	}
	
	
}
