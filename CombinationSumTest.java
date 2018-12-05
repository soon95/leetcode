import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumTest {
	public static void main(String[] args) {
		//
		int[] candidates= {2,3};
		int target=6;
		//
		System.out.println(combinationSum(candidates, target).toString());
	}
	public static List<List<Integer>> combinationSum(int[] candidates,int target){
		List<List<Integer>> ans=new ArrayList<>();
		Arrays.sort(candidates);
		if (candidates.length==0||candidates[0]>target) {
			return ans;
		}
		List<Integer> temp=new ArrayList<>();//用于存放已经加入的数,直到已经加入的数和为target
		getNextCombination(candidates, ans, temp, target);
		return ans;
	}
	public static void getNextCombination(int[] candidates,List<List<Integer>> ans,List<Integer> temp,int target) {
		if (target==0) {
			ans.add(new ArrayList<>(temp));//应用传递，不能直接将引用给ans，
//			return;
		} else {
			for (int i = 0; i < candidates.length; i++) {
				temp.add(candidates[i]);
				int remain=target-candidates[i];
				if (remain<0) {
					temp.remove(temp.size()-1);
					break;
				}
				int[] newCandidates=Arrays.copyOfRange(candidates, i, candidates.length );
				getNextCombination(newCandidates, ans, temp, remain);
				temp.remove(temp.size()-1);
			}
		}
	}
}
