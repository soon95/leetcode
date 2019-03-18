import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumTest {
	public static void main(String[] args) {
		//
//		int[] nums= {1, 0, -1, 0, -2, 2};
//		int[] nums={-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
		int[] nums= {0,0,0,0};
		int target=0;
		//
		System.out.println(fourSum(nums, target));
	}
	public static List<List<Integer>> fourSum(int[] nums,int target){
		List<List<Integer>> ans=new ArrayList<>();
		
		int length=nums.length;
		Arrays.sort(nums);
		
		int i=0;
		int j=1;
		int k=2;
		int l=length-1;
		
		int temp1=Integer.MAX_VALUE;
		int temp2=Integer.MAX_VALUE;
		int temp3=Integer.MAX_VALUE;
		int temp4=Integer.MAX_VALUE;
		
		while(i<length-3) {
			j=i+1;
			while(j<length-2) {
				int count=0;
				k=j+1;
				l=length-1;
				while(k<l) {
					if ((nums[i]+nums[j]+nums[k]+nums[l]==target)
							&&!(temp1==nums[i]&&temp2==nums[j]&&temp3==nums[k]&&temp4==nums[l])) {
						temp1=nums[i];
						temp2=nums[j];
						temp3=nums[k];
						temp4=nums[l];
						List<Integer> arr=new ArrayList<>();
						arr.add(temp1);
						arr.add(temp2);
						arr.add(temp3);
						arr.add(temp4);
						ans.add(arr);
						
						if (count%2==0) {
							k++;
						} else {
							l--;
						}
						count++;
					} else if (nums[i]+nums[j]+nums[k]+nums[l]<target) {
						k++;
					} else {
						l--;
					}
				}
				j++;
				while(j<length-2&&nums[j]==nums[j-1]) {
					j++;
				}
			}
			i++;
			while(i<length-3&&nums[i]==nums[i-1]) {
				i++;
			}
		}
		
		return ans;
	}
}
