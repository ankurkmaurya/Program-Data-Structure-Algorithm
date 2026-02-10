package com.ankurmaurya.binarysearch.duplicate;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * 
 * Find the Duplicate Number
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and using only constant extra space.
 * 
 * 
 * Example 1:
 * Input: nums = [1,3,4,2,2] 
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * Example 3:
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 * 
 * 
 * Solution:
 *  It will take O(nlogn) to complete the task as we are iterating n times every time 
 *  and reducing the calculation space based the mismatch count of middle element 
 *  resulting binary search's logn complexity.
 * 
 */



public class FindOnlySingleElementDuplicateWithNPlusOneElements {

	
	public static void main(String[] args) {
		int[] num1 = {1,3,4,2,2};
		int[] num2 = {3,1,3,4,2};
		int[] num3 = {3,3,3,3,3};
		int[] num4 = {1,2,3,4,5,6,7,7,8,9};
		
		Utilities.printElements(num1);
		int num1DupElem = findDuplicate(num1);
		System.out.println("The Duplicate element in the above list is'" + num1DupElem + "'");
		
		Utilities.printElements(num2);
		int num2DupElem = findDuplicate(num2);
		System.out.println("The Duplicate element in the above list is'" + num2DupElem + "'");
		
		Utilities.printElements(num3);
		int num3DupElem = findDuplicate(num3);
		System.out.println("The Duplicate element in the above list is'" + num3DupElem + "'");
		
		Utilities.printElements(num4);
		int num4DupElem = findDuplicate(num4);
		System.out.println("The Duplicate element in the above list is'" + num4DupElem + "'");
		
	}
	
	
	public static int findDuplicate(int[] nums) {
	    int duplicateElement = -1;    
		
	    int l = 1;
	    int h = nums.length-1;
	    while(l<=h) {
	    	int m = l + (h-l)/2;
	    	
	    	int count = 0;
	    	for(int i=0; i< nums.length; i++) {
	    		if(nums[i]<=m) {
	    			count++;
	    		}
	    	}
	    	
	    	if(count > m) {
	    		duplicateElement = m;
	    		h = m - 1;
	    	} 
	    	else {
	    		l = m + 1;
	    	}
	    	
	    }
	    
		return duplicateElement;
	}
	
	
	
}

