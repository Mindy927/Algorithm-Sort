import java.util.*;
public class MergeSort{
	static int[] copy; //record orginal values before merge
	public static void main(String[] args){
		int[] nums1 = new int[]{0,-1,4,5,2,-1};
		int[] nums2 = new int[]{0,3,-1,2,3};

		copy = new int[nums1.length];
		mergesort(nums1, 0, nums1.length-1);
		System.out.println(Arrays.toString(nums1)); //[-1, -1, 0, 2, 4, 5]

		copy = new int[nums2.length];
		mergesort(nums2, 0, nums2.length-1);
		System.out.println(Arrays.toString(nums2)); //[-1, 0, 2, 3, 3]

	}

	public static void mergesort(int[] nums, int left, int right){
		if (left >= right) return;

		int mid = (left + right)/2;
		mergesort(nums, left, mid);
		mergesort(nums, mid+1, right);
		merge(nums, left, mid, right);
	}

	//copy orginal values to copy, two pointers to merge and add result to nums
	public static void merge(int[] nums, int left, int mid, int right){
		//copy previous values to copy before merging
		for(int i=left; i<=right; i++) copy[i] = nums[i];

		int p1 = left, p2 = mid+1;
		int index = left;
		while (p1 <= mid || p2 <= right){
			if ( p1 > mid || (p2 <= right && copy[p1] > copy[p2])){ //compare orginal value stored in copy
				nums[index++] = copy[p2++];
			} else {
				nums[index++] = copy[p1++];
			}
		}
	}
}