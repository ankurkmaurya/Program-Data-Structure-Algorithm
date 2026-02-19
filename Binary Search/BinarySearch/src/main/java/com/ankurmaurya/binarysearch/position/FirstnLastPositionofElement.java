package com.ankurmaurya.binarysearch.position;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * 
 * Find First and Last Position of Element in Sorted Array
 * 
 * 
 * Given an array of integers nums sorted in non-decreasing order, 
 * find the starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 * 
 * 
 * Optimized:
 * Time Complexity  : O(logn)
 * Space Complexity : O(1);
 * 
 * 
 */

public class FirstnLastPositionofElement {

	public static void main(String[] args) {
		int[] nums1 = {5,7,7,8,8,10};
		int[] nums11 = {5,7,7,8,10};
		int target1 = 8;
		Utilities.printElements(nums1);
		int[] searchFound1 = searchRange(nums1, target1);
		System.out.print("Starting and Ending position of target '" + target1 + "' is : ");
		Utilities.printElements(searchFound1);
		System.out.println();
		
		Utilities.printElements(nums11);
		int[] searchFound11 = searchRange(nums11, target1);
		System.out.print("Starting and Ending position of target '" + target1 + "' is : ");
		Utilities.printElements(searchFound11);
		System.out.println();
		
		
		int[] nums2 = {5,7,7,8,8,10};
		int target2 = 6;
		Utilities.printElements(nums2);
		int[] searchFound2 = searchRange(nums2, target2);
		System.out.print("Starting and Ending position of target '" + target2 + "' is : ");
		Utilities.printElements(searchFound2);
		
		int[] nums3 = {};
		int target3 = 0;
		Utilities.printElements(nums3);
		int[] searchFound3 = searchRange(nums3, target3);
		System.out.print("Starting and Ending position of target '" + target3 + "' is : ");
		Utilities.printElements(searchFound3);

	}
	
	
	
    public static int[] searchRange(int[] nums, int target) {
        int[] searchResult = {-1, -1};
        if(nums.length==0) {
        	return searchResult;
        }
    	
        int floorIndex = findFloorIndex(nums, target);
        searchResult[0] = floorIndex;
        
        int ceilIndex = findCeilIndex(nums, target);
        searchResult[1] = ceilIndex;

    	return searchResult;
    }
    
    
    
    public static int findFloorIndex(int[] nums, int target) {
    	int floorIndex = -1;
    	if(nums.length==0) {
    		return  floorIndex;
    	}
    	
    	
    	int low = 0;
    	int high = nums.length-1;
    	while(low<=high) {
    		int mid = low + (high - low)/2;
    		
    		if(nums[mid] == target) {
    			floorIndex = mid;
    			high = mid-1;
    		} else if(nums[mid] < target){
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    		}
    	}
    	return floorIndex;
    }
    
    
    
    public static int findCeilIndex(int[] nums, int target) {
       int ceilIndex = -1;
       if(nums.length==0) {
   		return  ceilIndex;
       }
   	
   	
	   int low = 0;
	   int high = nums.length-1;
	   while(low<=high) {
	   		int mid = low + (high - low)/2;
	   		
	   		if(nums[mid] == target) {
	   			ceilIndex = mid;
	   			low = mid + 1;
	   		} else if(nums[mid] < target){
	   			low = mid + 1;
	   		} else {
	   			high = mid - 1;
	   		}
	   }
      return ceilIndex;
    }

}




