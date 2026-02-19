package com.ankurmaurya.dp;

//import com.ankurmaurya.binarysearch.utility.Utilities;
//
///* 
// * Longest Increasing Subsequence II
// * 
// * Type : Hard
// * 
// * 
// * You are given an integer array nums and an integer k.
// * 
// * Find the longest subsequence of nums that meets the following requirements:
// *  a. The subsequence is strictly increasing and
// *  b. The difference between adjacent elements in the subsequence is at most k.
// * 
// * Return the length of the longest subsequence that meets the requirements.
// * 
// * A subsequence is an array that can be derived from another array by deleting 
// * some or no elements without changing the order of the remaining elements.
// * 
// * 
// * Example 1:
// * Input: nums = [4,2,1,4,3,4,5,8,15], k = 3
// * Output: 5
// * 
// * Explanation:
// * The longest subsequence that meets the requirements is [1,3,4,5,8].
// * The subsequence has a length of 5, so we return 5.
// * Note that the subsequence [1,3,4,5,8,15] does not meet the requirements because 15 - 8 = 7 is larger than 3.
// * 
// * 
// * Example 2:
// * Input: nums = [7,4,5,1,8,12,4,7], k = 5
// * Output: 4
// * 
// * Explanation:
// * The longest subsequence that meets the requirements is [4,5,8,12].
// * The subsequence has a length of 4, so we return 4.
// * 
// * 
// * Example 3:
// * Input: nums = [1,5], k = 1
// * Output: 1
// * 
// * Explanation:
// * The longest subsequence that meets the requirements is [1].
// * The subsequence has a length of 1, so we return 1.
// * 
// * 
// * Constraints:
// * 1 <= nums.length <= 105
// * 1 <= nums[i], k <= 105
// * 
// * 
// * 
// * Solution:
// * Time Complexity  : O(nlogn)
// *                    We are iterating on the whole data set and then performing 
// *                    Binary Search on the sequential data set that we are creating
// *                    and using to track the longest increasing sequence.
// *                    
// * Space Complexity : O(n)
// * 					  Sequential data set created to hold the tracking of longest 
// *                    increasing sequence.
// *                    
// * 					  O(1)
// * 	                  We can use and modify the given input nums array to achieve 
// *                    this space optimization
// * 
// */
//
//public class LongestIncreasingSubsequenceLength2Failed {
//
//	public static void main(String[] args) {
//		int[] nums1 = {4,2,1,4,3,4,5,8,15}; 
//		int k1 = 3;
//				
//		int[] nums2 = {7,4,5,1,8,12,4,7}; 
//		int k2 = 5;
//		
//		int[] nums3 = {1,5};
//		int[] nums31 = {1,3,3,4};
//		int[] nums32 = {1,4,7,15,5};
//		int k3 = 1;
//		
//		/*
//		Utilities.printElements(nums1);
//		int lenOfLIS1 = lengthOfLIS(nums1, k1);
//		System.out.println("Length of Max Seq meets requirement is '" + lenOfLIS1 + "'");
//		System.out.println();
//		
//		Utilities.printElements(nums2);
//		int lenOfLIS2 = lengthOfLIS(nums2, k2);
//		System.out.println("Length of Max Seq meets requirement is '" + lenOfLIS2 + "'");
//		System.out.println();
//		
//		Utilities.printElements(nums3);
//		int lenOfLIS3 = lengthOfLIS(nums3, k3);
//		System.out.println("Length of Max Seq meets requirement is '" + lenOfLIS3 + "'");
//		System.out.println();
//		
//		Utilities.printElements(nums31);
//		int lenOfLIS31 = lengthOfLIS(nums31, k3);
//		System.out.println("Length of Max Seq meets requirement is '" + lenOfLIS31 + "'");
//		System.out.println();
//		*/
//		Utilities.printElements(nums32);
//		int lenOfLIS32 = lengthOfLIS(nums32, k3);
//		System.out.println("Length of Max Seq meets requirement is '" + lenOfLIS32 + "'");
//		System.out.println();
//
//	}
//	
//	
//	
//	public static int lengthOfLIS(int[] nums, int k) {
//		int lenOfLIS = 0;
//	    if(nums.length == 0) {
//	    	return lenOfLIS;
//	    }
//		
//	    int increasingSeqTail = -1;
//	    int[] increasingSeq = new int[nums.length];
//	    
//	    for(int i=0; i<nums.length; i++) {
//	    	Utilities.printElements(increasingSeq);
//	    	if(increasingSeqTail < 0) {
//	    		increasingSeqTail++;
//	    		increasingSeq[increasingSeqTail]=nums[0];
//	    		continue;
//	    	}
//	    	
//	    	int diff = nums[i] - increasingSeq[increasingSeqTail];
//	    	if(nums[i]>increasingSeq[increasingSeqTail]) {
//	    		if(diff<=k) {
//	    			increasingSeq[++increasingSeqTail] = nums[i];
//	    		} else {
//	    			increasingSeq[increasingSeqTail] = nums[i];
//	    		}
//	    	} 
//	    	else {
//	    		int floorIndex = Utilities.findFloorIndex(increasingSeq, 0, increasingSeqTail, nums[i], false);
//	    		if(floorIndex < 0) {
//	    			increasingSeq[0]=nums[i];
//		    	} else {
//		    		if(diff<=k) {
//		    		   increasingSeq[floorIndex+1]=nums[i];
//		    		} else {
//		    		   increasingSeq[floorIndex]=nums[i];
//		    		}
//		    	}
//	    	}
//	    }
//	    Utilities.printElements(increasingSeq);
//	    
//	    lenOfLIS = increasingSeqTail + 1;
//	    return lenOfLIS;
//	 }
//
//	
//}







