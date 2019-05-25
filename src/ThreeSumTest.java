import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSumTest {
	public static void main(String[] args) {
		//
		int[] nums= {-1, 0, 1, 2, -1, -4};
		System.out.println(solve(nums).toString());
		//
		
	}
	public static List<List<Integer>> solve(int[] nums){
		Arrays.sort(nums);
		
		HashSet<ArrayList<Integer>> hs=new HashSet<>();
		int len=nums.length;
		int index=0;
		int start,end;
		while(index<len-2) {
			start=index+1;
			end=len-1;
			while(start<end) {
				int temp=nums[index]+nums[start]+nums[end];
				if (temp==0) {
					ArrayList<Integer> res=new ArrayList<>();
					res.add(nums[index]);
					res.add(nums[start]);
					res.add(nums[end]);
					hs.add(res);
					start++;
					end--;
				} else if (temp<0) {
					start++;
				} else {
					end--;
				}
			}
			index++;
		}
		
		List<List<Integer>> ans=new ArrayList<>();
		for(ArrayList<Integer> a:hs) {
			ans.add(a);
		}
		return ans;
	}
	
	
	public static ArrayList<ArrayList<Integer>> solve_method2(int[] nums){
		Arrays.sort(nums);
		
		HashSet<ArrayList<Integer>> hs=new HashSet<>();
		int len=nums.length;
		
		int start=0;
		int middle,end;
		while(start<len) {
			middle=start+1;
			while(middle<len) {
				if (nums[start]+nums[middle]>0) {
					break;
				}
				end=middle+1;
				while(end<len) {
					if (nums[start]+nums[middle]+nums[end]>0) {
						break;
					} else if (nums[start]+nums[middle]+nums[end]==0) {
						ArrayList<Integer> res=new ArrayList<>();
						res.add(nums[start]);
						res.add(nums[middle]);
						res.add(nums[end]);
						hs.add(res);
					}
					end++;
				}
				middle++;
			}
			start++;
		}
		
		
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		for(ArrayList<Integer> al:hs) {
			ans.add(al);
		}
		
		return ans;
	}
}
