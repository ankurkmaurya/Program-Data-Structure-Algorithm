package com.ankurmaurya.binarysearch.longsmallmaxmin;


import com.ankurmaurya.binarysearch.utility.Utilities;


/*
 * Minimum Size Subarray Sum
 * 
 * Type : Medium
 * 
 * Given an array of positive integers nums and a positive integer target, 
 * return the minimal length of a subarray whose sum is greater than or equal to target. 
 * If there is no such subarray, return 0 instead.
 * 
 * 
 * 
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 1 <= target <= 10 power 9
 * 1 <= nums.length <= 10 power 5
 * 1 <= nums[i] <= 10 power 4
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another 
 * solution of which the time complexity is O(n log(n)).
 * 
 * 
 * Solution:
 * 
 * Time Complexity:
 *  O(n) : Sliding Window, Two Pointer
 *  
 * 
 * Space Complexity: O(1)
 * 
 * 
 * 
 */



public class MinimumSizeSubarraySum {

	
	public static void main(String[] args) {
		
		int[] nums1 = {2,3,1,2,4,3};
		int target1 = 7;
		Utilities.printElements(nums1);
		int len1 = minSubArrayLen(target1, nums1);
		System.out.println("Minimum sub-array size for Sum '" + target1 + "' is '" + len1 + "'");
		System.out.println();
		
		int[] nums2 = {1,4,4};
		int target2 = 4;
		Utilities.printElements(nums2);
		int len2 = minSubArrayLen(target2, nums2);
		System.out.println("Minimum sub-array size for Sum '" + target2 + "' is '" + len2 + "'");
		System.out.println();
		
		int[] nums3 = {1,2,3,4,5};
		int target3 = 11;
		Utilities.printElements(nums3);
		int len3 = minSubArrayLen(target3, nums3);
		System.out.println("Minimum sub-array size for Sum '" + target3 + "' is '" + len3 + "'");
		System.out.println();
		
		int[] nums4 = {1,2,3,4,5};
		int target4 = 15;
		Utilities.printElements(nums4);
		int len4 = minSubArrayLen(target4, nums4);
		System.out.println("Minimum sub-array size for Sum '" + target4 + "' is '" + len4 + "'");
		System.out.println();
		
		int[] nums5 = {12,28,83,4,25,26,25,2,25,25,25,12};
		int target5 = 213;
		Utilities.printElements(nums5);
		int len5 = minSubArrayLen(target5, nums5);
		System.out.println("Minimum sub-array size for Sum '" + target5 + "' is '" + len5 + "'");
		System.out.println();
		
		
		int[] nums6 = {5,1,3,5,10,7,4,9,2,8};
		int target6 = 15; //exp 2
		Utilities.printElements(nums6);
		int len6 = minSubArrayLen(target6, nums6);
		System.out.println("Minimum sub-array size for Sum '" + target6 + "' is '" + len6 + "'");
		System.out.println();
		
		
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		for(int k=1; k<nums.length; k++) {
			prefixSum[k] = prefixSum[k-1] + nums[k];
		}
		
		
		int minLen = Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++) {
			int targeSubArrayEndIndex = findSubArrayEndIndex(target, nums, prefixSum, i);
			if(targeSubArrayEndIndex == -1 || targeSubArrayEndIndex < i) {
				continue;
			}
			int currentSubArrayLength = (targeSubArrayEndIndex - i) + 1;
    		minLen = currentSubArrayLength < minLen ? currentSubArrayLength : minLen;
		}
		if(minLen == Integer.MAX_VALUE) {
        	return 0;
        }
		return minLen;
	}
	
	public static int findSubArrayEndIndex(int target, int[] nums, int[] prefixSum, int startIndex) {
		int endIndex = -1;
		int low = startIndex;
		int high = nums.length-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			
			int totalSum = 0;
			if(startIndex==0) {
				totalSum = prefixSum[mid];
			} else {
				totalSum = prefixSum[mid] - prefixSum[startIndex-1];
			}
			
			if(totalSum==target) {
				endIndex = mid;
			    break;
			}
			else if(totalSum<target) {
				low=mid+1;
			} else {
				endIndex = mid;
				high=mid-1;
			}
		}
		return endIndex;
	}
	
	
	
    public static int minSubArrayLenOrderN(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        
        int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		for(int k=1; k<nums.length; k++) {
			prefixSum[k] = prefixSum[k-1] + nums[k];
		}
        
        int startIndex = 0;
        int endIndex = 0;
        while(endIndex<nums.length) {
        	if(nums[endIndex] == target) {
        		return 1;
        	}
        	
        	int totalSum = 0;
			if(startIndex==0) {
				totalSum = prefixSum[endIndex];
			} else {
				totalSum = prefixSum[endIndex] - prefixSum[startIndex-1];
			}
			
        	if(totalSum<target) {
        		endIndex++;
        	}
        	else {
        		int currentSubArrayLength = (endIndex - startIndex) + 1;
        		minLen = currentSubArrayLength < minLen ? currentSubArrayLength : minLen;
        		startIndex++;
        	}
        }
        
        
        if(minLen == Integer.MAX_VALUE) {
        	return 0;
        }
        return minLen;
    }
	

}


