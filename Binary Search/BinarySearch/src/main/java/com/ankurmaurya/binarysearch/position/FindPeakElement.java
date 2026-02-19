package com.ankurmaurya.binarysearch.position;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * Find Peak Element
 * 
 * Type : Medium
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. 
 * If the array contains multiple peaks, return the index to any of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. 
 * In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, 
 *              or index number 5 where the peak element is 6.
 *              
 *              
 * Constraints:
 * 1 <= nums.length <= 1000
 * -2power31 <= nums[i] <= 2power31 - 1
 * nums[i] != nums[i + 1] for all valid i.
 * 
 * 
 * 
 */

public class FindPeakElement {

	public static void main(String[] args) {
		int[] num1 = {};
		int[] num2 = {3};
		int[] num3 = {1,2,3,1};
		int[] num4 = {1,2,1,3,5,6,4};
		int[] num5 = {1,2,1,3,5,6,7};
		int[] num6 = {7,6,5,4,0,1,2,3,4,3,2,1};
		int[] num7 = {7,6,5,4,0};
		int[] num8 = {0,1,2,4,6,7,8};
		int[] num9 = {3,2,1};
		int[] num10 = {1,2};
		int[] num11 = {2,1};


		Utilities.printElements(num1);
		int peakIndex1 = findPeakElement(num1);
		System.out.println("Peak Index is '" + peakIndex1 + "'");
		System.out.println();
		
		Utilities.printElements(num2);
		int peakIndex2 = findPeakElement(num2);
		System.out.println("Peak Index is '" + peakIndex2 + "'");
		System.out.println();
		
		Utilities.printElements(num3);
		int peakIndex3 = findPeakElement(num3);
		System.out.println("Peak Index is '" + peakIndex3 + "'");
		System.out.println();
		
		Utilities.printElements(num4);
		int peakIndex4 = findPeakElement(num4);
		System.out.println("Peak Index is '" + peakIndex4 + "'");
		System.out.println();
		
		Utilities.printElements(num5);
		int peakIndex5 = findPeakElement(num5);
		System.out.println("Peak Index is '" + peakIndex5 + "'");
		System.out.println();
		
		Utilities.printElements(num6);
		int peakIndex6 = findPeakElement(num6);
		System.out.println("Peak Index is '" + peakIndex6 + "'");
		System.out.println();
		
		Utilities.printElements(num7);
		int peakIndex7 = findPeakElement(num7);
		System.out.println("Peak Index is '" + peakIndex7 + "'");
		System.out.println();
		
		Utilities.printElements(num8);
		int peakIndex8 = findPeakElement(num8);
		System.out.println("Peak Index is '" + peakIndex8 + "'");
		System.out.println();
		
		Utilities.printElements(num9);
		int peakIndex9 = findPeakElement(num9);
		System.out.println("Peak Index is '" + peakIndex9 + "'");
		System.out.println();
		
		Utilities.printElements(num10);
		int peakIndex10 = findPeakElement(num10);
		System.out.println("Peak Index is '" + peakIndex10 + "'");
		System.out.println();
		
		Utilities.printElements(num11);
		int peakIndex11 = findPeakElement(num11);
		System.out.println("Peak Index is '" + peakIndex11 + "'");
		System.out.println();
		
	}
	
	
    public static int findPeakElement(int[] nums) {
        if(nums.length == 0) {
        	return -1;
        }
        if(nums.length == 1) {
        	return 0;
        }
        
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
        	int mid = low + (high - low)/2;
        	
        	if(mid-1 == -1 && nums[mid] < nums[mid+1]) {
        		return mid+1;
        	} 
        	if(mid-1 == -1 && nums[mid] > nums[mid+1]) {
        		return mid;
        	}
        	if(mid+1 == nums.length && nums[mid] < nums[mid-1]) {
        		return mid-1;
        	}
        	if(mid+1 == nums.length && nums[mid] > nums[mid-1]) {
        		return mid;
        	}
        	
        	
        	if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
        		return mid;
        	}
        	else if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
        		low = mid+1;
        	} 
        	else {
        		high = mid-1;
        	}
        }
        return -1;
    }
	

}



