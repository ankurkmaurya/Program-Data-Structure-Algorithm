package com.ankurmaurya.binarysearch.position;

import com.ankurmaurya.binarysearch.utility.Utilities;


/*
 * Single Element in a Sorted Array
 * 
 * Type : Medium
 * 
 * You are given a sorted array consisting of only integers where every element 
 * appears exactly twice, except for one element which appears exactly once.
 * Return the single element that appears only once.
 * 
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * 
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * 
 * Constraints:
 * 1 <= nums.length <= 10 power 5
 * 0 <= nums[i] <= 10 power 5
 * 
 * 
 * 
 * Solution:
 * Time Complexity  : O(log n)
 * Space Complexity : O(1)
 * 
 * 
 */



public class SingleElementInSortedArray {

	public static void main(String[] args) {
		
		int[] num1 = {3,3,7,7,11,11};
		Utilities.printElements(num1);
		int nonDupNo1 = singleNonDuplicate(num1);
		System.out.println("Non Duplicate Number is '" + nonDupNo1 + "'");
		System.out.println();
		
		int[] num2 = {1,1,2,3,3,4,4,8,8};
		Utilities.printElements(num2);
		int nonDupNo2 = singleNonDuplicate(num2);
		System.out.println("Non Duplicate Number is '" + nonDupNo2 + "'");
		System.out.println();
		
		int[] num3 = {3,3,7,7,10,11,11};
		Utilities.printElements(num3);
		int nonDupNo3 = singleNonDuplicate(num3);
		System.out.println("Non Duplicate Number is '" + nonDupNo3 + "'");
		System.out.println();
		
		int[] num4 = {1,3,3,7,7,11,11};
		Utilities.printElements(num4);
		int nonDupNo4 = singleNonDuplicate(num4);
		System.out.println("Non Duplicate Number is '" + nonDupNo4 + "'");
		System.out.println();
		
		int[] num5 = {1,1,3,3,7,7,11,11,12};
		Utilities.printElements(num5);
		int nonDupNo5 = singleNonDuplicate(num5);
		System.out.println("Non Duplicate Number is '" + nonDupNo5 + "'");
		System.out.println();
		
		int[] num6 = {1,1,3,4,4};
		Utilities.printElements(num6);
		int nonDupNo6 = singleNonDuplicate(num6);
		System.out.println("Non Duplicate Number is '" + nonDupNo6 + "'");
		System.out.println();
		
	}
	
	
    public static int singleNonDuplicate(int[] nums) {
        int nonDuplicateNumber = -1;
        
        //If all the elements were duplicate then the length of the array will be even number
        if(nums.length%2 == 0) {
        	return nonDuplicateNumber;
        }
        
        int low = 0;
        int high = nums.length-1;
        int noDupIndex = 0;
        while(low<high) {
        	int mid = low + (high - low)/2;
        	
        	if(mid == 0) {
        		//We have reached the start there will be no left elements to calculate MOD count
        		low = mid+1;
        	}
        	else if(mid == nums.length-1) {
        		//We have reached the end there will be no right elements to calculate MOD count
        		high = mid-1;
        	} 
        	else {
        		//If the previous element is same we will include the current mid position also
        		if(nums[mid-1]==nums[mid]) {
        			if((mid+1)%2 == 0) {
        				//Our non duplicate element will be on right side
        				noDupIndex = mid + 1;
        				low = mid + 1;
        			} else {
        				//Our non duplicate element will be on left side
        				//noDupIndex = mid - 2;
        				//high = mid - 2;
        				noDupIndex = mid;
        				high = mid;
        			}
        		} 
        		else {
        		//If the previous element is not same we will include the previous element of mid position
        			if((mid)%2 == 0) {
        				//Our non duplicate element will be on right side
        				noDupIndex = mid+1;
        				low = mid +1;
        			} else {
        				//Our non duplicate element will be on left side
        				noDupIndex = mid-1;
        				high = mid-1;
        			}
        		}
        	}
        }
        
        nonDuplicateNumber = nums[noDupIndex];
        return nonDuplicateNumber;
    }
	
	
}



