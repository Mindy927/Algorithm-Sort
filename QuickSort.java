/*
1. select pivot at the end
2. move all numbers < pivot before pivot

Author: Mindy927
*/

import java.util.*;
public class QuickSort{
	public static void main(String[] args){
		int[] nums1 = new int[]{0,-1,4,5,2,-1};
		int[] nums2 = new int[]{0,3,-1,2,3};

		quickSort(nums1, 0, nums1.length-1);
		System.out.println(Arrays.toString(nums1)); //[-1, -1, 0, 2, 4, 5]

		quickSort(nums2, 0, nums2.length-1);
		System.out.println(Arrays.toString(nums2)); //[-1, 0, 2, 3, 3]

	}

    //quick sort, return index of pivot, 0 to index-1 are numbers < pivot
    public static void quickSort(int[] nums, int left, int right){
    	if (left < right){
    		int k = partition(nums, left, right);
    		quickSort(nums, left, k-1);
    		quickSort(nums, k+1, right);
    	}
    }
    
    //choose a pivot, move all numbers < pivot before it, and return index of pivot
    public static int partition(int[] nums, int left, int right){
    	int pivot = nums[right];
    	int i = left; //candidate position for next num < pivot
  		for (int j=left; j<right; j++){
  			if (nums[j] < pivot) swap(nums, i++, j); //found elment < pivot, move to i
  		}
    	swap(nums, i, right); //swap pivot to correct position
    	return i;
    }	

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
  }