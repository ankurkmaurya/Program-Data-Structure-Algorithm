package com.ankurmaurya.binarysearch.longsmallmaxmin;

import com.ankurmaurya.binarysearch.utility.Utilities;

/* 
 * Longest Increasing Subsequence
 * 
 * Type : Medium
 * 
 * Given an integer array nums, return the length of the 
 * longest strictly increasing subsequence.
 * 
 * 
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * 
 * 
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * 
 * 
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * 
 * 
 * Constraints:
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * 
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 * 
 * 
 * 
 * Solution:
 * If multiple sequence exists it will replace the existing lower 'nums[i]' in the sequence list 
 * with current 'nums[i]', But this process will always give the correct longest increasing
 * subsequence length. 
 * We can even perform the operation on the same given input array it will give the correct result
 * thus saving space with optimization O(1).
 * 
 * 
 * Time Complexity  : O(nlogn)
 *                    We are iterating on the whole data set and then performing 
 *                    Binary Search on the sequential data set that we are creating
 *                    and using to track the longest increasing sequence.
 *                    
 * Space Complexity : O(n)
 * 					  Sequential data set created to hold the tracking of longest 
 *                    increasing sequence.
 *                    
 * 					  O(1)
 * 	                  We can use and modify the given input nums array to achieve 
 *                    this space optimization
 * 
 */


public class LongestIncreasingSubsequenceLength {

	public static void main(String[] args) {
		int[] nums1 = {4,10,4,3,8,9}; //3 - 3,8,9
		int[] nums11 = {10,9,2,5,3,7,101,18}; //4 - 2,3,7,18
		int[] nums2 = {0,1,0,3,2,3}; //4 - 0,1,2,3
		int[] nums3 = {7,7,7,7,7,7,7}; //1 - 7
		int[] nums4 = {15,14,2,10,9,8,3,4,5,6,7,101,101,18}; //7 - 2,3,4,5,6,7,18
		int[] nums41 = {15,14,2,10,9,8,3,4,5,6,7,101,18}; //7 - 2,3,4,5,6,7,18
		int[] nums5 = {1,3,6,7,9,4,10,5,6}; //6 - 1,3,4,5,6,10
		int[] nums6 = {1,4,7,15,5}; //4 - 1,4,5,15
		
		

		Utilities.printElements(nums1);
		int lenOfLIS1 = lengthOfLIS(nums1);
		System.out.println("Length of Max Seq is '" + lenOfLIS1 + "'");
		System.out.println();

		Utilities.printElements(nums11);
		int lenOfLIS11 = lengthOfLIS(nums11);
		System.out.println("Length of Max Seq is '" + lenOfLIS11 + "'");
		System.out.println();
		
		Utilities.printElements(nums2);
		int lenOfLIS2 = lengthOfLIS(nums2);
		System.out.println("Length of Max Seq is '" + lenOfLIS2 + "'");
		System.out.println();
		
		Utilities.printElements(nums3);
		int lenOfLIS3 = lengthOfLIS(nums3);
		System.out.println("Length of Max Seq is '" + lenOfLIS3 + "'");
		System.out.println();
		
		Utilities.printElements(nums4);
		int lenOfLIS4 = lengthOfLIS(nums4);
		System.out.println("Length of Max Seq is '" + lenOfLIS4 + "'");
		System.out.println();
		
		Utilities.printElements(nums41);
		int lenOfLIS41 = lengthOfLIS(nums41);
		System.out.println("Length of Max Seq is '" + lenOfLIS41 + "'");
		System.out.println();
		
		Utilities.printElements(nums5);
		int lenOfLIS5 = lengthOfLIS(nums5);
		System.out.println("Length of Max Seq is '" + lenOfLIS5 + "'");
		System.out.println();
		
		Utilities.printElements(nums6);
		int lenOfLIS6 = lengthOfLIS(nums6);
		System.out.println("Length of Max Seq is '" + lenOfLIS6 + "'");
		System.out.println();
		
	}
	

	 public static int lengthOfLIS(int[] nums) {
		int lenOfLIS = 0;
	    if(nums.length == 0) {
	    	return lenOfLIS;
	    }
		
	    int increasingSeqTail = -1;
	    int[] increasingSeq = new int[nums.length];
	    
	    for(int i=0; i<nums.length; i++) {
	    	//Utilities.printElements(increasingSeq);
	    	if(increasingSeqTail < 0) {
	    		increasingSeqTail++;
	    		increasingSeq[increasingSeqTail]=nums[0];
	    		continue;
	    	}
	    	
	    	if(nums[i]>increasingSeq[increasingSeqTail]) {
	    		increasingSeq[++increasingSeqTail] = nums[i];
	    	} 
	    	else {
	    		int floorIndex = Utilities.findFloorIndex(increasingSeq, 0, increasingSeqTail, nums[i], false);
	    		if(floorIndex < 0) {
	    			increasingSeq[0]=nums[i];
		    	} else {
			    	increasingSeq[floorIndex+1]=nums[i];
		    	}
	    	}
	    }
	    Utilities.printElements(increasingSeq);
	    
	    lenOfLIS = increasingSeqTail + 1;
	    return lenOfLIS;
	 }
	
	

}




