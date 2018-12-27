import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class PermuteUniqueTest {
	public static void main(String[] args) {
		//
		int[] nums= {1,1,2,2};
		//
		System.out.println(permuteUnique(nums).toString());
		
	}
	public static List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> ans=new ArrayList<>();
		List<List<Integer>> cur=new ArrayList<>();
		if (nums.length<1) {
			return cur;
		}
		List<Integer> temp=new ArrayList<>();
		temp.add(nums[0]);
		cur.add(temp);
		
		for (int i = 1; i < nums.length; i++) {
			cur=nextPermute(cur, nums[i]);
		}
		ListIterator<List<Integer>> iter=cur.listIterator();
		while(iter.hasNext()) {
			temp=iter.next();
			if (!ans.contains(temp)) {
				ans.add(temp);
			}
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
