
public class FindMedianSortedArraysaTest {
	public static void main(String[] args) {
		//
		int[] nums1= {};
		int[] nums2= {3,4,5};
		//
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	
	public static double findMedianSortedArrays(int[] nums1,int[] nums2) {
		double ans=0;
		
		int length=nums1.length+nums2.length;
		int f1=0;
		int f2=0;
		int count=0;
		int temp=0;
		int another=0;
		while(count<=length/2&&f1<nums1.length&&f2<nums2.length) {
			if (nums1[f1]<nums2[f2]) {
				another=temp;
				temp=nums1[f1];
				f1++;
				count++;
			} else {
				another=temp;
				temp=nums2[f2];
				f2++;
				count++;
			}
		}
		if (f1==nums1.length) {
			while(count<=length/2) {
				another=temp;
				temp=nums2[f2];
				f2++;
				count++;
			}
		} else if (f2==nums2.length) {
			while(count<=length/2) {
				another=temp;
				temp=nums1[f1];
				f1++;
				count++;
			}
		}
		if (length%2==0) {
			ans=(temp+another)*1.0/2;
		} else {
			ans=temp;
		}
		return ans;
	}
}
