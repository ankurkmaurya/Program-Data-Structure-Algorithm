package com.ankurmaurya.binarysearch.prefixsum;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * Ways to Split Array Into Three Subarrays
 * 
 * Type : Medium
 * 
 * A split of an integer array is good if:
 * 
 * The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
 * The sum of the elements in left is less than or equal to the sum of the elements in mid, 
 * and the sum of the elements in mid is less than or equal to the sum of the elements in right.
 * 
 * Given nums, an array of non-negative integers, return the number of good ways to split nums. 
 * As the number may be too large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1
 * Input: nums = [1,1,1]
 * Output: 1
 * Explanation: The only good way to split nums is [1] [1] [1].
 * 
 * 
 * Example 2:
 * Input: nums = [1,2,2,2,5,0]
 * Output: 3
 * Explanation: There are three good ways of splitting nums:
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * 
 * 
 * Example 3:
 * Input: nums = [3,2,1]
 * Output: 0
 * Explanation: There is no good way to split nums.
 * 
 * 
 * 
 * Constraints:
 *  3 <= nums.length <= 10 power 5
 *  0 <= nums[i] <= 10 power 4
 * 
 * 
 * 
 * Solution:
 * 
 *  Time Complexity  : O(n+2logn)
 *  Space Complexity : O(n)
 * 
 * 
 */






public class WaysToSplitArrayIntoThreeSubarrays {

	
	public static void main(String[] args) {
		solution(new int[] {1,2,2,2,5,0}, 3);
		solution(new int[] {3,2,1}, 0);
		solution(new int[] {1,1,1}, 1);
		solution(new int[] {2,8,10,0,2}, 1);
		solution(new int[] {1,3,9,3,10,5,7,7}, 6);
		solution(new int[] {2,3,2,7,7,1,9,4}, 6);
	}
	
	
	public static void solution(int[] nums, int expectedResult) {
		System.out.print("Nums : ");
		Utilities.printElements(nums);
		int waysToSplit = waysToSplit(nums);
		System.out.println("Ways to split above array is '" + waysToSplit + "', Assert : " + (expectedResult==waysToSplit));
		System.out.println();
	}
	
	
    public static int waysToSplit(int[] nums) {
        long goodWaysToSplit = 0;
        long[] prefixSum = new long[nums.length];   
        prefixSum[0] = nums[0];
        for(int p=1; p<nums.length; p++) {
        	prefixSum[p] = nums[p] + prefixSum[p-1];
        }
        
        for(int i=0; i<(nums.length-1); i++) {
        	long firstArraySum = prefixSum[i];
        	long secondArraySum = prefixSum[nums.length-1] - prefixSum[i];
        	if(firstArraySum<=secondArraySum) {
        		goodWaysToSplit += possibleSplitsInHalf(nums, i+1, firstArraySum, prefixSum);
        	}
        }

        return (int)(goodWaysToSplit % (Math.pow(10, 9) + 7));
    }
    
    
    public static long possibleSplitsInHalf(int[] nums, int startIndex, long firstArraySum, long[] prefixSum) {
    	long possibleSplitsInHalfCount = 0;

    	int lowestSplitIndex = lowestPossibleHalfSplitIndex(nums, startIndex, firstArraySum, prefixSum);
    	int highestSplitIndex = highestPossibleHalfSplitIndex(nums, startIndex, firstArraySum, prefixSum);
    	if(lowestSplitIndex == -1 && highestSplitIndex ==-1) {
    		possibleSplitsInHalfCount = 0;
    	} 
    	else if(lowestSplitIndex == highestSplitIndex) {
    		possibleSplitsInHalfCount = 1;
    	} 
    	else if(highestSplitIndex == -1) {
    		possibleSplitsInHalfCount = 0;
    	} 
    	else if(lowestSplitIndex == -1 && highestSplitIndex > 0) {
    		possibleSplitsInHalfCount = 1;
    	}
    	else if(highestSplitIndex>lowestSplitIndex) {
    		possibleSplitsInHalfCount = highestSplitIndex - (lowestSplitIndex-1);
    	}
    	
    	return possibleSplitsInHalfCount;
    }
    
    

    public static int lowestPossibleHalfSplitIndex(int[] nums, int startIndex, long firstArraySum, long[] prefixSum) {
    	int lowestSplitIndex = -1;
    	
    	int low = startIndex;
    	int high = nums.length -2;
    	while(low<=high) {
    		int mid = low + (high- low)/2;
    		long leftArraySum = prefixSum[mid] - firstArraySum;
    	    long rightArraySum = prefixSum[nums.length-1] - prefixSum[mid];
    	    
    	    //System.out.println(firstArraySum +" <= " + leftArraySum +" <= " + rightArraySum + " M-"+ mid);
    	    
    	    if(firstArraySum<=leftArraySum && leftArraySum<=rightArraySum) {
    	    	lowestSplitIndex = mid;
    	    	high=mid-1;
    	    } 
    	    else if(leftArraySum > rightArraySum) {
    	    	high=mid-1;
    	    }
    	    else {
    	    	low = mid+1;
    	    }
    	}
    	return lowestSplitIndex;
    }
    
    public static int highestPossibleHalfSplitIndex(int[] nums, int startIndex, long firstArraySum, long[] prefixSum) {
    	int highestSplitIndex = -1;
    	
    	int low = startIndex;
    	int high = nums.length -2;
    	while(low<=high) {
    		int mid = low + (high- low)/2;
    		long leftArraySum = prefixSum[mid] - firstArraySum;
    	    long rightArraySum = prefixSum[nums.length-1] - prefixSum[mid];
    	    
    	    //System.out.println(firstArraySum +" <= " + leftArraySum +" <= " + rightArraySum + " M-"+ mid);
    	    
    	    if(firstArraySum<=leftArraySum && leftArraySum<=rightArraySum) {
    	    	highestSplitIndex = mid;
    	    	low = mid+1;
    	    } 
    	    else if(firstArraySum > leftArraySum) {
    	    	low = mid+1;
    	    }
    	    else {
    	    	high=mid-1;
    	    }
    	}
    	return highestSplitIndex;
    }
    

}




