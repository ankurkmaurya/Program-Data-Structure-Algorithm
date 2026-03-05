package com.ankurmaurya.binarysearch.longsmallmaxmin;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * 
 * Minimum Limit of Balls in a Bag
 * 
 * Type : Medium
 * 
 * 
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
 * You can perform the following operation at most maxOperations times:
 *  - Take any bag of balls and divide it into two new bags with a positive number of balls.
 *    For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
 *    
 * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
 * Return the minimum possible penalty after performing the operations.
 *    
 *    
 * Example 1:
 * Input: nums = [9], maxOperations = 2
 * Output: 3
 * 
 * Explanation: 
 *  - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
 *  - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
 *  The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
 *  
 *  
 * Example 2:
 * Input: nums = [2,4,8,2], maxOperations = 4
 * Output: 2
 * Explanation:
 *  - Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
 *  - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
 *  - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
 *  - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
 *  The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
 *  
 *  
 * Constraints:
 * 1 <= nums.length <= 10 power 5
 * 1 <= maxOperations, nums[i] <= 10 power 9  
 * 
 * 
 * 
 * 
 * Solution:
 * 
 * Optimization:
 *  47ms, Beats 39.97%
 * 
 *  Time Complexity  : O(nlogn) 
 *  As we are performing Binary Search on the Answer it will take O(logn) time and 
 *  for each selected answer we are evaluating the number of operations with
 *  the MAX operations given by performing operation on all the array elements 
 *  with O(n), Hence O(n)*O(logn) = O(nlogn)
 *  
 *  Space Complexity : O(1)
 *  No extra space is taken for the calculation
 * 
 * 
 * 
 */

public class MinimumLimitOfBallsInBag {

	public static void main(String[] args) {
		
		int[] nums1 = {9};
		int maxOperations1 = 2;
		Utilities.printElements(nums1);
		int maxBall1 = minimumSize(nums1, maxOperations1);
		System.out.println("Maximum number of balls '" + maxBall1 + "' after '" + maxOperations1 + "' operations");
		System.out.println();
		
		int[] nums2 = {2,4,8,2};
		int maxOperations2 = 4;
		Utilities.printElements(nums2);
		int maxBall2 = minimumSize(nums2, maxOperations2);
		System.out.println("Maximum number of balls '" + maxBall2 + "' after '" + maxOperations2 + "' operations");
		System.out.println();
		
		int[] nums3 = {18,4,6,2};
		int maxOperations3 = 4;
		Utilities.printElements(nums3);
		int maxBall3 = minimumSize(nums3, maxOperations3);
		System.out.println("Maximum number of balls '" + maxBall3 + "' after '" + maxOperations3 + "' operations");
		System.out.println();
		
	}

	
	public static int minimumSize(int[] nums, int maxOperations) {
		int maxPenalty = 0;
		
		int NUMS_MAX = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]>NUMS_MAX) {
				NUMS_MAX = nums[i];
			}
		}
		
		int low = 1;
		int high = NUMS_MAX;
		while(low<=high) {
			int mid = low + (high-low)/2;
			int possibleMaxOper = calculateMaxOperation(nums, maxOperations, mid);
			if(possibleMaxOper > maxOperations) {
				low = mid+1;
			} else {
				maxPenalty = mid;
				high = mid-1;
			}
		}
		
		return maxPenalty;
	}
	
	
	public static int calculateMaxOperation(int[] nums, int maxOperations, int maxBalls) {
		int operations = 0;
		for(int i=0; i<nums.length; i++) {
			
			
			
			if(nums[i] > maxBalls) {
				/*
				 * This is a Constant operation to determine the number of operations 
				 * required to split the items into groups of equal size k
				 * 
				 */
				
				if(nums[i]%maxBalls==0) {
					operations += nums[i]/maxBalls - 1;
				} else {
					operations += nums[i]/maxBalls;
				}

				/* 
				 * This iterative reduction code will give Time Limit Exceeded (TLE) error 
				 * for large data set to determine the number of operations required to split 
				 * the items into groups of equal size k
				 * 
				 while(bagBalls>maxBalls) {
					bagBalls = bagBalls-maxBalls;
					operations++;
					
					if(operations>maxOperations) {
						break;
					}
				 }
				*
				*/
			}
			
			if(operations > maxOperations) {
				break;
			}
		}
		return operations;
	}

}




