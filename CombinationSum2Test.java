import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2Test {
	public static void main(String[] args) {
		//
		int[] candidates= {10,1,2,7,6,1,5};
		int target=7;
		//
		System.out.println(combinationSum2(candidates, target).toString());
		
	}
	public static List<List<Integer>> combinationSum2(int[] candidates,int target){
		List<List<Integer>> com=new ArrayList<>();
		Arrays.sort(candidates);
		if (candidates.length==0||candidates[0]>target) {
			return com;
		}
		List<Integer> preCom=new ArrayList<>();
		combination(com, preCom, candidates, target);
		return com;
	}
	public static void combination(List<List<Integer>> com,List<Integer> preCom,int[] candidates,int target) {
		if (target==0) {
			if (!isExist(com, preCom)) {
				com.add(new ArrayList<>(preCom));
			}
//			com.add(new ArrayList<>(preCom));
		} else {
			for (int i = 0; i < candidates.length; i++) {
				int num=candidates[i];
				preCom.add(num);
				int newTarget=target-num;
				if (target<0) {
					preCom.remove(preCom.size()-1);
					break;
				}
//				while (i<candidates.length-1&&candidates[i]==candidates[i+1]) {
//					i++;
//				}
				int[] newCandidates=Arrays.copyOfRange(candidates, i+1, candidates.length);
				combination(com, preCom, newCandidates, newTarget);
				preCom.remove(preCom.size()-1);
			}
		}	
	}
	public static boolean isExist(List<List<Integer>> com,List<Integer> preCom) {
		for (int i = 0; i < com.size(); i++) {
			if (com.get(i).size()==preCom.size()&&isSame(com.get(i), preCom)) {
				return true;
			}
		}
		return false;
	}
	public static boolean isSame(List<Integer> arr1,List<Integer> arr2) {
		int length=arr1.size();
		for (int i = 0; i < length; i++) {
			if (arr1.get(i)!=arr2.get(i)) {
				return false;
			}
		}
		return true;
	}
}
